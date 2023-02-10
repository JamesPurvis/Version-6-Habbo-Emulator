package org.james.habbo.messages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.messages.incoming.global.CheckVersionMessageEvent;
import org.james.habbo.messages.incoming.global.FindUserMessageEvent;
import org.james.habbo.messages.incoming.global.GetAvaliableSetsMessageEvent;
import org.james.habbo.messages.incoming.global.GetDateMessageEvent;
import org.james.habbo.messages.incoming.login.GetCreditsMessageEvent;
import org.james.habbo.messages.incoming.login.GetInfoMessageEvent;
import org.james.habbo.messages.incoming.login.TryLoginMessageEvent;
import org.james.habbo.messages.incoming.navigator.SearchUserFlatMessageEvent;
import org.james.habbo.messages.incoming.navigator.SetFlatInfoMessageEvent;
import org.james.habbo.messages.incoming.register.ApproveNameMessageEvent;
import org.james.habbo.messages.incoming.register.RegisterMessageEvent;
import org.james.habbo.messages.incoming.navigator.CreateRoomMessageEvent;
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
        mReactors.put(9, new GetAvaliableSetsMessageEvent());
        mReactors.put(49, new GetDateMessageEvent());
        mReactors.put(42, new ApproveNameMessageEvent());
        mReactors.put(41, new FindUserMessageEvent());
        mReactors.put(43, new RegisterMessageEvent());
        mReactors.put(4, new TryLoginMessageEvent());
        mReactors.put(7, new GetInfoMessageEvent());
        mReactors.put(8, new GetCreditsMessageEvent());
        mReactors.put(29, new CreateRoomMessageEvent());
        mReactors.put(25, new SetFlatInfoMessageEvent());
        mReactors.put(16, new SearchUserFlatMessageEvent());
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
