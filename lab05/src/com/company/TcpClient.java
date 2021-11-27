package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpClient {
    private static final int POOL_SIZE = 10;
    private static final int RUNS = 100;

//////////////////SINGLETON////////////////////
    private static TcpClient tcpClient;
    private TcpClient() {

    }

    public static TcpClient getInstance(){
        if(tcpClient == null){
            tcpClient = new TcpClient();
        }
        return tcpClient;
    }
//////////////////SINGLETON////////////////////
    void fire() {
	ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
	
	for ( int i = 0; i < RUNS; i++ ) {
	    executor.execute(new ClientTask(i));
	}
	
	executor.shutdown();
	
    }
    
    public static final void main(String[] args)  {
	new TcpClient().fire();
    }
    
}
