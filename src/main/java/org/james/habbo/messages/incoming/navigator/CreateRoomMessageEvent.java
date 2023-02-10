package org.james.habbo.messages.incoming.navigator;

import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.messages.outgoing.navigator.FlatCreatedMessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;
import org.james.habbo.net.session.GameSession;

public class CreateRoomMessageEvent implements MessageEvent
{

    private static Logger mLogger = LogManager.getLogger(CreateRoomMessageEvent.class.getName());
    @Override
    public void invokeEvent(Request request, GameSession session) {

        String[] mRoomInformation = request.getMessageBody().split("/");

        String mRoomOwner = session.getAvatar().getUsername();
        String mRoomName = mRoomInformation[2];
        String mRoomModel = mRoomInformation[3];
        String mRoomDoor = mRoomInformation[4];
        boolean mShowOwner = mRoomInformation[5].equals("1");

       Long mRoomID = NavigatorRepositoryImpl.getInstance().createNewRoom(mRoomName, mRoomModel, mRoomDoor, mShowOwner, mRoomOwner);

        session.sendToSession(new FlatCreatedMessageComposer(mRoomID, mRoomName));


    }
}
