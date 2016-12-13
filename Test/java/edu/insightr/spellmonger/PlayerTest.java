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

        Player player1 = new Player("Player1",20,deckplayer1);

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

        Card wolf = new Creature("Wolf");
        Card eagle= new Creature ("Eagle");

        damageTest= ((Creature)eagle).getDamage()-((Creature)wolf).getDamage();
        assertEquals(1,damageTest);

    }
    @Test
    public void estMort() throws Exception {
        Deck deck = new Deck();
        List<Card> deckPlayer = deck.GetDeck();

        int lifePoint = 10;
        Player P = new Player("PlayerTestEstMort", lifePoint, deckPlayer );

        // Case where Player is alive
        //Should return false
        boolean expected = false;
        assertEquals("Player is not dead", expected, P.estMort());

        //Case where Player is dead
        //Should return true
        lifePoint =0;
        expected = true;
        Player P_dead = new Player("PlayerDead", lifePoint, deck.DistributionCarte() );
        assertEquals("Player is dead ", expected, P_dead.estMort());
    }

    @Test
    public void estEnVie() throws Exception {
        Deck deck = new Deck();
        List<Card> deckPlayer = deck.GetDeck();

        int lifePoint = 10;
        Player P = new Player("PlayerTest EstEnVie", lifePoint, deckPlayer);

        //Case where Player is alive
        //Should return true
        boolean expected = true;
        assertEquals("Player is alive", expected, P.estEnVie());

        //Case where Player is dead
        //Should return false
        lifePoint = 0;
        expected = false;
        Player P_dead = new Player("PlayerDead", lifePoint, deck.DistributionCarte() );
        assertEquals("Player is dead ", expected, P_dead.estEnVie());
    }



    @Test
    public void rituVsRitu() throws Exception {

        Ritual shield= new Ritual("Shield");
        Ritual curse= new Ritual ("Curse");
        Ritual blessing=new Ritual("Blessing");
        int damageTest=0;


        int curseTest=curse.getValue();
        int blessingTest=blessing.getValue();

        assertEquals(+3,curseTest);
        assertEquals(-3,blessingTest);


    }

    @Test
    public void creaVsRituJ1() throws Exception {

        Card card1 = new Creature("Wolf");
        Ritual curse= new Ritual("Curse");

        boolean bool=true;
        int damageTest= ((Creature)card1).getDamage();

        assertEquals(2,damageTest);

    }

    @Test
    public void creaVsRituJ2() throws Exception {

    }

    @Test
    public void getPvTest() throws Exception {
        Deck deck = new Deck();
        List<Card> deckP = deck.GetDeck();

        int lifePoint = 20 ,expected = 20;
        Player P = new Player("PlayerTest",lifePoint, deckP);

        assertEquals("Player P has 20 life's point", expected, P.getPv());
    }

}