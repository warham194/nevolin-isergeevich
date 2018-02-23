package ru.job4j.loop;


/**
 * Class Board.
 * @author Ilya.
 * @since  2017.10.
 */
public class Board {
    /**
     * Method get.
     * @param width args.
     * @param  height args.
     * @return builder.toString().
     */
    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 == 1) {
                    builder.append(" ");
                } else {
                    builder.append("x");
                }

            }
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

}