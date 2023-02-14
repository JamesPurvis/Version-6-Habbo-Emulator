package org.james.habbo.messages.incoming.navigator;

import org.james.habbo.messages.outgoing.navigator.FlatInfoReplyMessageComposer;
import org.james.habbo.messages.outgoing.navigator.NavNodeInfoMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

public class GetFlatInfoMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {
        Long mRoomID = Long.parseLong(request.contents());
        session.sendToSession(new FlatInfoReplyMessageComposer(mRoomID));
    }
}
