package com.srvenient;

import com.srvenient.number.EvenNumber;
import com.srvenient.number.OddNumber;

public class Main {
    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        final var one = new Thread(new EvenNumber());
        final var two = new Thread(new OddNumber());

        one.start();
        two.start();
    }
}