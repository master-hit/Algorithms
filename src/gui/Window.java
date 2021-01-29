package gui;

import javax.swing.JFrame;

/**
 *
 * @author Moises
 */
public class Window {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        Screen game = new Screen();
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        game.start();
    }
}


