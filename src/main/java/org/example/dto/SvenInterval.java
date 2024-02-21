package org.example.dto;

public class SvenInterval {

    public double ax, mx, bx;
    public double ay, my, by;

    public SvenInterval() {}

    public SvenInterval(double[] xCords, double[] yCords) {
        ax = xCords[0];
        mx = xCords[1];
        bx = xCords[2];

        ay = yCords[0];
        my = yCords[1];
        by = yCords[2];
    }
}
