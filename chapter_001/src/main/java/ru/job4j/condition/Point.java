/**
 * Package for Point task.
 *
 * @author Ilya)
 * @version $1$
 * @since 0.1
 */
package ru.job4j.condition;
/**
 * Class Point.
 * @author Ilya.
 * @since  2017.10.
 */
public class Point {
    /**
     * @param x args.
     */
   private int x;
    /**
     * @param y args.
     */
   private int y;
    /**
     * Method div.
     * @param x args.
     * @param y args.
     */
   public  Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
    /**
     * Method getX.
     * @return x.
     */
  public int getX() {
      return this.x;
  }
    /**
     * Method getY.
     * @return y.
     */
  public int getY() {
     return this.y;
  }
    /**
     * Method get.
     * @param a args.
     * @param b args.
     * @return y.
     */
  public boolean is(int a, int b) {
    return (y == a * x + b);
 }
}