package com.company;

import java.io.IOException;

public class TcpServerFactory implements TcpFactory {
    @Override
    public TcpClient createTcpClient() {
        return null;
    }

    @Override
    public TcpServer createTcpServer() throws IOException {
        return new TcpServer();
    }
}
