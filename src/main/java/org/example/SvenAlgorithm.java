package org.example;

import org.example.dto.Interval;

import java.util.function.Function;

public class SvenAlgorithm {

    private Function<Double, Double> f;
    private double delta;
    private double x0;

    public Interval findInterval() {
        int k = 0;

        double[] xCords = new double[] {x0 - delta, x0, x0 + delta};
        double[] yCords = new double[3];

        yCords[0] = f.apply(xCords[0]);
        yCords[1] = f.apply(xCords[1]);
        yCords[2] = f.apply(xCords[2]);

        if (yCords[1] < yCords[0] && yCords[1] < yCords[2]) {
            return new Interval(xCords[0], xCords[2]);
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

        if (xDistance01 > xDistance12) {
            double xNew = xCords[0] + xDistance01 / 2;
            double yNew = f.apply(xNew);

            if (yNew < yCords[1])
                return new Interval(xCords[0], xCords[1]);
            else
                return new Interval(xNew, xCords[2]);
        } else {
            double xNew = xCords[1] + xDistance12 / 2;
            double yNew = f.apply(xNew);

            if (yNew < yCords[1])
                return new Interval(xCords[1], xCords[2]);
            else
                return new Interval(xCords[0], xNew);
        }
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
