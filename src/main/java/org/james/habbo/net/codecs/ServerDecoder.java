package org.james.habbo.net.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.encoding.Base64Encoding;
import org.james.habbo.messages.ReactorService;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

import java.util.List;

public class ServerDecoder extends ByteToMessageDecoder
{

    private static Logger mLogger = LogManager.getLogger(ServerDecoder.class.getName());
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf input, List<Object> list) throws Exception {

        if (input.readableBytes() < 5)
        {
            return;
        }

        input.markReaderIndex();

        int mLength = Base64Encoding.decode(new byte[] {input.readByte(), input.readByte(), input.readByte()});

        if (input.readableBytes() < mLength)
        {
            input.resetReaderIndex();
        }

        if (mLength < 0)
        {
            return;
        }

        Request HabboRequest = new Request(input, mLength);

        mLogger.info("[RECV] " + "[" + HabboRequest.ID() + "] " + "[" + HabboRequest.toString() + "]");

        ReactorService.getInstance().invokeReactor(HabboRequest, (GameSession)ctx.attr(AttributeKey.valueOf("Session")).get());

        list.add(HabboRequest);

    }
}
