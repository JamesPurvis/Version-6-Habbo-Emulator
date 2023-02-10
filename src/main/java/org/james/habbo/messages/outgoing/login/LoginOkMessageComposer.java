package org.james.habbo.messages.outgoing.login;

import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class LoginOkMessageComposer implements MessageComposer {

    @Override
    public void compose(Response response) {
    }

    @Override
    public short returnID() {
        return 3;
    }
}
