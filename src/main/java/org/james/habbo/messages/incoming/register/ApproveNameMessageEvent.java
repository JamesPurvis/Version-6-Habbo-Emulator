package org.james.habbo.messages.incoming.register;

import org.james.habbo.avatars.AvatarRepositoryImpl;
import org.james.habbo.messages.outgoing.register.HandleNameApprovedComposer;
import org.james.habbo.messages.outgoing.register.HandleNameUnacceptableComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;
import org.james.habbo.util.*;

import java.rmi.server.ExportException;

public class ApproveNameMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {

        if (StringUtil.filterName(request.popString()))
        {
            session.sendToSession(new HandleNameApprovedComposer());
        }
        else
        {
            session.sendToSession(new HandleNameUnacceptableComposer());
        }
    }
}
