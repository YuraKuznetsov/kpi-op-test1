package org.example;

import org.example.dto.SvenInterval;

import java.util.function.Function;

public class DichotomyMethod {

    private Function<Double, Double> f;
    private double e;

    public double find(SvenInterval interval) {
        double L = interval.bx - interval.ax;

        if (L <= e) {
            System.out.println("a: " + interval.ax + ". b: " + interval.bx);
            return Math.min(Math.min(interval.ay, interval.my), interval.by);
        }

        double x1 = interval.ax + L / 4;
        double x2 = interval.bx - L / 4;
        double y1 = f.apply(x1);
        double y2 = f.apply(x2);

        if (interval.my < y1 && interval.my < y2) {
            interval.ax = x1;
            interval.ay = y1;
            interval.bx = x2;
            interval.by = y2;
        } else if (y1 > y2) {
            interval.ax = interval.mx;
            interval.ay = interval.my;
            interval.mx = x2;
            interval.my = y2;
        } else {
            interval.bx = interval.mx;
            interval.by = interval.my;
            interval.mx = x1;
            interval.my = y1;
        }

        return find(interval);
    }

    public void setFunction(Function<Double, Double> f) {
        this.f = f;
    }

    public void setE(double e) {
        this.e = e;
    }
}
