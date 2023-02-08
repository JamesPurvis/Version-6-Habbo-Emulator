package org.james.habbo.messages.incoming.global;
import org.james.habbo.messages.outgoing.global.ErrorMessageComposer;
import org.james.habbo.messages.outgoing.global.SecretKeyMessageComposer;
import org.james.habbo.messages.types.*;
import org.james.habbo.net.session.GameSession;

public class CheckVersionMessageEvent implements MessageEvent
{
    public void invokeEvent(Request request, GameSession session)
    {
        session.sendToSession(new SecretKeyMessageComposer());
    }
}
