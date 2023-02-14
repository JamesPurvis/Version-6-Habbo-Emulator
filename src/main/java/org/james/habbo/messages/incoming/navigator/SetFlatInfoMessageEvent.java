package org.james.habbo.messages.incoming.navigator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;
import org.james.habbo.net.session.GameSession;

import java.util.HashMap;

public class SetFlatInfoMessageEvent implements MessageEvent {

    private static Logger mLogger = LogManager.getLogger(SetFlatInfoMessageEvent.class.getName());
    @Override
    public void invokeEvent(Request request, GameSession session) {
        try
        {
            String[] mRoomLines = request.contents().split(String.valueOf((char)13));

            Long mRoomID = Long.parseLong(mRoomLines[0].replace("/", ""));
            String mRoomDescription = mRoomLines[1].replace("description=", "");
            String mRoomPassword = mRoomLines[2].replace("password=", "");
            boolean mSuperUsers = mRoomLines[3].replace("allsuperuser=", "").equals("1");

            NavigatorRepositoryImpl.getInstance().SetFlatInfo(mRoomID, mRoomDescription, mRoomPassword, mSuperUsers);
        }
        catch(Exception e)
        {
            mLogger.info(e.getMessage());
        }

    }
}
