package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpClient {
    private static final int POOL_SIZE = 10;
    private static final int RUNS = 100;

    private static TcpClient tcpClient;

    private TcpClient() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static TcpClient getInstance() {
        if (tcpClient == null) {
            tcpClient = new TcpClient();
        }
        return tcpClient;
    }
    void fire() {
	ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
	for ( int i = 0; i < RUNS; i++ ) {
	    executor.execute(new ClientTask(i));
	}
	executor.shutdown();
    }
    
    public static final void main(String[] args)  {
        TcpClient tcpClient = TcpClient.getInstance();
        tcpClient.fire();
    }

}
