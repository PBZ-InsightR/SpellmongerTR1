package edu.insightr.spellmonger;

import java.util.*;
import static java.util.Collections.shuffle;

/**	Created by Chloé +  Dams on 04/10/2016.	**/

class Deck {

    private List<Card> deck;
    private  int NUMBEROFCARD =42;

    // An instantiated deck is mixed and established of 42 cards.
    Deck() {
        deck = new ArrayList<>(NUMBEROFCARD);
        deck = CreationDeck();
        shuffle(deck);
    }

    public  List<Card> CreationDeck() {
        Card card;
        int i;

        for (i = 0; i < (NUMBEROFCARD/4)+2; i++) {
            card = new Creature("Eagle");
            deck.add(card);
        }
        for (i = 0; i < NUMBEROFCARD/4; i++) {
            card = new Creature("Wolf");
            deck.add(card);
        }
        for (i = 0; i < NUMBEROFCARD/4; i++) {
            card = new Creature("Bear");
            deck.add(card);
        }
        for (i = 0; i < (NUMBEROFCARD/21)+1; i++) {
            card = new Ritual("Curse");
            deck.add(card);
        }
        for (i = 0; i < (NUMBEROFCARD/14)-1; i++) {
            card = new Ritual("Blessing");
            deck.add(card);
        }
        for (i = 0; i < NUMBEROFCARD/8; i++) {
            card = new Ritual("Shield");
            deck.add(card);
        }
        return  deck;
    }

    // Distrubute to every player a deck of 21 cards
    public List<Card> DistributionCarte() {
        Card drewCard = null;
        List<Card> deckJoueur = new ArrayList<>(NUMBEROFCARD /2);

        if (deck.size() != 0) {
            for (int i = 0; i < NUMBEROFCARD /2; i++) {
                try {
                    drewCard = deck.get(0);
                    deck.remove(0);
                }
                catch (IndexOutOfBoundsException e){}
                deckJoueur.add(drewCard);
            }
        } else {
            System.out.println("Deck wole");
            deckJoueur = null;
        }
        return deckJoueur;
    }

    // Fonction qui lorsqu'on lui donne une main affiche le contenu de la main du joueur concerné.
    public void AfficherDeck(List<Card> hand ) {
        // Initialisation de la Map
        Map<String, Integer> map = new HashMap<>();
        String[] tab = {"Eagle" , "Wolf" , "Bear" , "Curse" , "Blessing" , "Shield"};

        for (String card : tab) {
            map.put(card,0);
        }
        for (Card card : hand) {
            switch (card.getId()) {
                case "Eagle":
                    map.put("Eagle", map.get("Eagle") + 1);
                    break;

                case "Wolf":
                    map.put("Wolf", map.get("Wolf") + 1);
                    break;

                case "Bear":
                    map.put("Bear", map.get("Bear") + 1);
                    break;

                case "Curse":
                    map.put("Curse", map.get("Curse") + 1);
                    break;

                case "Blessing":
                    map.put("Blessing", map.get("Blessing") + 1);
                    break;

                case "Shield":
                    map.put("Shield", map.get("Shield") + 1);
                    break;
            }
        }

        System.out.print("This is your deck : \n " +
                "Eagle = " + map.get("Eagle") + "\n" +
                "Wolf = " + map.get("Wolf") + "\n" +
                "Bear = " + map.get("Bear") +"\n" +
                "Curse = " + map.get("Curse") +"\n" +
                "Blessing = " + map.get("Blessing")+ "\n" +
                "Shield =  " + map.get("Shield")
        );
    }

    public void AfficherMain(List<Card> hand )
    {

        System.out.println("You can choose a card : \n");
        int a=hand.size();
        for(int i=0; i<a ;i++)
        {
            System.out.print( i +" : "+ hand.get(i)+"\n");
        }
    }
    public List<Card> GetDeck(){
        return deck;
    }

    public  List<Card> GetDeck()
     {return deck;}
}
