// Mon test de Push

package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static edu.insightr.spellmonger.Card.EstUneCreature;

public class SpellmongerApp {

    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    public static void main(String[] args)
    {
        Deck deck = new Deck();


        Player alice = new Player("chloe", 20);
        Player bob = new Player("daniel", 20);

        List<Player> players = new ArrayList<>(2);
        players.add(alice);
        players.add(bob);

        int currentCardNumber = 0;
        int roundCounter = 1;

        boolean jeu_fini = false;
        while (!jeu_fini) {
            // not a good solution ...
            Player current_player = players.get((roundCounter+1) % 2);
            Player opponent = players.get(roundCounter % 2);

            //logger.info("\n");
            //logger.info("***** ROUND " + roundCounter);

            System.out.println("Entering round " + roundCounter + "...");
            Card card = deck.DrawCard();
            if(card == null)
            {
                jeu_fini = true;
                break;
            }

            if(Card.EstUneCreature(card.getId()))
            {
                current_player.ajouter_creature((Creature)card);
            }
            else
            {
                // apply the ritual :) not a good idea to do it here
                Ritual ritual = (Ritual)card;
                if(card.getId() == "Blessing")
                {
                    current_player.soin(ritual.getValue());
                }
                else if(card.getId() == "Curse")
                {
                    opponent.damage(-ritual.getValue());
                }
            }

            int degats = current_player.calcul_degats_creatures();

            opponent.damage(degats);

            if(opponent.est_mort())
            {
                jeu_fini = true;
                logger.info(opponent.get_name() + " has " + opponent.get_pv() + " life points, he is dead, congrats.");
                break;
            }



            roundCounter++;
        }

    }








}