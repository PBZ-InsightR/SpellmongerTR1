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

}
