package ru.job4j.loop;

/**
 * Class Factorial.
 * @author Ilya.
 * @since  2017.10.
 */
public class Factorial {
    /**
     * @param result args.
     */
    private int result = 1;
    /**
     * Method calc.
     * @param n args.
     * @return result.
     */
    public int calc(int n) {

        for (int i = 1; i <= n; i++) {
            if (i == 0) {
                this.result = 1;
            }
            this.result = this.result * i;
        }

        return  result;
    }

}