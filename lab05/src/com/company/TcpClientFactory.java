package com.company;

public class TcpClientFactory implements TcpFactory {
    @Override
    public TcpClient createTcpClient() {
        return new TcpClient();
    }

    @Override
    public TcpServer createTcpServer() {
        return null;
    }
}
