
package ru.job4j.loop;

public class Board {

    public String paint(int width, int height){
        StringBuilder builder = new StringBuilder();
        for (int i = 1 ; i <= height ; i ++){
            for (int j = 1 ; j <= width ; j++){
                if ((i + j)% 2 == 1){
                    builder.append(" ");
                } else builder.append("x");

            }
            builder.append("\r\n");
        }

        return builder.toString();
    }

}