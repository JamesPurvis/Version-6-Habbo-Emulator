package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class NoFlatsForUserMessageCompser implements MessageComposer {
    @Override
    public void compose(Response response) {

    }

    @Override
    public short returnID() {
        return 57;
    }
}
