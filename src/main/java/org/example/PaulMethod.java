package org.example;

import org.example.dto.SvenInterval;

import java.util.function.Function;

public class PaulMethod {

    private Function<Double, Double> f;
    private double delta;
    private double x0;
    private double e;

    public double find() {
        SvenInterval interval = getSvenInterval();

        double xNew = interval.mx +
                ( (interval.mx - interval.ax) * (interval.ay - interval.by) ) /
                        ( 2 * (interval.ay - 2 * interval.my + interval.by) );
        double yNew = f.apply(xNew);

        while (true) {
            if (Math.abs(interval.my - yNew) <= e && Math.abs(interval.mx - xNew) <= e) {
                return xNew;
            }

            if (interval.mx < xNew) {
                interval.ax = interval.mx;
                interval.ay = interval.my;
            } else {
                interval.bx = interval.mx;
                interval.by = interval.my;
            }

            interval.mx = xNew;
            interval.my = yNew;

            double a1 = calculateA1(interval);
            double a2 = calculateA2(interval);

            xNew = (interval.ax + interval.mx) / 2 - (a1 / (2 * a2));
            yNew = f.apply(xNew);
        }
    }

    private double calculateA1(SvenInterval interval) {
        return (interval.my - interval.ay) / (interval.mx - interval.ax);
    }

    private double calculateA2(SvenInterval interval) {
        return 1 / (interval.bx - interval.mx) *
                ( (interval.by - interval.ay) / (interval.bx - interval.ax) -
                        (interval.my - interval.ay) / (interval.mx - interval.ax) );
    }

    private SvenInterval getSvenInterval() {
        SvenAlgorithm sven = new SvenAlgorithm();
        sven.setFunction(f);
        sven.setDelta(delta);
        sven.setX0(x0);

        return sven.findInterval();
    }

    public void setFunction(Function<Double, Double> f) {
        this.f = f;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public void setE(double e) {
        this.e = e;
    }
}
