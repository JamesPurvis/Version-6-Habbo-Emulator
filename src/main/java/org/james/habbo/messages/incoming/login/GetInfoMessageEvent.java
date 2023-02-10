package org.james.habbo.messages.incoming.login;

import io.netty.util.AttributeKey;
import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.avatars.AvatarRepositoryImpl;
import org.james.habbo.messages.outgoing.login.UserObjectMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

public class GetInfoMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {
        session.sendToSession(new UserObjectMessageComposer((AvatarEntity) session.Channel().attr(AttributeKey.valueOf("Avatar")).get()));
    }
}
