package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class FlatCreatedMessageComposer implements MessageComposer {

    private Long mID;
    private String mRoomName;

    public FlatCreatedMessageComposer(Long id, String roomName)
    {
        this.mID = id;
        this.mRoomName = roomName;
    }
    @Override
    public void compose(Response response) {
        response.write(mID);
        response.write((char)13);
        response.write(mRoomName);
    }

    @Override
    public short returnID() {
        return 59;
    }
}
