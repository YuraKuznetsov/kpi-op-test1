package org.example;

import java.util.function.Function;

public class NewtonRaphson {

    private Function<Double, Double> f_1;
    private Function<Double, Double> f_2;
    private double x0;
    private double e;

    public double find() {
        double x_i = x0;

        while (Math.abs(f_1.apply(x_i)) > e) {
            x_i = x_i - (f_1.apply(x_i) / f_2.apply(x_i));
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
