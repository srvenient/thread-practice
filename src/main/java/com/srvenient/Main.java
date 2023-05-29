package com.srvenient;

import com.srvenient.number.Sequential;

public class Main {
    public static void main(String[] args) {
        final var sequential = new Sequential(10);

        final var one = new Thread(sequential.execute(Sequential.NumberType.EVEN));
        final var two = new Thread(sequential.execute(Sequential.NumberType.ODD));

        one.start();
        two.start();
    }
}