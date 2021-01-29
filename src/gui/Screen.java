package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedHashSet;
import java.util.Random;
import sorting.InsertionSort;
import sorting.Trial;

/**
 * 
 * @author Moises
 */
public class Screen extends Display {
    
    Thread sorting;
    Rectangle arr[];

    @Override
    public void setup() {
        createRandomRectangle(10);
        init();
    }

    private void createRandomRectangle(int numberOfRect) {
        //creating random hights
        Random ran = new Random();
        LinkedHashSet<Integer> setOfHights = new LinkedHashSet<>();
        while (setOfHights.size() <= numberOfRect) {
            setOfHights.add(ran.nextInt(500));
        }
        Integer[] rectHight = setOfHights.toArray(new Integer[0]);
        //creating all the rect
        arr = new Rectangle[numberOfRect];
        int width = WIDTH / numberOfRect;
        int y = 500;
        for (int i = 0, x = 0, hight = 0; i < numberOfRect; i++, x = x + width) {
            arr[i] = new Rectangle(x, y - rectHight[i], width, rectHight[i]);
        }
    }

    public void init() {
        sorting = new Thread(() -> {
            long start = System.currentTimeMillis();
            Trial.heapSort(arr);
            long end = System.currentTimeMillis();
            System.out.println("parition: " + (end - start));
        });
        sorting.start();
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (!sorting.isAlive()) {
                    createRandomRectangle(10);
                    sorting = new Thread(() -> {
                        long start = System.currentTimeMillis();
                        new Trial().selectionSort(arr);
                        long end = System.currentTimeMillis();
                        System.out.println("parition: " + (end - start));
                    });
                    sorting.start();
                }
            break;
        }
    }
    
    @Override
    public void update(double sec) {
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        for (Rectangle e : arr) {
            g.fill(e);
        }
    }
}
