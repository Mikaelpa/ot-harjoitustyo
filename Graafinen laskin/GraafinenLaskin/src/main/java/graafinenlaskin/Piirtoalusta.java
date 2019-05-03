package graafinenlaskin;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Piirtoalusta-luokalla piirretään funktioiden kuvaajat
 *
 * @author mikaelpa
 */
public class Piirtoalusta extends JPanel {

    public double n1;
    public double n2;
    public double n3;
    public double n4;
    public int middle;
    public int functionDrawY;
    public boolean clear;

    /**
     * Uutta piirtoalustaa tehtäessä annetaan sille kaikki parametrit
     *
     * @param n1
     * @param n2
     * @param n3
     * @param n4
     */
    public Piirtoalusta(double n1, double n2, double n3, double n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.middle = 380;
        this.functionDrawY = 740;
        this.clear = false;
    }

    /**
     * Jos piirtoalusta on jo tehty, tällä metodilla voi antaa sille uudet arvot
     *
     * @param n1
     * @param n2
     * @param n3
     * @param n4
     */
    public void setN(double n1, double n2, double n3, double n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    /**
     * Piirretään y ja x vektorit
     *
     * @param g
     */
    public void init(Graphics g) {
        if (clear) {
            g.clearRect(0, 0, 800, 800);
            functionDrawY = 720;
        }
        int lineSpace = 0;
        int numberSpace = 80;
        int currentX = 3;
        int currentY = -3;
        for (int i = 0; i < 800; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(i, middle, 1, 1);
            g.fillRect(middle, i, 1, 1);
            g.drawLine(lineSpace, middle - 5, lineSpace, middle + 5);
            g.drawLine(middle - 5, lineSpace, middle + 5, lineSpace);
            lineSpace += 20;
            if (i % 80 == 0) {
                if (currentX != 0) {
                    g.drawString(String.valueOf(currentX), middle + 10, numberSpace + 2);
                    g.drawString(String.valueOf(currentY), numberSpace - 2, middle - 10);
                }
                numberSpace += 100;
                currentX--;
                currentY++;
            }

        }
    }

    /**
     * Piirretään piirtoalustalle funktioiden kuvaajat yms
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        init(g);
        if (clear == false) {
            super.paintComponents(g);
            g.clearRect(0, 0, 200, 30);
            g.setColor(Color.BLACK);
            double x;
            Color randomColor = randColor();
            g.setColor(randomColor);
            for (int i = 0; i < 800; i++) {
                x = 0.01 * (-n1 * Math.pow(i - middle, n2)) + middle - (n4 * 100) - (n3 * (i - middle));
                g.setColor(randomColor);
                g.fillOval(i, (int) x, 3, 3);
            }
            String function = "f(y) = " + String.valueOf(n1)
                    + "x^" + String.valueOf(n2)
                    + " + " + String.valueOf(n3)
                    + "x + " + String.valueOf(n4);
            g.drawString(function, 610, functionDrawY);
            functionDrawY -= 20;
        }
        clear = false;
    }

    /**
     * Tyhjennetään piirtoalusta kuvaajista ja funktioista
     */
    public void tyhjenna() {
        clear = true;
        repaint();

    }

    /**
     *
     * @return Palautetaan satunnainen väri
     */
    public Color randColor() {
        Random rand = new Random();
        float re = rand.nextFloat();
        float gr = rand.nextFloat();
        float bl = rand.nextFloat();

        return new Color(re, gr, bl);
    }

}
