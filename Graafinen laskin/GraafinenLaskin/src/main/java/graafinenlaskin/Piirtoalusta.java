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
    public int k;
    public int piirtoY;
    public boolean tyhjennys;

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
        this.k = 380;
        this.piirtoY = 740;
        this.tyhjennys = false;
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
        if (tyhjennys) {
            g.clearRect(0, 0, 800, 800);
            piirtoY = 720;
        }
        int vali = 0;
        int numerot = 80;
        int nykyX = 3;
        int nykyY = -3;
        for (int i = 0; i < 800; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(i, k, 1, 1);
            g.fillRect(k, i, 1, 1);
            g.drawLine(vali, k - 5, vali, k + 5);
            g.drawLine(k - 5, vali, k + 5, vali);
            vali += 20;
            if (i % 80 == 0) {
                if (nykyX != 0) {
                    g.drawString(String.valueOf(nykyX), k + 10, numerot + 2);
                    g.drawString(String.valueOf(nykyY), numerot - 2, k - 10);
                }
                numerot += 100;
                nykyX--;
                nykyY++;
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
        if (tyhjennys == false) {
            super.paintComponents(g);
            g.clearRect(0, 0, 200, 30);
            g.setColor(Color.BLACK);
            double x;
            Color randomColor = randColor();
            g.setColor(randomColor);
            for (int i = 0; i < 800; i++) {
                x = 0.01 * (-n1 * Math.pow(i - k, n2)) + k - (n4 * 100) - (n3 * (i - k));
                g.setColor(randomColor);
                g.fillOval(i, (int) x, 3, 3);
            }
            String funktio = "f(y) = " + String.valueOf(n1)
                    + "x^" + String.valueOf(n2)
                    + " + " + String.valueOf(n3)
                    + "x + " + String.valueOf(n4);
            g.drawString(funktio, 610, piirtoY);
            piirtoY -= 20;
        }
        tyhjennys = false;
    }

    /**
     * Tyhjennetään piirtoalusta kuvaajista ja funktioista
     */
    public void tyhjenna() {
        tyhjennys = true;
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
