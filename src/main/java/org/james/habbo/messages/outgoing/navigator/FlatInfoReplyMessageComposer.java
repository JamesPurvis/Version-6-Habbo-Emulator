package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.navigator.models.RoomEntity;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;

public class FlatInfoReplyMessageComposer implements MessageComposer {

    private RoomEntity mRoomInstance;

    public FlatInfoReplyMessageComposer(Long roomID)
    {
        this.mRoomInstance = NavigatorRepositoryImpl.getInstance().findRoomById(roomID);
    }
    @Override
    public void compose(Response response) {
        if (mRoomInstance.isFlat_super_rights() == true) response.writeInt(1);
        if (mRoomInstance.isFlat_super_rights() == false) response.writeInt(0);
        if (mRoomInstance.getFlat_door().equals("open")) response.writeInt(0);
        if (mRoomInstance.getFlat_door().equals("closed")) response.writeInt(1);
        if (mRoomInstance.getFlat_door().equals("password")) response.writeInt(2);
        response.writeInt(Math.toIntExact(mRoomInstance.getFlat_id()));
        response.writeString(mRoomInstance.getFlat_owner());
        response.writeString(mRoomInstance.getFlat_model());
        response.writeString(mRoomInstance.getFlat_name());
        response.writeString(mRoomInstance.getFlat_description());
        if (mRoomInstance.getFlat_show_owner() == true) response.writeInt(1);
        if (mRoomInstance.getFlat_show_owner() == false) response.writeInt(0);
        response.writeInt(0);
        if (mRoomInstance.getFlat_category_id() == 0) response.writeInt(1);
        if (mRoomInstance.getFlat_category_id() > 0) response.writeInt(0);
    }

    @Override
    public short returnID() {
        return 54;
    }
}
