package org.james.habbo.messages.incoming.global;

import org.apache.logging.log4j.LogManager;
import org.james.habbo.avatars.AvatarRepositoryImpl;
import org.james.habbo.messages.outgoing.global.HandleMemberInfoComposer;
import org.james.habbo.messages.outgoing.global.NoSuchUserMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;
import org.apache.logging.log4j.*;
public class FindUserMessageEvent implements MessageEvent {

    private static Logger mLogger = LogManager.getLogger(FindUserMessageEvent.class.getName());
    @Override
    public void invokeEvent(Request request, GameSession session) {

            String[] mContents = request.contents().split("\t");

            String mUserName = mContents[0];
            String mMode = mContents[1];

            if (AvatarRepositoryImpl.getInstance().avatarExists(mUserName))
            {
                session.sendToSession(new HandleMemberInfoComposer(mMode));
            }
            else
            {
                session.sendToSession(new NoSuchUserMessageComposer(mMode));
            }

    }
}
