package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    public KassapaateTest() {
    }

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void paateToimiiAlussa() {
        assertEquals(paate.kassassaRahaa(), 100000);
        assertEquals(0, paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoToimiiMaukas() {
        assertEquals(600, paate.syoMaukkaasti(1000));
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoToimiiEdullisesti() {
        assertEquals(760, paate.syoEdullisesti(1000));
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisOstoEiToimiJosEiRahaa() {
        paate.syoEdullisesti(1);

        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(12, paate.syoEdullisesti(12));
        assertEquals(12, paate.syoMaukkaasti(12));

    }

    @Test
    public void korttiOstoToimiiEdullinen() {
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiOstoToimiiMaukkaasti() {
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiOstoEiToimiJosEiRahaa() {
        Maksukortti uusi = new Maksukortti(10);
        assertFalse(paate.syoEdullisesti(uusi));
        assertFalse(paate.syoMaukkaasti(uusi));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void korttiLatausToimii() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(1100, kortti.saldo());

        assertEquals(100100, paate.kassassaRahaa());
    }

    @Test
    public void korttiLatausEiToimiJosEiRahaa() {
        paate.lataaRahaaKortille(kortti, -10);
        assertEquals(1000, kortti.saldo());

        assertEquals(100000, paate.kassassaRahaa());
    }

}
