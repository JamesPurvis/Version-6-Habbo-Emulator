package org.james.habbo.messages.outgoing.global;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class SecretKeyMessageComposer implements MessageComposer
{
    @Override
    public void compose(Response response) {

        // RC4 Encryption disabled for now.
        response.writeString("");
    }

    @Override
    public short returnID() {
        return 1;
    }
}
