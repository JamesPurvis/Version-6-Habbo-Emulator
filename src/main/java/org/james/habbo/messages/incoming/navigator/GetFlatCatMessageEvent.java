package org.james.habbo.messages.incoming.navigator;

import org.james.habbo.messages.outgoing.navigator.HandleFlatCatMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class GetFlatCatMessageEvent implements MessageEvent {

    private Logger mLogger = LogManager.getLogManager().getLogger(GetFlatCatMessageEvent.class.getName());
    @Override
    public void invokeEvent(Request request, GameSession session) {
        try
        {
             Long mRoomID = Long.parseLong(String.valueOf(request.popInteger()));
            session.sendToSession(new HandleFlatCatMessageComposer(mRoomID));
        }
        catch(Exception e)
        {
            mLogger.info(e.getMessage());
        }
    }
}
