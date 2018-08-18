package ru.ilya.multithreading;

/**
 * Created by Lenovo2 on 03.08.2018.
 */
import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private final int maxX;

    public RectangleMove(Rectangle rect, int maxX) {
        this.rect = rect;
        this.maxX = maxX;
    }

    @Override
    public void run() {
        int x = 1;
        Thread current = Thread.currentThread();
        while (!current.interrupted()) {
            if (this.rect.getX() <= 0 || this.rect.getX() >= maxX) {
                x *= -1;
            }
                this.rect.setX(this.rect.getX() + x);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
