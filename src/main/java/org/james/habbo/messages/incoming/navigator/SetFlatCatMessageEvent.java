package org.james.habbo.messages.incoming.navigator;

import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;
import org.james.habbo.net.session.GameSession;

public class SetFlatCatMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {

        Long mRoomID = Long.parseLong(String.valueOf(request.popInteger()));
        int mCategoryID = request.popInteger();
        NavigatorRepositoryImpl.getInstance().SetFlatCat(mRoomID, mCategoryID);
    }
}
