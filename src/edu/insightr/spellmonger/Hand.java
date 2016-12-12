package edu.insightr.spellmonger;
import java.util.*;

public class Hand
{
    private List<Card> main_joueur ;

    Hand(List<Card> deck )
    {
        main_joueur = new ArrayList<>(3);
        this.main_joueur.add(deck.get(0));
        this.main_joueur.add(deck.get(1));
        this.main_joueur.add(deck.get(2));

        deck.remove(2);
        deck.remove(1);
        deck.remove(0);

    }
    List<Card> GetMainJoueur(){return main_joueur;}

    public List<Card> choix_carte_main(List<Card> deckJoueur){
        Card cartePiocheDeckJoueur = null;

        if (main_joueur.size() == 0)
            for (int i =0; i < 3; i++) {
                try {
                    cartePiocheDeckJoueur = deckJoueur.get(0);
                    deckJoueur.remove(0);
                    main_joueur.add(cartePiocheDeckJoueur);
                }
                catch (IndexOutOfBoundsException e){
                }
            } else {
            System.out.println("Main actuelle non vide");
        }
        return main_joueur;
    }
}
