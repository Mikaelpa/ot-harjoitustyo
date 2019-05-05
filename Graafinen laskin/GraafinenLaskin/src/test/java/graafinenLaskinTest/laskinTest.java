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

    Kayttoliittyma gui;
    Piirtoalusta canvas;

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
        gui = new Kayttoliittyma();
        gui.run();
        canvas = new Piirtoalusta(0, 0, 0, 0);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void makesFrameTest() {
        assertEquals("\"Graafinen Laskin\"", gui.getFrame().getTitle());
        gui.getFrame().dispose();
    }

    @Test
    public void frameCorrHeightTest() {
        assertEquals(100, gui.getFrame().getHeight());
    }

    @Test
    public void frameCorrWidthTest() {
        assertEquals(400, gui.getFrame().getWidth());
    }

    @Test
    public void lowerPanelVisibleTest() {
        assertTrue(gui.getFrame().getContentPane().getComponent(1).isVisible());
        gui.getFrame().dispose();
    }

    @Test
    public void clearBoardTest() {
        gui.text1.setText("12");
        assertEquals("12", gui.text1.getText());
        ActionEvent tapahtuma = new ActionEvent(gui.clearButton, 1, gui.clearButton.getActionCommand());
        gui.actionPerformed(tapahtuma);
        assertEquals("0", gui.text1.getText());
        gui.getFrame().dispose();

    }

    @Test
    public void drawTest() {
        gui.text1.setText("12");
        assertEquals("12", gui.text1.getText());
        ActionEvent tapahtuma = new ActionEvent(gui.drawButton, 0, gui.drawButton.getActionCommand());
        gui.actionPerformed(tapahtuma);
        assertEquals("12", gui.text1.getText());
        gui.getFrame().dispose();
    }

    @Test
    public void drawErrorTest() {
        gui.text1.setText("asd");
        assertEquals("asd", gui.text1.getText());
        ActionEvent tapahtuma = new ActionEvent(gui.drawButton, 1, gui.drawButton.getActionCommand());
        gui.actionPerformed(tapahtuma);
        assertEquals("asd", gui.text1.getText());
        gui.getFrame().dispose();
    }

    @Test
    public void setNTest() {
        ActionEvent tapahtuma1 = new ActionEvent(gui.drawButton, 1, gui.drawButton.getActionCommand());
        assertEquals("0", gui.text1.getText());
        gui.actionPerformed(tapahtuma1);
        gui.text1.setText("12");
        ActionEvent tapahtuma2 = new ActionEvent(gui.drawButton, 1, gui.drawButton.getActionCommand());
        gui.actionPerformed(tapahtuma2);
        assertEquals("12", gui.text1.getText());
    }

    @Test
    public void canvasNTest() {
        assertEquals(String.valueOf(canvas.n1), "0.0");
        assertEquals(String.valueOf(canvas.n2), "0.0");
        assertEquals(String.valueOf(canvas.n3), "0.0");
        assertEquals(String.valueOf(canvas.n4), "0.0");
    }

    @Test
    public void canvasSetNTest() {
        canvas.setN(3.1, 4.2, 5.3, 6.4);
        assertEquals(String.valueOf(canvas.n1), "3.1");
        assertEquals(String.valueOf(canvas.n2), "4.2");
        assertEquals(String.valueOf(canvas.n3), "5.3");
        assertEquals(String.valueOf(canvas.n4), "6.4");
    }

    @Test
    public void canvasInitTest() {
        canvas.clear = true;
        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.repaint();
        assertEquals(canvas.functionDrawY, 740);
        assertTrue(canvas.clear);
        BufferedImage bi = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();
        canvas.init(g2);
        assertEquals(canvas.functionDrawY, 720);
    }

        @Test
    public void canvasPaintTest() {
        canvas.clear = true;
        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.repaint();
        BufferedImage bi = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();
        canvas.paint(g2);
        assertEquals(canvas.functionDrawY, 720);
    }
    
    @Test
    public void canvasClearTest() {
        assertFalse(canvas.clear);
        canvas.clearBoard();
        assertTrue(canvas.clear);
    }

}
