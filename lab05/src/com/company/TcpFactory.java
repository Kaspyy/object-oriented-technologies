package com.company;

import java.io.IOException;

public interface TcpFactory {
    TcpClient createTcpClient();
    TcpServer createTcpServer() throws IOException;
}
