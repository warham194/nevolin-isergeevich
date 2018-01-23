package ru.job4j.max;

/**
 * Class Max.
 * @author Ilya.
 * @since  2017.10.
 */
public class Max {
    /**
     * @param result args.
     */
     private int result;
    /**
     * Method calc.
     * @param first args.
     * @param second args.
     * @param third args.
     * @return max(max(first, second), third).
     */
    public int max(int first, int second, int third) {

        return max(max(first, second), third);
    }
    /**
     * Method calc.
     * @param first args.
     * @param second args.
     * @return result.
     */
        public int max(int first, int second) {
        if (first > second) {
            result = first;
        } else {
            result = second;
        }
        return result;
      }

}
