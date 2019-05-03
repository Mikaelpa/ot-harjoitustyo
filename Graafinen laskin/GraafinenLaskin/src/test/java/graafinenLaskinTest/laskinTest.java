/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graafinenLaskinTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import graafinenlaskin.Kayttoliittyma;
import graafinenlaskin.Piirtoalusta;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class laskinTest {

    Kayttoliittyma laskin;
    Piirtoalusta alusta;

    public laskinTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        laskin = new Kayttoliittyma();
        laskin.run();
        alusta = new Piirtoalusta(0, 0, 0, 0);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void tekeeAlussaFramen() {
        assertEquals("\"Graafinen Laskin\"", laskin.getFrame().getTitle());
        laskin.getFrame().dispose();
    }

    @Test
    public void frameOikeaKorkeus() {
        assertEquals(100, laskin.getFrame().getHeight());
    }

    @Test
    public void frameOikeaLeveys() {
        assertEquals(400, laskin.getFrame().getWidth());
    }

    @Test
    public void alaPaneeliVisible() {
        assertTrue(laskin.getFrame().getContentPane().getComponent(1).isVisible());
        laskin.getFrame().dispose();
    }

    @Test
    public void tyhjennaTest() {
        laskin.syoteKentta1.setText("12");
        assertEquals("12", laskin.syoteKentta1.getText());
        ActionEvent tapahtuma = new ActionEvent(laskin.tyhjennaNappi, 1, laskin.tyhjennaNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma);
        assertEquals("0", laskin.syoteKentta1.getText());
        laskin.getFrame().dispose();

    }

    @Test
    public void piirraTest() {
        laskin.syoteKentta1.setText("12");
        assertEquals("12", laskin.syoteKentta1.getText());
        ActionEvent tapahtuma = new ActionEvent(laskin.piirraNappi, 0, laskin.piirraNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma);
        assertEquals("12", laskin.syoteKentta1.getText());
        laskin.getFrame().dispose();
    }

    @Test
    public void piirraTestError() {
        laskin.syoteKentta1.setText("asd");
        assertEquals("asd", laskin.syoteKentta1.getText());
        ActionEvent tapahtuma = new ActionEvent(laskin.piirraNappi, 1, laskin.piirraNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma);
        assertEquals("asd", laskin.syoteKentta1.getText());
        laskin.getFrame().dispose();
    }

    @Test
    public void setNTest() {
        ActionEvent tapahtuma1 = new ActionEvent(laskin.piirraNappi, 1, laskin.piirraNappi.getActionCommand());
        assertEquals("0", laskin.syoteKentta1.getText());
        laskin.actionPerformed(tapahtuma1);
        laskin.syoteKentta1.setText("12");
        ActionEvent tapahtuma2 = new ActionEvent(laskin.piirraNappi, 1, laskin.piirraNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma2);
        assertEquals("12", laskin.syoteKentta1.getText());
    }

    @Test
    public void alustaNTest() {
        assertEquals(String.valueOf(alusta.n1), "0.0");
        assertEquals(String.valueOf(alusta.n2), "0.0");
        assertEquals(String.valueOf(alusta.n3), "0.0");
        assertEquals(String.valueOf(alusta.n4), "0.0");
    }

    @Test
    public void alustaSetNTest() {
        alusta.setN(3.1, 4.2, 5.3, 6.4);
        assertEquals(String.valueOf(alusta.n1), "3.1");
        assertEquals(String.valueOf(alusta.n2), "4.2");
        assertEquals(String.valueOf(alusta.n3), "5.3");
        assertEquals(String.valueOf(alusta.n4), "6.4");
    }

    @Test
    public void alustaAlkuTest() {
        alusta.tyhjennys = true;
        JFrame frame = new JFrame();
        frame.add(alusta);
        frame.pack();
        frame.repaint();
        assertEquals(alusta.piirtoY, 740);
        assertTrue(alusta.tyhjennys);
        BufferedImage bi = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();
        alusta.init(g2);
        assertEquals(alusta.piirtoY, 720);
    }

        @Test
    public void alustaPaintTest() {
        alusta.tyhjennys = true;
        JFrame frame = new JFrame();
        frame.add(alusta);
        frame.pack();
        frame.repaint();
        BufferedImage bi = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();
        alusta.paint(g2);
        assertEquals(alusta.piirtoY, 720);
    }
    
    @Test
    public void alustatyhjennysTest() {
        assertFalse(alusta.tyhjennys);
        alusta.tyhjenna();
        assertTrue(alusta.tyhjennys);
    }

}
