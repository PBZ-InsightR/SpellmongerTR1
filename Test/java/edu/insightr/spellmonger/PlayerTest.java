package edu.insightr.spellmonger;

//import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Dam's  on 11/12/2016. 
 */
public class PlayerTest {

    /*@Before
    public void Init()
    {


    }*/
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
        Deck deck = new Deck();
        List<Card> deckPlayer = deck.GetDeck();
        List<Card> hand = deck.GetMainactuelle();
        int lifePoint = 10;
        Player P = new Player("PlayerTestEstMort", lifePoint, deckPlayer, hand );

        // Case where Player is alive
        //Should return false
        boolean expected = false;
        assertEquals("Player is not dead", expected, P.estMort());

        //Case where Player is dead
        //Should return true
        lifePoint =0;
        expected = true;
        Player P_dead = new Player("PlayerDead", lifePoint, deck.DistributionCarte(),hand );
        assertEquals("Player is dead ", expected, P_dead.estMort());
    }

    @Test
    public void estEnVie() throws Exception {
        Deck deck = new Deck();
        List<Card> deckPlayer = deck.GetDeck();
        List<Card> hand = deck.GetMainactuelle();
        int lifePoint = 10;
        Player P = new Player("PlayerTest EstEnVie", lifePoint, deckPlayer, hand );

        //Case where Player is alive
        //Should return true
        boolean expected = true;
        assertEquals("Player is alive", expected, P.estEnVie());

        //Case where Player is dead
        //Should return false
        lifePoint = 0;
        expected = false;
        Player P_dead = new Player("PlayerDead", lifePoint, deck.DistributionCarte(),hand );
        assertEquals("Player is dead ", expected, P_dead.estEnVie());
    }



    @Test
    public void rituVsRitu() throws Exception {

        Card card1= new Card("Eagle");
        Card card2 = new Card("Wolf");

        

    }

    @Test
    public void creaVsRituJ1() throws Exception {

    }

    @Test
    public void creaVsRituJ2() throws Exception {

    }

    @Test
    public void getPvTest() throws Exception {
        Deck deck = new Deck();
        List<Card> deckP = deck.GetDeck();
        List<Card> handP = deck.GetMainactuelle();
        int lifePoint = 20 ,expected = 20;
        Player P = new Player("PlayerTest",lifePoint, deckP,handP);

        assertEquals("Player P has 20 life's point", expected, P.getPv());
    }

}