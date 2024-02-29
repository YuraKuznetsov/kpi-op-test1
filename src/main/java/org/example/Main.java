package org.example;

import org.example.dto.SvenInterval;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Double, Double> function = x -> x * x - 4 * x;
        SvenAlgorithm sven = new SvenAlgorithm();
        sven.setFunction(function);
        sven.setDelta(0.1);
        sven.setX0(3);

        SvenInterval interval = sven.findInterval();

//        System.out.println("a: " + interval.ax);
//        System.out.println("b: " + interval.bx);

//        DichotomyMethod dichotomyMethod = new DichotomyMethod();
//        dichotomyMethod.setFunction(function);
//        dichotomyMethod.setE(0.2);
//
//        double min = dichotomyMethod.find(interval);
//        System.out.println(min);

//        GoldenSection goldenSection = new GoldenSection();
//        goldenSection.setFunction(function);
//        goldenSection.setE(0.01);
//
//        System.out.println(goldenSection.find(interval));

//        PaulMethod paulMethod = new PaulMethod();
//        paulMethod.setFunction(function);
//        paulMethod.setDelta(0.1);
//        paulMethod.setX0(3);
//        paulMethod.setE(0.2);
//
//        System.out.println(paulMethod.find());

//        NewtonRaphson newtonRaphson = new NewtonRaphson();
//        newtonRaphson.setFunction1(x -> (2 * Math.pow(x, 3) - 4) / (x * x));
//        newtonRaphson.setFunction2(x -> (2 * Math.pow(x, 3) + 8) / Math.pow(x, 3));
//        newtonRaphson.setX0(0.1);
//        newtonRaphson.setE(0.000001);
//
//        System.out.println(newtonRaphson.find());

        SecantMethod secantMethod = new SecantMethod();
        secantMethod.setFunction1(x -> (2 * Math.pow(x, 3) - 4) / (x * x));
        secantMethod.setE(0.01);

        System.out.println(secantMethod.find(0.1, 2));
//
//        MiddlePoint middlePoint = new MiddlePoint();
//        middlePoint.setFunction1(x -> (2 * Math.pow(x, 3) - 4) / (x * x));
//        middlePoint.setE(0.01);
//
//        System.out.println(middlePoint.find(0.1, 2));
    }
}