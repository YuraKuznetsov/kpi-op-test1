package org.example;

import java.util.function.Function;

public class NewtonRaphson {

    private Function<Double, Double> f_1;
    private Function<Double, Double> f_2;
    private double x0;
    private double e;

    public double find() {
        double x_i = x0;

        while (true) {
            double f1 = f_1.apply(x_i);
            double f2 = f_2.apply(x_i);

            System.out.println("xi: " + x_i);
            System.out.println("f1: " + f1);
            System.out.println("f2: " + f2);

            x_i = x_i - (f1 / f2);
            if (Math.abs(f1) <= e) break;
        }

//        int iterationsCount = 3;
//        for (int iteration = 0; iteration < iterationsCount; iteration++) {
//            x_i = x_i - (f_1.apply(x_i) / f_2.apply(x_i));
//            System.out.println(x_i);
//        }

        return x_i;
    }

    public void setFunction1(Function<Double, Double> f_1) {
        this.f_1 = f_1;
    }

    public void setFunction2(Function<Double, Double> f_2) {
        this.f_2 = f_2;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public void setE(double e) {
        this.e = e;
    }
}
