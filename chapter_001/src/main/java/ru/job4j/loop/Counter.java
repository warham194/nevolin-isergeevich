package ru.job4j.loop;


/**
 * Class Counter.
 * @author Ilya.
 * @since  2017.10.
 */
public class Counter {
    /**
     * @param summ args.
     */
  private int sum = 0;
    /**
     * Method get.
     * @param start args.
     * @param  finish args.
     * @return sum.
     */
      public int add(int start, int finish) {
          for (int i = start; i <= finish; i++) {
              if (i % 2 == 0) {
                  this.sum = i + sum;
              }
          }

          return sum;

      }

}