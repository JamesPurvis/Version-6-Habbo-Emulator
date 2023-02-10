package org.james.habbo.messages.incoming.login;

import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.util.AttributeKey;
import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.messages.outgoing.login.GetWalletBalanceMessageComposer;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.MessageEvent;
import org.james.habbo.messages.types.Request;
import org.james.habbo.net.session.GameSession;
import org.james.habbo.util.*;

public class GetCreditsMessageEvent implements MessageEvent
{
    @Override
    public void invokeEvent(Request request, GameSession session) {

        AvatarEntity mInstance = (AvatarEntity) session.Channel().attr(AttributeKey.valueOf("Avatar")).get();
        session.sendToSession(new GetWalletBalanceMessageComposer(mInstance.getCredits()));
    }
}
