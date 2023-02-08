package org.james.habbo.messages.outgoing.register;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class HandleNameApprovedComposer implements MessageComposer
{
    @Override
    public void compose(Response response) {

    }

    @Override
    public short returnID() {
        return 36;
    }
}
