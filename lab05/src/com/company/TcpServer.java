package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {
    public static final int PORT = 8205;
    private static final int POOL_SIZE = 10;
    private ServerSocket ss;
    private ExecutorService executor;

    private static TcpServer tcpServer;

    private TcpServer() throws IOException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.ss = new ServerSocket(PORT);
        this.executor = Executors.newFixedThreadPool(POOL_SIZE);
    }
    public static TcpServer getInstance() throws IOException {
        if (tcpServer == null) {
            tcpServer = new TcpServer();
        }
        return tcpServer;
    }
//    public TcpServer() throws IOException {
//	ss = new ServerSocket(PORT);
//	executor = Executors.newFixedThreadPool(POOL_SIZE);
//    }
    
    public void listen() throws IOException {
	System.out.println(this + " up and running");
	while ( true ) {
	    executor.execute(new ServerTask(ss.accept()));
	}
    }  

    public static final void main(String[] args) throws IOException {
        TcpServer tcpServer = TcpServer.getInstance();
        tcpServer.listen();
    }

    @Override
    public String toString() {
	return "TcpServer [port=" + ss.getLocalPort() + "]";
    }

}
