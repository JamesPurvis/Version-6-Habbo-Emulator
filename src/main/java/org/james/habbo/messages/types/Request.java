package org.james.habbo.messages.types;

import io.netty.buffer.ByteBuf;
import org.james.habbo.encoding.*;
import org.james.habbo.util.*;

public class Request
{
    private ByteBuf mBuffer;
    private int mID;

    private int mLength;

    public int ID()
    {
        return mID;
    }

    public int Length()
    {
        return mLength;
    }

    public Request(ByteBuf buffer, int length)
    {
        this.mBuffer = buffer;
        this.mLength = length;
        this.mID = Base64Encoding.decode(new byte[] {buffer.readByte(), buffer.readByte()});
    }

    public String toString()
    {
        byte[] mData = new byte[this.mBuffer.readableBytes()];

        mBuffer.readBytes(mData);

        return new String(mData, StringUtil.getEncoding());
    }
}
