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
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinToStringToimiiOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void luotuKorttiOikeaAlkusaldo() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void lataaminenLisaaOikeanMaaran() {
        kortti.lataaRahaa(1);
        assertEquals(11, kortti.saldo());
    }
    
    @Test
    public void ottaminenVahentaaSaldoa() {
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosOtetaanLiikaa() {
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void palauttaaTrueJosRiittaa() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void palauttaaFalseJosEiRiita() {
        assertEquals(false, kortti.otaRahaa(11));
    }
}
