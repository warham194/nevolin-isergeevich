package ru.job4j.condition;


/**
 * Class Triangle.
 * @author Ilya.
 * @since  2017.10.
 */

public class Triangle {
    /**
     * @param a args.
     */
    private Point a;
    /**
     * @param b args.
     */
    private Point b;
    /**
     * @param c args.
     */
    private Point c;
    /**
     * Method Triangle.
     * @param a args.
     * @param b args.
     * @param c args.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Method distance.
     * @param left args.
     * @param right args.
     * @return Math.
     */
    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow(right.getX() - left.getX(), 2) + Math.pow(right.getY() - left.getY(), 2));
    }
    /**
     * Method distance.
     * @param ab args.
     * @param ac args.
     * @param bc args.
     * @return -1.
     */
    public double period(double ab, double ac, double bc) {
        return -1;
    }
    /**
     * Method distance.
     * @return rs1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {

            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Method distance.
     * @param ab args.
     * @param ac args.
     * @param bc args.
     * @return ((ab + ac + bc) != 0 && ab + ac > bc  && ab + bc > ac && ac + bc > ab).
     */
    private boolean exist(double ab, double ac, double bc) {

       return ((ab + ac + bc) != 0 && ab + ac > bc  && ab + bc > ac && ac + bc > ab);

    }
}
