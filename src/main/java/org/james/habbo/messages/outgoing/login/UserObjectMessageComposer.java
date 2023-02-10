package org.james.habbo.messages.outgoing.login;

import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class UserObjectMessageComposer implements MessageComposer {

    private AvatarEntity mInstance;
    public UserObjectMessageComposer(AvatarEntity instance)
    {
        this.mInstance = instance;
    }
    @Override
    public void compose(Response response) {
        response.write("name=" + mInstance.getUsername() + (char)13);
        response.write("figure=" + mInstance.getFigure() + (char)13);
        response.write("sex=" + mInstance.getSex() + (char)13);
        response.write("customData=" + mInstance.getMission() + (char)13);
        response.write("ph_tickets=" + mInstance.getTickets() + (char)13);
        response.write("photo_film" + mInstance.getFilm() + (char)13);
        response.write("ph_figure=" + mInstance.getPool_figure() + (char)13);
        response.write("directmail=0" + (char)13);
    }

    @Override
    public short returnID() {
        return 5;
    }
}
