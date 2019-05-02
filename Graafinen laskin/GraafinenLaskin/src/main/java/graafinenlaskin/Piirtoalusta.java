package graafinenlaskin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
     *Piirretään piirtoalustalle funktioiden kuvaajat yms
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g2);
        if (tyhjennys == false) {
            this.setBackground(Color.BLACK);
            g2.setColor(Color.BLACK);
            Random rand = new Random();
            float re = rand.nextFloat();
            float gr = rand.nextFloat();
            float bl = rand.nextFloat();
            double x;
            Color randomColor = new Color(re, gr, bl);
            for (int i = 0; i < 800; i++) {

                x = 0.01 * (-n1 * Math.pow(i - k, n2)) + k - (n4 * 10) - (n3 * (i - k));
                g2.setColor(randomColor);
                g2.fillOval(i, (int) x, 3, 3);
                g2.setColor(Color.BLACK);
                g2.fillRect(i, k, 1, 1);
                g2.fillRect(k, i, 1, 1);

            }
            g2.setColor(randomColor);
            String funktio = "f(y) = " + String.valueOf(n1)
                    + "x^" + String.valueOf(n2)
                    + " + " + String.valueOf(n3)
                    + "x + " + String.valueOf(n4);
            g2.drawString(funktio, 610, piirtoY);
            piirtoY -= 20;
        } else {
            g2.clearRect(0, 0, 800, 800);

            tyhjennys = false;
            this.piirtoY = 720;
            for (int i = 0; i < 800; i++) {
                g2.setColor(Color.BLACK);
                g2.fillRect(i, k, 1, 1);
                g2.fillRect(k, i, 1, 1);
            }
        }
    }
/**
 * Tyhjennetään piirtoalusta kuvaajista ja funktioista
 */
    public void tyhjenna() {
        this.tyhjennys = true;
        super.repaint();

    }

}
