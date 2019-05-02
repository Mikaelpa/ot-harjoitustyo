package graafinenlaskin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {

    private double n1;
    private double n2;
    private double n3;
    private double n4;
    private int k;
    private int piirtoY;
    private boolean tyhjennys;

    public Piirtoalusta(double n1, double n2, double n3, double n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.k = 380;
        this.piirtoY = 740;
        this.tyhjennys = false;
    }

    public void setN(double n1, double n2, double n3, double n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

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

    public void tyhjenna() {
        this.tyhjennys = true;
        super.repaint();

    }

}
