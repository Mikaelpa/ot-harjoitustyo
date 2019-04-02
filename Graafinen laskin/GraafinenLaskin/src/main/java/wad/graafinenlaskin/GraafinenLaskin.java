package wad.graafinenlaskin;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class GraafinenLaskin implements Runnable, ActionListener {

    private JFrame frame;
    private JButton piirraNappi;
    private JTextField syoteKentta1;
    private JTextField syoteKentta2;
    private JTextField syoteKentta3;
    private JTextField syoteKentta4;

    @Override
    public void run() {
        frame = new JFrame("\"Graafinen Laskin\"");
        frame.setPreferredSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        frame.setLayout(new GridLayout(2, 1));
        piirraNappi = new JButton("Piirrä");
        piirraNappi.addActionListener(this);
        JPanel ylaPaneli = new JPanel(new GridLayout(1, 8));
        JTextField teksti1 = new JTextField("f(x) = ");
        teksti1.setEditable(false);

        syoteKentta1 = new JTextField();

        JTextField teksti2 = new JTextField("x^");
        teksti2.setEditable(false);

        syoteKentta2 = new JTextField();

        JTextField teksti3 = new JTextField(" + ");
        teksti3.setEditable(false);

        syoteKentta3 = new JTextField();

        JTextField teksti4 = new JTextField("x +");
        teksti4.setEditable(false);

        syoteKentta4 = new JTextField();

        ylaPaneli.add(teksti1);
        ylaPaneli.add(syoteKentta1);
        ylaPaneli.add(teksti2);
        ylaPaneli.add(syoteKentta2);
        ylaPaneli.add(teksti3);
        ylaPaneli.add(syoteKentta3);
        ylaPaneli.add(teksti4);
        ylaPaneli.add(syoteKentta4);

        container.add(ylaPaneli);
        container.add(piirraNappi);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == piirraNappi) {

            frame = new JFrame("Piirtoalusta");
            frame.setPreferredSize(new Dimension(800, 800));
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            JTextField testi = new JTextField("Logiikka ei vielä toiminnassa =(");
            testi.setHorizontalAlignment(JTextField.CENTER);
            frame.getContentPane().add(testi);

            frame.pack();
            frame.setVisible(true);
        }
    }
    
    public JFrame getFrame() {
        return this.frame;
    }

}
