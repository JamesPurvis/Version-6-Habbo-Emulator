package org.james.habbo.net.codecs;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.util.StringUtil;

import java.util.List;

public class ServerEncoder extends MessageToMessageEncoder<MessageComposer> {

    private static Logger mLogger = LogManager.getLogger(ServerEncoder.class.getName());
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageComposer messageComposer, List<Object> list) throws Exception {

        ByteBuf mBuffer = channelHandlerContext.alloc().buffer();

        Response mResponse = new Response(messageComposer.returnID(), mBuffer);

        try
        {
            messageComposer.compose(mResponse);
        }
        catch(Exception e)
        {
            mLogger.error("Unable to compose message for " + messageComposer.returnID());
        }

        mBuffer.writeByte(1);


        mLogger.info(("SENT[" + mResponse.ID() + "] " + "[" +  mResponse.getBodyString() + "]"));

        list.add(mBuffer);
    }
}
