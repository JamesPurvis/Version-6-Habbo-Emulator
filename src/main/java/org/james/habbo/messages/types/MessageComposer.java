package org.james.habbo.messages.types;

public interface MessageComposer
{
    void compose(Response response);
    short returnID();
}
