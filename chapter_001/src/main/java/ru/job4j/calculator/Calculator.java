/**
 * Package for calculator.
 *
 * @author Nevolin
 * @version $1$
 * @since 0.1
 */
package ru.job4j.calculator;
/**
 * Class Calculator.
 * @author Ilya.
 * @since  2017.10.
 */
public class Calculator {
    /**
     * @param result args.
     */
    private double result;
    /**
     * Method add.
     * @param first args.
     * @param second args.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method sub.
     * @param first args.
     * @param second args.
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method mul.
     * @param first args.
     * @param second args.
     */
	public void mul(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method div.
     * @param first args.
     * @param second args.
     */
	public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}