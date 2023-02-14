package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.navigator.models.RoomEntity;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;

public class HandleFlatCatMessageComposer implements MessageComposer {

    private RoomEntity mInstance;
    public HandleFlatCatMessageComposer(Long roomID)
    {
        this.mInstance = NavigatorRepositoryImpl.getInstance().findRoomById(roomID);
    }
    @Override
    public void compose(Response response) {
        response.writeInt(Math.toIntExact(mInstance.getFlat_id()));
        response.writeInt(mInstance.getFlat_category_id());
    }

    @Override
    public short returnID() {
        return 222;
    }
}
