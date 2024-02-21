package org.example;

import org.example.dto.SvenInterval;

public class Main {

    public static void main(String[] args) {
        SvenAlgorithm sven = new SvenAlgorithm();
        sven.setFunction(x -> Math.pow((100 - x), 2));
        sven.setDelta(5);
        sven.setX0(30);

        SvenInterval interval = sven.findInterval();

        System.out.println("a: " + interval.ax);
        System.out.println("m: " + interval.mx);
        System.out.println("b: " + interval.bx);

        System.out.println("f(a): " + interval.ay);
        System.out.println("f(m): " + interval.my);
        System.out.println("f(b): " + interval.by);
    }
}