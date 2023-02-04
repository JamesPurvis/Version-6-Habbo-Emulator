package org.james.habbo.net.session;

import io.netty.channel.Channel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class GameSessionFactory
{
    private static Logger mLogger = LogManager.getLogger(GameSessionFactory.class.getName());
    private static GameSessionFactory mInstance;

    private AtomicInteger mConnectedClientCount;
    public GameSessionFactory()
    {

        mLogger.info("Session manager instantiated successfully.");
    }

    public static GameSessionFactory getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new GameSessionFactory();
        }

        return mInstance;
    }

    public GameSession createNewSession(Channel c)
    {
        long mID = mConnectedClientCount.incrementAndGet();

        GameSession mSession = new GameSession(c, mID);

        return mSession;
    }
}
