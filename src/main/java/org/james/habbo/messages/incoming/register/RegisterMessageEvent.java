package org.james.habbo.messages.incoming.register;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.avatars.AvatarRepositoryImpl;
import org.james.habbo.messages.outgoing.register.RegistrationOkComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;
import org.james.habbo.util.RegistrationParser;

public class RegisterMessageEvent implements MessageEvent {

    private Logger mLogger = LogManager.getLogger(RegisterMessageEvent.class.getName());
    @Override
    public void invokeEvent(Request request, GameSession session) {
        try
        {
            session.setAvatar(AvatarRepositoryImpl.getInstance().createNewAvatar(RegistrationParser.returnPropertyBox(request)));
            mLogger.info(session.AvatarInstance().getUsername() + " " + "has registered on the client!");
            session.sendToSession(new RegistrationOkComposer());
        }

        catch(Exception e)
        {
            mLogger.error(e.getMessage());
        }
    }
}
