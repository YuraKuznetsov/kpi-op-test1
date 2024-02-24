package org.example;

import org.example.dto.SvenInterval;

public class Main {

    public static void main(String[] args) {
        SvenAlgorithm sven = new SvenAlgorithm();
        sven.setFunction(x -> Math.pow((100 - x), 2));
        sven.setDelta(5);
        sven.setX0(30);

        SvenInterval interval = sven.findInterval();

//        System.out.println("a: " + interval.ax);
//        System.out.println("b: " + interval.bx);

//        DichotomyMethod dichotomyMethod = new DichotomyMethod();
//        dichotomyMethod.setFunction(x -> Math.pow((100 - x), 2));
//        dichotomyMethod.setE(10);
//
//        double min = dichotomyMethod.find(interval);
//        System.out.println(min);

//        GoldenSection goldenSection = new GoldenSection();
//        goldenSection.setFunction(x -> Math.pow((100 - x), 2));
//        goldenSection.setE(20);
//
//        System.out.println(goldenSection.find(interval));

        PaulMethod paulMethod = new PaulMethod();
        paulMethod.setFunction(x -> x * (2 * x - 3));
        paulMethod.setDelta(0.1);
        paulMethod.setX0(3.5);
        paulMethod.setE(0.01);

        System.out.println(paulMethod.find());
    }
}