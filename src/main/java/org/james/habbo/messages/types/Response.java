package org.james.habbo.messages.types;

import io.netty.buffer.ByteBuf;
import org.james.habbo.util.*;
import org.james.habbo.encoding.*;

import java.net.IDN;

public class Response
{
    private ByteBuf mBuffer;
    private short mMessageID;

    public short ID()
    {
        return mMessageID;
    }

    public Response(short messageID, ByteBuf buffer)
    {
        this.mMessageID = messageID;
        this.mBuffer = buffer;
        this.mBuffer.writeBytes(Base64Encoding.encode(mMessageID, 2));
    }

    public void write(Object obj)
    {
        if (obj != null)
        {
            mBuffer.writeBytes(obj.toString().getBytes(StringUtil.getEncoding()));
        }
    }

    public void writeString(Object obj)
    {
        if (obj != null)
        {
            mBuffer.writeBytes(obj.toString().getBytes(StringUtil.getEncoding()));
        }

        mBuffer.writeByte(2);
    }

    public void writeInt(int i)
    {
        mBuffer.writeBytes(WireEncoding.encode(i));
    }

    public void writeBoolean(boolean b)
    {
        this.writeInt(b ? 1 : 0);
    }

    public String getBodyString() {
        String str = this.mBuffer.toString(StringUtil.getEncoding());

        for (int i = 0; i < 14; i++) {
            str = str.replace(Character.toString((char)i), "{" + i + "}");
        }

        return str;
    }
}
