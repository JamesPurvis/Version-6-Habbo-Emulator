package org.james.habbo.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.configuration.ConfigurationFile;
import org.james.habbo.net.handlers.ServerChannelIntializer;
import io.netty.channel.Channel;

import java.net.InetSocketAddress;

public class Server
{

    private Logger mLogger = LogManager.getLogger(Server.class.getName());
    private EventLoopGroup mBossGroup = null;
    private EventLoopGroup mWorkerGroup = null;
    private ServerBootstrap mBootStrap = null;
    private static Server mInstance = null;
    private int mPort;
    private String mIP;

    public Server(String ip, int port)
    {
        this.mIP = ip;
        this.mPort = port;
        mWorkerGroup = new NioEventLoopGroup();
        mBossGroup = new NioEventLoopGroup();
        mBootStrap = new ServerBootstrap();
    }

    public void createSocket()
    {
        this.mBossGroup = new NioEventLoopGroup();
        this.mWorkerGroup = new NioEventLoopGroup();

        this.mBootStrap.group(mBossGroup, mWorkerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelIntializer())
                .option(ChannelOption.SO_BACKLOG, 10)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_RCVBUF, 1024)
                .childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(1024))
                .childOption(ChannelOption.ALLOCATOR, new PooledByteBufAllocator(true));
    }

    public void bind()
    {
        try
        {
            this.mBootStrap.bind(new InetSocketAddress(mIP, mPort));
        }

        catch(Exception e)
        {
            mLogger.error("Failed to bind on " + mIP + ":" + mPort + " " + e.getMessage());
            return;
        }

        mLogger.info("Started listening for connections on " + mIP + ":" + mPort);
    }



    public static Server getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new Server(ConfigurationFile.getInstance().returnProperty("tcp.ip"), Integer.parseInt(ConfigurationFile.getInstance().returnProperty("tcp.port")));
        }

        return mInstance;
    }
}
