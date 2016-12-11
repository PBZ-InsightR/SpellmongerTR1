package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Dam's  on 11/12/2016. 
 */
public class PlayerTest {

    @Before
    public void Init()
    {


    }
    @Test
    public void damage() throws Exception {
        Deck deck1 = new Deck();
        List<Card> deckplayer1=deck1.GetDeck();
        List<Card> handPlayer1=deck1.GetMainactuelle();
        Player player1 = new Player("Player1",20,deckplayer1,handPlayer1);

        int pv = 0 ;
        pv = player1.getPv()-3;
        assertEquals("pv(20) - 3 ",17,pv);

        pv = player1.getPv()-0;
        assertEquals("pv(20)-0",20,pv);

        pv = player1.getPv()+3;
        assertEquals("pv(20)+3",23,pv);

    }
    @Test
    public void creaVsCrea() throws Exception {

        int damageTest =0;
        int damageTest2=0;
        Card card1 = new Card ("Eagle");
        Card card2 = new Card ("wolf");

        damageTest=card1.getDamage();
        damageTest2=card2.getDamage();
        assertEquals(1,damageTest);
        assertEquals(1,damageTest2);

    }
    @Test
    public void estMort() throws Exception {

    }

    @Test
    public void estEnVie() throws Exception {

    }



    @Test
    public void rituVsRitu() throws Exception {

    }

    @Test
    public void creaVsRituJ1() throws Exception {

    }

    @Test
    public void creaVsRituJ2() throws Exception {

    }

}