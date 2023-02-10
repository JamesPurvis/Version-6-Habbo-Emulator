package org.james.habbo.messages.incoming.navigator;

import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

public class NavigateMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {
        int mCategoryID = request.popInteger();
    }
}
