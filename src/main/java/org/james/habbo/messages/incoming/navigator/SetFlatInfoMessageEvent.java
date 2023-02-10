package org.james.habbo.messages.incoming.navigator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;
import org.james.habbo.net.session.GameSession;

public class SetFlatInfoMessageEvent implements MessageEvent {

    private static Logger mLogger = LogManager.getLogger(SetFlatInfoMessageEvent.class.getName());
    @Override
    public void invokeEvent(Request request, GameSession session) {

            String[] mRoomLines = request.contents().split(Character.toString((char)13));
            Long mRoomID = Long.parseLong(mRoomLines[0].split("/")[1]);
            String mRoomDescription = mRoomLines[1].split("=")[1];
            String mRoomPassword = mRoomLines[2].split("=")[1];
            boolean mRoomSuper = mRoomLines[3].split("=")[1].equals("1");

            NavigatorRepositoryImpl.getInstance().SetFlatInfo(mRoomID, mRoomDescription, mRoomPassword, mRoomSuper);

    }
}
