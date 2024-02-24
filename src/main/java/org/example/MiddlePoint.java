package org.example;

import org.example.dto.SvenInterval;

import java.util.function.Function;

public class MiddlePoint {

    private Function<Double, Double> f_1;
    private double e;

    public double find(double x1, double x2) {
        SvenInterval interval = new SvenInterval();
        interval.ax = x1;
        interval.bx = x2;

        interval.ay = f_1.apply(interval.ax);
        interval.by = f_1.apply(interval.bx);

        if (Math.abs(interval.ay) < e) return interval.ax;
        if (Math.abs(interval.by) < e) return interval.bx;

        while (true) {
            interval.mx = (interval.bx + interval.ax) / 2;
            interval.my = f_1.apply(interval.mx);

            System.out.println("\na: " + interval.ax);
            System.out.println("b: " + interval.bx);

            if (Math.abs(interval.my) < e) return interval.mx;

            if (interval.my < 0) {
                interval.ax = interval.mx;
                interval.ay = interval.my;
            } else {
                interval.bx = interval.mx;
                interval.by = interval.my;
            }
        }
    }

    public void setFunction1(Function<Double, Double> f_1) {
        this.f_1 = f_1;
    }

    public void setE(double e) {
        this.e = e;
    }
}
