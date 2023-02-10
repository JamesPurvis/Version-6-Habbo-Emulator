package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.navigator.models.RoomEntity;

import java.util.List;

public class UserFlatResultsMessageComposer implements MessageComposer {

    private List<RoomEntity> mList;

    public UserFlatResultsMessageComposer(List<RoomEntity> list)
    {
        this.mList = list;
    }
    @Override
    public void compose(Response response) {

        for(RoomEntity room : mList)
        {
            response.write(room.getFlat_id());
            response.write((char)9);
            response.write(room.getFlat_name());
            response.write((char)9);
            if (room.getFlat_show_owner() == true) response.write(room.getFlat_owner());
            if (room.getFlat_show_owner() == false) response.write("-");
            response.write((char)9);
            response.write(room.getFlat_door());
            response.write((char)9);
            response.write("x");
            response.write((char)9);
            response.write(room.getFlat_active_users());
            response.write((char)9);
            response.write("null");
            response.write((char)9);
            response.write(room.getFlat_description());
            response.write((char)9);
            response.write((char)13);
        }
    }

    @Override
    public short returnID() {
        return 16;
    }
}
