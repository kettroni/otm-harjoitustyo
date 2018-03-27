/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roni
 */
public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void rahaaOikeaMaaraAlussa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void lounaitaMyytyNollaAlussa() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisellaOikeaRahanvaihtoJaMyyntilisaysMaksunRiittaessaEdullinen() {
        int vaihtoRaha = kassa.syoEdullisesti(300);
        assertEquals(1 + " " + 60, kassa.edullisiaLounaitaMyyty() + " " + vaihtoRaha);
    }

    @Test
    public void kateisellaOikeaRahanvaihtoJaMyyntilisaysMaksunRiittaessaMaukas() {
        int vaihtoRaha = kassa.syoMaukkaasti(450);
        assertEquals(1 + " " + 50, kassa.maukkaitaLounaitaMyyty() + " " + vaihtoRaha);
    }

    @Test
    public void kateismaksuEiRiittavaEdullinen() {
        int vaihtoRaha = kassa.syoEdullisesti(200);
        assertEquals(0 + " " + 200, kassa.edullisiaLounaitaMyyty() + " " + vaihtoRaha);
    }

    @Test
    public void kateismaksuEiRiittavaMaukas() {
        int vaihtoRaha = kassa.syoMaukkaasti(390);
        assertEquals(0 + " " + 390, kassa.maukkaitaLounaitaMyyty() + " " + vaihtoRaha);
    }

    @Test
    public void kortillaOikeaMyyntilisaysMaksunRiittaessaEdullinen() {
        boolean totuus = kassa.syoEdullisesti(kortti);
        assertEquals(1 + " " + true, kassa.edullisiaLounaitaMyyty() + " " + totuus);
    }

    @Test
    public void kortillaOikeaMyyntilisaysMaksunRiittaessaMaukas() {
        boolean totuus = kassa.syoMaukkaasti(kortti);
        assertEquals(1 + " " + true, kassa.maukkaitaLounaitaMyyty() + " " + totuus);
    }
    
    @Test
    public void kortillaEiRiitaPalauttaaFalseEdullinen() {
        Maksukortti temp = new Maksukortti(10);
        assertTrue(!kassa.syoEdullisesti(temp));
    }

    @Test
    public void kortillaEiRiitaPalauttaaFalseMaukas() {
        Maksukortti temp = new Maksukortti(10);
        assertTrue(!kassa.syoMaukkaasti(temp));
    }
    
    @Test
    public void kortillaEiRiitaEiKasvataMyyntiaEdullinen() {
        Maksukortti temp = new Maksukortti(10);
        kassa.syoEdullisesti(temp);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortillaEiRiitaEiKasvataMyyntiaMaukas() {
        Maksukortti temp = new Maksukortti(10);
        kassa.syoMaukkaasti(temp);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortillaEiRiitaEiVaheneSaldoEdullinen() {
        Maksukortti temp = new Maksukortti(10);
        kassa.syoEdullisesti(temp);
        assertEquals(10, temp.saldo());
    }
    
    @Test
    public void kortillaEiRiitaEiVaheneSaldoMaukas() {
        Maksukortti temp = new Maksukortti(10);
        kassa.syoMaukkaasti(temp);
        assertEquals(10, temp.saldo());
    }
    
    @Test
    public void kortillaOstaessaKassaRahaEiMuutuEdullinen() {
        int alussa = kassa.kassassaRahaa();
        kassa.syoEdullisesti(kortti);
        
        assertEquals(alussa, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortillaOstaessaKassaRahaEiMuutuMaukas() {
        int alussa = kassa.kassassaRahaa();
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(alussa, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattaessaKassarahaKasvaaOikein() {
        int alussa = kassa.kassassaRahaa();
        kassa.lataaRahaaKortille(kortti, 1);
        assertEquals(alussa + 1, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattaessaKortinSaldoVaheneeOikein() {
        int alussa = kortti.saldo();
        kassa.lataaRahaaKortille(kortti, 1);
        assertEquals(alussa + 1, kortti.saldo());
    }
    
    @Test
    public void kortilleLatausNegatiivisellaArvollaEiTeeMitaan() {
        int alussa = kortti.saldo();
        kassa.lataaRahaaKortille(kortti, -1);
        assertEquals(alussa, kortti.saldo());
    }
}
