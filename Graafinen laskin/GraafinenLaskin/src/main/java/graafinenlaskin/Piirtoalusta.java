package graafinenlaskin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Piirtoalusta extends JPanel {

    private int n1;
    private int n2;
    private int n3;
    private int n4;
    

    public Piirtoalusta(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public Piirtoalusta() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.BLACK);
        int y = 0;
        int x = 0;
        int oldY = 0;
        int oldX = 0;
        for (int i = 0; i < 800; i++) {
            g.setColor(Color.red);
            y = i;
            x = n1 * (int) Math.pow(i-380, n2) + 380 - n4 + n3*(i-380);
            g.drawLine(oldY, oldX, y, x);
            oldX = x;
            oldY = y;
            g.setColor(Color.BLACK);
            g.fillRect(i, 380, 1, 1);
            g.fillRect(380, i, 1, 1);

            
        }
        
        
    }
    
    public void piste(int y, Graphics g) {
        
        
        
    }


}
