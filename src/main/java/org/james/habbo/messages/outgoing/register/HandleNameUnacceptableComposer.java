package org.james.habbo.messages.outgoing.register;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class HandleNameUnacceptableComposer implements MessageComposer {
    @Override
    public void compose(Response response) {

    }

    @Override
    public short returnID() {
        return 37;
    }
}
