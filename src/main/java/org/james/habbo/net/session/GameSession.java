package org.james.habbo.net.session;

import io.netty.channel.Channel;
import org.james.habbo.avatars.AvatarEntity;
import java.net.SocketAddress;

public class GameSession
{
    private long mSessionID;
    private AvatarEntity mAvatarInstance;
    private Channel mChannel;

    public long ID()
    {
        return mSessionID;
    }

    public AvatarEntity AvatarInstance()
    {
        return mAvatarInstance;
    }

    public SocketAddress IP()
    {
        return mChannel.localAddress();
    }

    public String IPtoString()
    {
        return IP().toString();
    }

    public Channel Channel()
    {
        return mChannel;
    }

    public GameSession(Channel c, long sessionID)
    {
        this.mChannel = c;
        this.mSessionID = sessionID;
    }
}
