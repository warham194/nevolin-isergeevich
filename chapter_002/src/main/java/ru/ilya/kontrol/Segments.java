package ru.ilya.kontrol;


import static java.lang.Math.hypot;
import static java.lang.Math.sqrt;

/**
 * Created by Lenovo2 on 08.06.2018.
 */
public class Segments {
    public boolean intersectionCheck(Point a, Point b, Point c, Point d) {
        boolean result = false;
        double ab = sqrt(sqr(b.x - a.x) + sqr(b.y - a.y));
        double cd = sqrt(sqr(d.x - c.x) + sqr(d.y - c.y));
        result  = sqr((a.x + b.x) - (c.x + d.x)) + sqr((a.y + b.y) - (c.y + d.y)) <= sqr(ab + cd);
        return result;
    }

    private double sqr(double a) {
        return a * a;
    }
}

    class Point {
    double x;
    double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
