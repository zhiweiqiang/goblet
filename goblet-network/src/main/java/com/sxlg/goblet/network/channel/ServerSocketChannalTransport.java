package com.sxlg.goblet.network.channel;

import com.sxlg.goblet.store.network.Transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannalTransport implements Transport {

    private ServerSocketChannel channel = null;
    private static final int SERVER_PORT = 9999;


    public ServerSocketChannalTransport() throws IOException {
        this.channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(SERVER_PORT));
    }

    public SocketChannel getTransport() throws IOException {
        SocketChannel accept = channel.accept();
        return accept;
    }
}