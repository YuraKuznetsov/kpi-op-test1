package org.example;

import java.util.function.Function;

public class SecantMethod {

    private Function<Double, Double> f_1;
    private double e;

    public double find(double x1, double x2) {
        double y1 = f_1.apply(x1);
        double y2 = f_1.apply(x2);

        double xNew, yNew;

        while (true) {
            xNew = x2 - (y2 * (x2 - x1) / (y2 - y1));
            yNew = f_1.apply(xNew);

            System.out.println("\nx1: " + x1);
            System.out.println("x2: " + x2);
            System.out.println("y1: " + y1);
            System.out.println("y2: " + y2);
            System.out.println("x*: " + xNew);
            System.out.println("y*: " + yNew);

            if (Math.abs(yNew) < e)
                return xNew;

            if (yNew > 0) {
                x2 = xNew;
                y2 = yNew;
            } else {
                x1 = xNew;
                y1 = yNew;
            }
        }

//        int iterationsCount = 3;
//        for (int iteration = 0; iteration < iterationsCount; iteration++) {
//            x_i = x_i - (f_1.apply(x_i) / f_2.apply(x_i));
//            System.out.println(x_i);
//        }
    }

    public void setFunction1(Function<Double, Double> f_1) {
        this.f_1 = f_1;
    }

    public void setE(double e) {
        this.e = e;
    }
}
