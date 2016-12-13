package edu.insightr.spellmonger;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dam's on 07/12/2016.
 */
public class DeckTest {

    //@org.junit.Before

     Deck deckplayer1 = new Deck();
     Deck deckplayer2 = new Deck();
     int CARDNUMBER =42;

    @Test
    public void CreationDeck(){
        int eagle = 0 ;
        int wolf=0;
        int bear=0;
        int curse=0;
        int shield=0;
        int blessing=0;
        final String eagleCard="Eagle";
        final String wolfCard="Wolf";
        final String bearCard="Bear";
        final String curseCard = "Curse";
        final String shieldCard = "Shield";
        final String blessingCard = "Blessing";

        assertEquals("number of card", CARDNUMBER,deckplayer1.GetDeck().size());

        for ( Card card : deckplayer1.GetDeck())
        {
            switch (card.getId())
                    {

                        case eagleCard:
                            eagle++;
                            break;

                        case wolfCard:
                            wolf++;
                            break;

                        case bearCard:
                            bear++;
                            break;

                        case curseCard :
                            curse++;
                            break;

                        case shieldCard:
                            shield++;
                            break;

                        case blessingCard:
                            blessing++;
                            break;
                    }
        }

        assertEquals("number of wolf",10,wolf);
        assertEquals("number of bear",10,bear);
        assertEquals("number of eagle",12,eagle);
        assertEquals("number of curse",3,curse);
        assertEquals("number of shield",5,shield);
        assertEquals("number of blessing",2,blessing);
    }

    @Test
    public void  suffle() throws Exception {
        boolean  bool = true;
        int i =0 ;

            List<Card> cardPlayer1= deckplayer1.GetDeck();
            List<Card> cardPLayer2=deckplayer2.GetDeck();
            if(cardPlayer1.get(i).equals(cardPLayer2.get(i)))
            {
                if(cardPlayer1.get(i+1).equals(cardPLayer2.get(i+1)))
                {
                    if(cardPlayer1.get(i+2).equals(cardPLayer2.get(i+2)))
                    {
                        if (cardPlayer1.get(i+3).equals(cardPLayer2.get(i+3)))
                        {
                            bool =false;
                        }
                    }
                }
            }

        assertSame("shuffle works ? ", true, bool);
    }
    @Test
    public void DistributionCarte(){

        List<Card> cardPlayer1=deckplayer1.GetDeck();
        assertEquals(42, cardPlayer1.size());

    }




}