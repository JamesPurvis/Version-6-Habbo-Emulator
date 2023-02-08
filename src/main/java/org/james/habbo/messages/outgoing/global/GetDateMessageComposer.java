package org.james.habbo.messages.outgoing.global;

import org.hibernate.grammars.hql.HqlParser;
import org.james.habbo.messages.incoming.global.GetDateMessageEvent;
import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetDateMessageComposer implements MessageComposer
{



    @Override
    public void compose(Response response) {
        LocalDate mDate = LocalDate.now();
        response.writeString(mDate.toString().replace("-", "."));
    }

    @Override
    public short returnID() {
        return 163;
    }
}
