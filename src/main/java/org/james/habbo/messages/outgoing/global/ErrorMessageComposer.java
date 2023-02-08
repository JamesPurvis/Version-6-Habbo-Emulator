package org.james.habbo.messages.outgoing.global;

import com.google.protobuf.Message;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class ErrorMessageComposer implements MessageComposer
{
    private String errorMsg;
    public ErrorMessageComposer(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    @Override
    public void compose(Response response) {
        response.writeString(errorMsg);
    }

    @Override
    public short returnID() {
        return 33;
    }
}
