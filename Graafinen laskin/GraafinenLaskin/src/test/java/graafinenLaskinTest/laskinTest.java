/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graafinenLaskinTest;

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import graafinenlaskin.GraafinenLaskin;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class laskinTest {

    GraafinenLaskin laskin;

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
        laskin = new GraafinenLaskin();
        laskin.run();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tekeeAlussaFramen() {
        assertEquals("\"Graafinen Laskin\"", laskin.getFrame().getTitle());
    }

    @Test
    public void alaPaneeliVisible() {
        assertTrue(laskin.getFrame().getContentPane().getComponent(1).isVisible());
    }

    @Test
    public void tyhjennaTest() {
        laskin.syoteKentta1.setText("12");
        assertEquals("12", laskin.syoteKentta1.getText());
        ActionEvent tapahtuma = new ActionEvent(laskin.tyhjennaNappi, 0, laskin.tyhjennaNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma);
        assertEquals("0", laskin.syoteKentta1.getText());
    }

    @Test
    public void piirraTest() {
        laskin.syoteKentta1.setText("12");
        assertEquals("12", laskin.syoteKentta1.getText());
        ActionEvent tapahtuma = new ActionEvent(laskin.piirraNappi, 0, laskin.piirraNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma);
        assertEquals("12", laskin.syoteKentta1.getText());
    }

    @Test
    public void piirraTestError() {
        laskin.syoteKentta1.setText("asd");
        assertEquals("asd", laskin.syoteKentta1.getText());
        ActionEvent tapahtuma = new ActionEvent(laskin.piirraNappi, 1, laskin.piirraNappi.getActionCommand());
        laskin.actionPerformed(tapahtuma);
        assertEquals("asd", laskin.syoteKentta1.getText());
    }

}
