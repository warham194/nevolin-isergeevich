package ru.ilya.chess;

/**
 * Created by Lenovo2 on 17.01.2018.
 */

/**
 *Клетка шахмотной доски
 * x - позиция по вертикали
 * y - позиция по горизонтали
 */
public class Cell{
    private int x;
    private int y;

    public Cell(int x, int y){
        x = this.x;
        y = this.y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}
