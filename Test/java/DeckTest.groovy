package java

import edu.insightr.spellmonger.Card
import edu.insightr.spellmonger.Creature
import edu.insightr.spellmonger.Ritual

/**
 * Created by Dam's on 30/11/2016.
 */
class DeckTest extends GroovyTestCase {
    void setUp() {
        super.setUp()

    }
    // Testons si nous obtenons bien 42 cartes;
    void testCreationDeck() {

        Card card;
        int i;
        int resultat=42;

        for (i = 0; i < nombreCarte/4; i++) {

            card = new Creature("Eagle");
            deck.add(card) ;
        }
        for (i = 0; i < nombreCarte/4; i++) {

            card = new Creature("Wolf");
            deck.add(card);
        }
        for (i = 0; i < nombreCarte/4; i++) {

            card = new Creature("Bear");
            deck.add(card);
        }

        for (i = 0; i < nombreCarte/21; i++) {
            card = new Ritual("Curse");
            deck.add(card);

        }

        for (i = 0; i < (nombreCarte/14); i++) {
            card = new Ritual("Blessing");
            deck.add(card);

        }
        for (i = 0; i < nombreCarte/8; i++) {
            card = new Ritual("Shield");
            deck.add(card);

        }


        assertEquals("nombre de cartes retournées",resultat,deck.size());

    }

    void testMix() {

    }

    void testCreationMain() {

        Card cartePiocheDeckJoueur=null;
        List<Card>mainActuelle= new ArrayList<>(3);
        int verification=3;

        if ( mainActuelle.size()==0)
            for (int i =0; i<3; i++) {
                try {
                    cartePiocheDeckJoueur=deckJoueur.get(0);
                    deckJoueur.remove(0);
                    mainActuelle.add(cartePiocheDeckJoueur);
                }
                catch (IndexOutOfBoundsException e){
                }

            }

            assertEquals(verification,)


        }




    }

    void testAfficherMain() {

    }

    void testPickCard() {

    }
}
