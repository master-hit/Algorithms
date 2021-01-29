package gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Moises
 */
public abstract class Display extends Logic implements KeyListener {

    Display() {
        addKeyListener(this);
    }

    public void size(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
    }

    @Override
    public Dimension getSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
