package edu.insightr.spellmonger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dam's on 07/12/2016.
 */
public class DeckTest {

    //@org.junit.Before
    private List<Card> deckJoueur;
    Deck deckplayer1 = new Deck();
    Deck deckplayer2 = new Deck();
    int numberCard=42;
    boolean  bool = true;
    int i =0 ;
    @Test
    public void  suffle() throws Exception {


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

}