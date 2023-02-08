package org.james.habbo.messages.types;

import io.netty.buffer.ByteBuf;
import org.james.habbo.encoding.*;
import org.james.habbo.util.*;

public class Request
{
    private ByteBuf mBuffer;
    private int mID;
    private int mLength;

    private String mHeader;

    public int ID()
    {
        return mID;
    }

    public String Header()
    {
        return mHeader;
    }

    public Request(ByteBuf buffer)
    {
        this.mBuffer = buffer;
        this.mHeader = new String(new byte[] {mBuffer.readByte(), mBuffer.readByte()});
        this.mID = Base64Encoding.decode(mHeader.getBytes());
    }

    public int readBase64()
    {
        return Base64Encoding.decode(new byte[] {
                this.mBuffer.readByte(),
                this.mBuffer.readByte()
        });
    }

    public String popString()
    {
        int mLength = readBase64();
        byte[] mData = readBytes(mLength);
        return new String(mData, StringUtil.getEncoding());
    }

    public int popInteger()
    {
        byte[] remaining = this.remainingBytes();
        int length = remaining[0] >> 3 & 7;
        int value = WireEncoding.decode(remaining);
        readBytes(length);
        return value;
    }

    public byte[] remainingBytes()
    {
        this.mBuffer.markReaderIndex();
        byte[] mData = new byte[mBuffer.readableBytes()];
        this.mBuffer.readBytes(mData);
        this.mBuffer.resetReaderIndex();
        return mData;
    }

    public byte[] readBytes(int length)
    {
        byte[] mPayload = new byte[length];
        this.mBuffer.readBytes(mPayload);
        return mPayload;
    }

    public String contents()
    {
        byte[] mRemaining = this.remainingBytes();

        if (mRemaining != null)
        {
            return new String(remainingBytes(), StringUtil.getEncoding());
        }

        return null;
    }

    public String getMessageBody()
    {
        String consoleText = this.mBuffer.toString(StringUtil.getEncoding());

        for(int a = 0; a < 14; a++)
        {
            consoleText = consoleText.replace(Character.toString((char)a), "{" + a + "}");
        }

        return Header() + consoleText;
    }
}
