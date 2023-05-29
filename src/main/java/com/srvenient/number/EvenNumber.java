package com.srvenient.number;

import com.srvenient.Main;

public class EvenNumber implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Main.LOCK) {
                if (i % 2 == 0) {
                    System.out.println("Even number: " + i);
                    Main.LOCK.notify();
                } else {
                    try {
                        Main.LOCK.wait(10);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
