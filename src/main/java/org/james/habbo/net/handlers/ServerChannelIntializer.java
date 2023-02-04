package org.james.habbo.net.handlers;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import org.james.habbo.net.codecs.ServerDecoder;
import org.james.habbo.net.codecs.ServerEncoder;

public class ServerChannelIntializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline mPipeLine = channel.pipeline();
        mPipeLine.addLast("Encoder", new ServerEncoder());
        mPipeLine.addLast("Handler", new ServerChannelHandler());
        mPipeLine.addLast("Decoder", new ServerDecoder());
    }
}
