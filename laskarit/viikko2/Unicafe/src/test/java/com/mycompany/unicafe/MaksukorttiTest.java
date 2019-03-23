package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void lataaminenToimii() {
        kortti.lataaRahaa(90);
        assertEquals("saldo: 1.0", kortti.toString());
    }

    @Test
    public void ottamineToimii() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    }
    

    @Test
    public void ottamineEiToimiJosEiRahaa() {
        kortti.otaRahaa(100);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void otaRahaaTrueToimii() {
        assertTrue(kortti.otaRahaa(1));
       
    }
        @Test
    public void otaRahaaFalseToimii() {
        assertFalse(kortti.otaRahaa(1000));
       
    }
}
