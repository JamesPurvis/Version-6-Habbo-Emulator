package org.james.habbo.messages.outgoing.global;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class HandleMemberInfoComposer implements MessageComposer
{
    private String mMode;
    public HandleMemberInfoComposer(String mode)
    {
        this.mMode = mode;
    }
    @Override
    public void compose(Response response) {
        response.writeString(mMode);
    }

    @Override
    public short returnID() {
        return 128;
    }
}
