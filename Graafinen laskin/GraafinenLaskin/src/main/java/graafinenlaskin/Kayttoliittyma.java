package graafinenlaskin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 * Ohjelman käyttöliittymä
 * @author mikaelpa
 */
public class Kayttoliittyma implements Runnable, ActionListener {

    private int screenW;
    private int screenH;
    private JFrame startFrame;
    public JButton drawButton;
    public JButton clearButton;
    public JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    public Piirtoalusta canvas;
/**
 * Ajetaan ohjelma suoraan mainista ja tehdään käyttöliittymän frame
 */
    @Override
    public void run() {
        screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
        startFrame = new JFrame("\"Graafinen Laskin\"");
        startFrame.setPreferredSize(new Dimension(400, 100));
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startFrame.setLocation(screenW / 2, screenH / 2);
        initComponents(startFrame.getContentPane());

        startFrame.pack();
        startFrame.setVisible(true);
    }
/**
 * Luodaan käyttöliittymän komponentit
 * @param container Annetaan metodille alkuframen container
 */
    private void initComponents(Container container) {
        startFrame.setLayout(new GridLayout(2, 1));
        drawButton = new JButton("Piirrä");
        drawButton.addActionListener(this);
        clearButton = new JButton("Tyhjennä");
        clearButton.addActionListener(this);

        JPanel upperPanel = new JPanel(new GridLayout(1, 8));
        JPanel lowerPanel = new JPanel(new GridLayout(1, 2));
        JTextField teksti1 = new JTextField("f(y) = ");
        teksti1.setEditable(false);

        text1 = new JTextField("0");

        JTextField teksti2 = new JTextField("x^");
        teksti2.setEditable(false);

        text2 = new JTextField("0");

        JTextField teksti3 = new JTextField(" + ");
        teksti3.setEditable(false);

        text3 = new JTextField("0");

        JTextField teksti4 = new JTextField("x +");
        teksti4.setEditable(false);

        text4 = new JTextField("0");

        upperPanel.add(teksti1);
        upperPanel.add(text1);
        upperPanel.add(teksti2);
        upperPanel.add(text2);
        upperPanel.add(teksti3);
        upperPanel.add(text3);
        upperPanel.add(teksti4);
        upperPanel.add(text4);

        lowerPanel.add(clearButton);
        lowerPanel.add(drawButton);

        container.add(upperPanel);
        container.add(lowerPanel);
    }
/**
 * Painalluksenkuuntelia molemmille napeille
 * @param e tapahtuma / painallus
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == drawButton) {
            try {
                makePlatform();

            } catch (Exception ea) {
                makeError();
            }
        }

        if (e.getSource() == clearButton) {
            text1.setText("0");
            text2.setText("0");
            text3.setText("0");
            text4.setText("0");
            if (canvas != null) {
                canvas.clearBoard();
            }
        }
    }
/**
 * 
 * @return Palautetaan JFrame
 */
    public JFrame getFrame() {
        return this.startFrame;
    }
/**
 * Tehdään error-viesti jos ohjelmalle on annettu virheellinen syöte
 */
    public void makeError() {
        JFrame error = new JFrame("ERROR");
        error.setPreferredSize(new Dimension(300, 100));
        error.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JTextField teksti = new JTextField("Toimin vain liukuluvuilla tai kokonaisluvuilla");
        teksti.setEditable(false);
        error.setLocation(screenW / 2, screenH / 2 - 50);
        error.add(teksti);
        error.pack();
        error.setVisible(true);

    }
/**
 * Jos "piirrä" nappulaa painetaan ensimmäistä kertaa, tehdään uusi piirtoalusta
 * Jos "piirrä" nappulaa on jo painettu, piirretään silloin jo olemassa olevaan piirtoalustaan.
 */
    public void makePlatform() {
        double i1 = Double.parseDouble(text1.getText());
        double i2 = Double.parseDouble(text2.getText());
        double i3 = Double.parseDouble(text3.getText());
        double i4 = Double.parseDouble(text4.getText());
        if (canvas == null) {
            canvas = new Piirtoalusta(i1, i2, i3, i4);
            JFrame fr = new JFrame("Piirtoalusta");
            fr.setBackground(Color.white);
            fr.setPreferredSize(new Dimension(800, 800));
            fr.add(canvas);
            fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fr.setResizable(false);
            fr.pack();
            fr.setVisible(true);
        } else {
            canvas.setN(i1, i2, i3, i4);
            canvas.repaint();
        }
    }
}
