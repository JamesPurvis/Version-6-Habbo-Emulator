package org.james.habbo.messages.incoming.global;

import org.james.habbo.messages.outgoing.global.GetDateMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

public class GetDateMessageEvent implements MessageEvent
{

    @Override
    public void invokeEvent(Request request, GameSession session) {
        session.sendToSession(new GetDateMessageComposer());
    }
}
