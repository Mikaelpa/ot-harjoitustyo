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
        assertEquals("\"Graafinen Laskin\"",laskin.getFrame().getTitle());
    }
    
    @Test
    public void alaPaneeliVisible() {
        assertTrue(laskin.getFrame().getContentPane().getComponent(1).isVisible());
    }
    
}
