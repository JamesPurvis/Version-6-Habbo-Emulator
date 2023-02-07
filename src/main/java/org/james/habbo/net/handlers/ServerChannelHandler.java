package org.james.habbo.net.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.net.session.GameSession;
import org.james.habbo.net.session.GameSessionFactory;

public class ServerChannelHandler extends SimpleChannelInboundHandler<String>
{

    private static Logger mLogger = LogManager.getLogger(ServerChannelHandler.class.getName());
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

        GameSession mSession = GameSessionFactory.getInstance().createNewSession(ctx.channel());
         ctx.channel().attr(AttributeKey.valueOf("Session")).set(mSession);
        mLogger.info("Client " + mSession.ID() + " " + "[" + mSession.IPtoString() + "] " + "has connected to the server.");
        mSession.Hello();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

    }
}
