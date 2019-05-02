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
    private JFrame alkuFrame;
    private JFrame piirtoFrame;
    public JButton piirraNappi;
    public JButton tyhjennaNappi;
    public JTextField syoteKentta1;
    private JTextField syoteKentta2;
    private JTextField syoteKentta3;
    private JTextField syoteKentta4;
    public Piirtoalusta alusta;
/**
 * Ajetaan ohjelma suoraan mainista
 */
    @Override
    public void run() {
        screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
        alkuFrame = new JFrame("\"Graafinen Laskin\"");
        alkuFrame.setPreferredSize(new Dimension(400, 100));
        alkuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        alkuFrame.setLocation(screenW / 2, screenH / 2);
        luoKomponentit(alkuFrame.getContentPane());

        alkuFrame.pack();
        alkuFrame.setVisible(true);
    }
/**
 * Luodaan käyttöliittymän komponentit
 * @param container Annetaan metodille alkuframen container
 */
    private void luoKomponentit(Container container) {
        alkuFrame.setLayout(new GridLayout(2, 1));
        piirraNappi = new JButton("Piirrä");
        piirraNappi.addActionListener(this);
        tyhjennaNappi = new JButton("Tyhjennä");
        tyhjennaNappi.addActionListener(this);

        JPanel ylaPaneli = new JPanel(new GridLayout(1, 8));
        JPanel alaPaneli = new JPanel(new GridLayout(1, 2));
        JTextField teksti1 = new JTextField("f(y) = ");
        teksti1.setEditable(false);

        syoteKentta1 = new JTextField("0");

        JTextField teksti2 = new JTextField("x^");
        teksti2.setEditable(false);

        syoteKentta2 = new JTextField("0");

        JTextField teksti3 = new JTextField(" + ");
        teksti3.setEditable(false);

        syoteKentta3 = new JTextField("0");

        JTextField teksti4 = new JTextField("x +");
        teksti4.setEditable(false);

        syoteKentta4 = new JTextField("0");

        ylaPaneli.add(teksti1);
        ylaPaneli.add(syoteKentta1);
        ylaPaneli.add(teksti2);
        ylaPaneli.add(syoteKentta2);
        ylaPaneli.add(teksti3);
        ylaPaneli.add(syoteKentta3);
        ylaPaneli.add(teksti4);
        ylaPaneli.add(syoteKentta4);

        alaPaneli.add(tyhjennaNappi);
        alaPaneli.add(piirraNappi);

        container.add(ylaPaneli);
        container.add(alaPaneli);
    }
/**
 * Painalluksenkuuntelia molemmille napeille
 * @param e tapahtuma / painallus
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == piirraNappi) {
            try {
                teeAlusta();

            } catch (Exception ea) {
                teeError();
            }
        }

        if (e.getSource() == tyhjennaNappi) {
            syoteKentta1.setText("0");
            syoteKentta2.setText("0");
            syoteKentta3.setText("0");
            syoteKentta4.setText("0");
            if (alusta != null) {
                alusta.tyhjenna();
            }
        }
    }
/**
 * 
 * @return Palautetaan JFrame
 */
    public JFrame getFrame() {
        return this.alkuFrame;
    }
/**
 * Tehdään error-viesti jos ohjelmalle on annettu virheellinen syöte
 */
    public void teeError() {
        JFrame error = new JFrame("ERROR");
        error.setPreferredSize(new Dimension(300, 100));
        error.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JTextField teksti = new JTextField("Toimin vain liukuluvuilla");
        teksti.setEditable(false);
        error.setLocation(screenW / 2, screenH / 2 - 100);
        error.add(teksti);
        error.pack();
        error.setVisible(true);

    }
/**
 * Jos "piirrä" nappulaa painetaan ensimmäistä kertaa, tehdään uusi piirtoalusta
 * Jos "piirrä" nappulaa on jo painettu, piirretään silloin jo olemassa olevaan piirtoalustaan.
 */
    public void teeAlusta() {
        double i1 = Double.parseDouble(syoteKentta1.getText());
        double i2 = Double.parseDouble(syoteKentta2.getText());
        double i3 = Double.parseDouble(syoteKentta3.getText());
        double i4 = Double.parseDouble(syoteKentta4.getText());
        if (alusta == null) {
            alusta = new Piirtoalusta(i1, i2, i3, i4);
            JFrame frame2 = new JFrame("Piirtoalusta");
            frame2.setBackground(Color.white);
            frame2.setPreferredSize(new Dimension(800, 800));
            frame2.add(alusta);
            frame2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame2.setResizable(false);
            frame2.pack();
            frame2.setVisible(true);
        } else {
            alusta.setN(i1, i2, i3, i4);
            alusta.repaint();
        }
    }
}
