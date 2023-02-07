package org.james.habbo.messages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.messages.incoming.CheckVersionMessageEvent;
import org.james.habbo.messages.types.MessageEvent;

import java.util.HashMap;

import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

public class ReactorService
{

    private HashMap<Integer, MessageEvent> mReactors = null;
    private static ReactorService mInstance = null;
    private static Logger mLogger = LogManager.getLogger(ReactorService.class.getName());


    public void loadIntialReactors()
    {
        mReactors = new HashMap<Integer, MessageEvent>();
        mReactors.put(5, new CheckVersionMessageEvent());
    }

    public void invokeReactor(Request Request, GameSession session)
    {
        try
        {
            mReactors.get(Request.ID()).invokeEvent(Request, session);
        }
        catch(Exception e)
        {
            mLogger.error("Unable to invoke message event with ID: "  + Request.ID());
        }
    }

    public static ReactorService getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new ReactorService();
        }

        return mInstance;
    }
}
