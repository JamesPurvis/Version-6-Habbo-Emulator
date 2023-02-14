package org.james.habbo.messages.incoming.navigator;

import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;
import org.james.habbo.net.session.GameSession;

public class UpdateFlatMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {

        String[] mRoomDetails = request.contents().split("/");
        NavigatorRepositoryImpl.getInstance().UpdateFlatInfo(Long.parseLong(mRoomDetails[0]), mRoomDetails[1], mRoomDetails[2], mRoomDetails[3].equals("1"));
    }
}
