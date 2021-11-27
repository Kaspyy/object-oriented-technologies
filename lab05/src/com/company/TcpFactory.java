package com.company;

import java.io.IOException;

public abstract class TcpFactory implements Runnable {

    public void run() {
        Runnable task = null;
        try {
            task = createTask();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert task != null;
        task.run();
    }
    public abstract Runnable createTask() throws IOException;
}
