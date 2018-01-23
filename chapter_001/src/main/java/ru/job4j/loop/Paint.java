package ru.job4j.loop;

/**
 * Class Paint.
 * @author Ilya.
 * @since  2017.10.
 */
public class Paint {
    /**
     * Method calc.
     * @param h args.
     * @return builder.toString.
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h * 2; j++) {
                if (j > h - 2 - i && j < h + i) {
                    builder.append("^");
                } else if (j < h * 2 - 1) {
                    builder.append(" ");
                }
            }
            if (i < h - 1) {
                builder.append(System.getProperty("line.separator"));
            }
        }
        return builder.toString();
    }
}