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
        System.out.println("b: " + interval.bx);

        DichotomyMethod dichotomyMethod = new DichotomyMethod();
        dichotomyMethod.setFunction(x -> Math.pow((100 - x), 2));
        dichotomyMethod.setE(10);

        double min = dichotomyMethod.find(interval);
        System.out.println(min);
    }
}