package org.james.habbo.messages.incoming.login;

import io.netty.util.AttributeKey;
import org.james.habbo.avatars.AvatarRepositoryImpl;
import org.james.habbo.messages.outgoing.global.ErrorMessageComposer;
import org.james.habbo.messages.outgoing.login.LoginOkMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;

public class TryLoginMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {
        try
        {
            String mUsername = request.popString();
            String mPassword = request.popString();

            if (AvatarRepositoryImpl.getInstance().tryLogin(mUsername, mPassword))
            {
                session.Channel().attr(AttributeKey.valueOf("Avatar")).set(AvatarRepositoryImpl.getInstance().findByName(mUsername));
                session.sendToSession(new LoginOkMessageComposer());
            }
            else
            {
                session.sendToSession(new ErrorMessageComposer("login incorrect"));
            }
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
