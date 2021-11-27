package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer extends TcpServerFactory {
    public static final int PORT = 8205;
    private static final int POOL_SIZE = 10;
    private ServerSocket ss;
    private ExecutorService executor;


    public TcpServer() throws IOException {
	ss = new ServerSocket(PORT);
	executor = Executors.newFixedThreadPool(POOL_SIZE);
    }
    
    public void listen() throws IOException {
	System.out.println(this + " up and running");
	while ( true ) {
	    executor.execute(new ServerTask(ss.accept()));
	}
    }  

    public static final void main(String[] args) throws IOException {
	new TcpServer().listen();
    }

    @Override
    public String toString() {
	return "TcpServer [port=" + ss.getLocalPort() + "]";
    }

}
