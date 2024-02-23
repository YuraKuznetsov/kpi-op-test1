package org.example;

import org.example.dto.SvenInterval;

import java.util.function.Function;

public class GoldenSection {

    private Function<Double, Double> f;
    private double e;

    public double find(SvenInterval svenInterval) {
        double L = svenInterval.bx - svenInterval.ax;

        GoldenInterval interval = new GoldenInterval();
        interval.ax = svenInterval.ax;
        interval.bx = svenInterval.bx;
        interval.x1 = interval.ax + L * 0.382;
        interval.x2 = interval.ax + L * 0.618;
        interval.y1 = f.apply(interval.x1);
        interval.y2 = f.apply(interval.x2);

        while (true) {
            if (L <= e) {
                System.out.println("a: " + interval.ax + ".\nb: " + interval.bx);
                return Math.min(interval.y1, interval.y2);
            }

            if (interval.y1 > interval.y2) {
                interval.ax = interval.x1;
                interval.x1 = interval.x2;
                interval.y1 = interval.y2;
                interval.x2 = interval.bx - L * 0.236;
                interval.y2 = f.apply(interval.x2);
            } else {
                interval.bx = interval.x2;
                interval.x2 = interval.x1;
                interval.y2 = interval.y1;
                interval.x1 = interval.ax + L * 0.236;
                interval.y1 = f.apply(interval.x1);
            }

            L = interval.bx - interval.ax;
        }
    }

    public void setFunction(Function<Double, Double> f) {
        this.f = f;
    }

    public void setE(double e) {
        this.e = e;
    }

    private static class GoldenInterval {
        private double ax, x1, x2, bx;
        private double y1, y2;
    }
}



