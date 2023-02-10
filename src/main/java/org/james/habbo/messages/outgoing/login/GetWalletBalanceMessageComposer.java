package org.james.habbo.messages.outgoing.login;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

public class GetWalletBalanceMessageComposer implements MessageComposer {

    private int mCredits;

    public GetWalletBalanceMessageComposer(int credits) {
        this.mCredits = credits;
    }

    @Override
    public void compose(Response response)
    {
        response.write(mCredits);
        response.write(".0");
    }

    @Override
    public short returnID() {
        return 6;
    }
}
