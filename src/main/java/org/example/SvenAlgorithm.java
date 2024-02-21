package org.example;

import org.example.dto.SvenInterval;

import java.util.function.Function;

public class SvenAlgorithm {

    private Function<Double, Double> f;
    private double delta;
    private double x0;

    public SvenInterval findInterval() {
        int k = 0;

        double[] xCords = new double[] {x0 - delta, x0, x0 + delta};
        double[] yCords = new double[3];

        yCords[0] = f.apply(xCords[0]);
        yCords[1] = f.apply(xCords[1]);
        yCords[2] = f.apply(xCords[2]);

        if (yCords[1] < yCords[0] && yCords[1] < yCords[2]) {
            return new SvenInterval(xCords, yCords);
        }

        while (yCords[1] > yCords[0] || yCords[1] > yCords[2]) {
            k++;
            if (yCords[0] > yCords[2]) {
                xCords[0] = xCords[1];
                yCords[0] = yCords[1];

                xCords[1] = xCords[2];
                yCords[1] = yCords[2];

                xCords[2] = xCords[2] + delta * Math.pow(2, k);
                yCords[2] = f.apply(xCords[2]);
            } else {
                xCords[2] = xCords[1];
                yCords[2] = yCords[1];

                xCords[1] = xCords[0];
                yCords[1] = yCords[0];

                xCords[0] = xCords[1] - delta * Math.pow(2, k);
                yCords[0] = f.apply(xCords[0]);
            }

            checkYCords(yCords);
        }

        double xDistance01 = xCords[1] - xCords[0];
        double xDistance12 = xCords[2] - xCords[1];

        SvenInterval interval = new SvenInterval();

        if (xDistance01 > xDistance12) {
            double xNew = xCords[0] + xDistance01 / 2;
            double yNew = f.apply(xNew);

            if (yNew < yCords[1]) {
                interval.ax = xCords[0];
                interval.mx = xNew;
                interval.bx = xCords[1];
                interval.ay = yCords[0];
                interval.my = yNew;
                interval.by = yCords[1];
            }
            else {
                interval.ax = xNew;
                interval.mx = xCords[1];
                interval.bx = xCords[2];
                interval.ay = yNew;
                interval.my = yCords[1];
                interval.by = yCords[2];
            }
        } else {
            double xNew = xCords[1] + xDistance12 / 2;
            double yNew = f.apply(xNew);

            if (yNew < yCords[1]) {
                interval.ax = xCords[1];
                interval.mx = xNew;
                interval.bx = xCords[2];
                interval.ay = yCords[1];
                interval.my = yNew;
                interval.by = yCords[2];
            }
            else {
                interval.ax = xCords[0];
                interval.mx = xCords[1];
                interval.bx = xNew;
                interval.ay = yCords[0];
                interval.my = yCords[1];
                interval.by = yNew;
            }
        }

        return interval;
    }

    private void checkYCords(double[] yCords) {
        if (areEqual(yCords)) throw new RuntimeException("I'm too lazy to write a description, just check it");
        if (yCords[1] > yCords[0] && yCords[1] > yCords[2]) throw new RuntimeException();
    }

    private boolean areEqual(double[] yCords) {
        double epsilon = 0.000001d;

        return Math.abs(yCords[0] - yCords[1]) < epsilon && Math.abs(yCords[1] - yCords[2]) < epsilon;
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
}
