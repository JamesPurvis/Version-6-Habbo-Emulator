package org.james.habbo.net.session;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.util.StringUtil;
import org.apache.logging.log4j.*;

import java.net.SocketAddress;

public class GameSession
{
    private static Logger mLogger = LogManager.getLogger(GameSession.class.getName());
    private long mSessionID;
    private Channel mChannel;

    public long ID()
    {
        return mSessionID;
    }

    public SocketAddress IP()
    {
        return mChannel.remoteAddress();
    }

    public String IPtoString()
    {
        return IP().toString();
    }

    public Channel Channel()
    {
        return mChannel;
    }

    public AvatarEntity getAvatar()
    {
        return (AvatarEntity) Channel().attr(AttributeKey.valueOf("Avatar")).get();
    }

    public GameSession(Channel c, long sessionID)
    {
        this.mChannel = c;
        this.mSessionID = sessionID;
    }

    public void Hello() {
        mChannel.writeAndFlush(Unpooled.copiedBuffer(StringUtil.getEncoding().encode("@@"  + (char) 1)));
        mLogger.info("Client[" + IPtoString() + "] " + "said hello!");

    }

    public void sendToSession(Object o)
    {
        this.mChannel.writeAndFlush(o);
    }
}
