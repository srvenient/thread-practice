package com.srvenient.number;

public class Sequential {

    private final Object lock = new Object();
    private final int maxNumber;

    private int count = 1;

    public Sequential(final int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Runnable execute(final NumberType numberType) {
        return () -> {
            while (count <= this.maxNumber) {
                synchronized (lock) {
                    switch (numberType) {
                        case EVEN -> {
                            if (count % 2 == 0) {
                                System.out.println("Número par: " + count);
                                count++;
                                lock.notify();
                            } else {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                        case ODD -> {
                            if (count % 2 != 0) {
                                System.out.println("Número impar: " + count);
                                count++;
                                lock.notify();
                            } else {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                        default -> System.out.println("Error");
                    }
                }
            }
        };
    }

    public enum NumberType {
        EVEN,
        ODD;
    }

}
