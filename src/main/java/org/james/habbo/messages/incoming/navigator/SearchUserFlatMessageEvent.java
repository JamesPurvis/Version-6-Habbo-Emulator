package org.james.habbo.messages.incoming.navigator;

import org.james.habbo.messages.outgoing.navigator.UserFlatResultsMessageComposer;
import org.james.habbo.messages.outgoing.navigator.NoFlatsForUserMessageCompser;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.navigator.models.RoomEntity;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;
import org.james.habbo.net.session.GameSession;

import java.util.List;

public class SearchUserFlatMessageEvent implements MessageEvent {
    @Override
    public void invokeEvent(Request request, GameSession session) {
        String mUsername = request.contents();
        List<RoomEntity> mRooms = NavigatorRepositoryImpl.getInstance().findRoomsByOwner(mUsername);

        if (!mRooms.isEmpty())
        {
            session.sendToSession(new UserFlatResultsMessageComposer(mRooms));
        }
        else
        {
            session.sendToSession(new NoFlatsForUserMessageCompser());
        }
    }
}
