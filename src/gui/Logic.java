package gui;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 * This class contains the basic implementation for a game
 *
 * @author Moises
 */
public abstract class Logic extends Canvas implements Runnable {
    protected int WIDTH = 800;
    protected int HEIGHT = 600;
    
    private Thread logic;
    private double timeForEachFrame = 1000000000.0 / 70;
    private boolean running = false;

    public Logic() {
        setup();
    }

    public abstract void setup();

    @Override
    public void run() {
        createBufferStrategy(3);
        BufferStrategy bs = getBufferStrategy();

        int frames = 0;                                                     // stores the number of frames
        double time0 = System.nanoTime();                                       // stores the initial of the run method
        double time1;                                                           // stores the initial time of the loop
        double elapsed_time0 = 0;                                               // store the time it takes to update and render
        double elapsed_time1 = 0;                                               // stores the time it takes to execute the loop
        double wait;                                                            // stores the time remaining to update and render the screen
        while (running) {
            time1 = System.nanoTime();
            update((long) elapsed_time1);
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            {
                render(g);
            }
            g.dispose();
            if (!bs.contentsLost()) {
                bs.show();
            }
            Toolkit.getDefaultToolkit().sync();

            frames++;
            elapsed_time0 = System.nanoTime() - time1;

            wait = (timeForEachFrame - elapsed_time0) * 1 / 1000000.0;         // nanosec to milisecs
            if (wait < 0) {
                wait = 0;
                System.out.println("wait = 0");
            }
            try {
                Thread.sleep((long) wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsed_time1 = System.nanoTime() - time1;

            time0 += elapsed_time1;
            if (time0 >= 1000000000) {
//                System.out.println("FPS: " + frames);
                frames = 0;
                time0 = 0;
            }
        }
    }

    public abstract void update(double sec);

    public abstract void render(Graphics2D g);

    public void start() {
        logic = new Thread(this);
        running = true;
        logic.start();
    }

    /**
     * Stops the game
     */
    public void stop() {
        running = false;
    }
}
