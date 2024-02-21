package org.example;

import org.example.dto.Interval;

public class Main {

    public static void main(String[] args) {
        SvenAlgorithm sven = new SvenAlgorithm();
        sven.setFunction(x -> Math.pow((100 - x), 2));
        sven.setDelta(5);
        sven.setX0(30);

        Interval interval = sven.findInterval();

        System.out.println("a: " + interval.a);
        System.out.println("b: " + interval.b);
    }
}