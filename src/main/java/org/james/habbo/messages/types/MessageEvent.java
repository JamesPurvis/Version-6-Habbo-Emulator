package org.james.habbo.messages.types;

import org.james.habbo.messages.ReactorService;
import org.james.habbo.net.session.GameSession;

public interface MessageEvent
{
    void invokeEvent(Request request, GameSession session);
}
