// Mon test de Push

package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class SpellmongerApp {

    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    public static void main(String[] args)
    {
        Deck deck = new Deck(); //Creer un deck de 70 cartes aléatoire


        Player alice = new Player("Bob", 20);
        Player bob = new Player("Alice", 20);

        List<Player> players = new ArrayList<>(2);
        players.add(alice);
        players.add(bob);

        int roundCounter = 0;

        boolean jeu_fini = false;
        int degats;
        while (!jeu_fini) {


            Player current_player = players.get(roundCounter % 2); //Definit le tour des joueurs
            Player opponent = players.get((roundCounter+1) % 2 );

            System.out.println();
            System.out.println("Entering round " + roundCounter + "..."); //INFO
            Card card = deck.DrawCard();

            System.out.println(current_player.get_name()+" draw a "+ card.getId()); //INFO

            if(card.getId()==null)
            {
                jeu_fini = true;
                System.out.println("Plus de carte ! EGALITE !");
            }

            if(Card.EstUneCreature(card.getId()))
            {
                Creature actuelle_creature = new Creature(card.getId());
                degats = actuelle_creature.getDamage();
            }
            else
            {
                Ritual actuelle_rituel = new Ritual(card.getId());
                degats = actuelle_rituel.getValue();
            }

            if (degats>0) {
                opponent.damage(degats); //Inflige des degats a l'adversaire
                System.out.println(opponent.get_name()+" is hurt, "+ opponent.get_pv()+" hp left!");

            }
            else {
                current_player.damage(degats); //Se soigne sinon (Pas top)
                System.out.println(current_player.get_name()+" gets healed,  "+ current_player.get_pv()+" hp left!");
            }



            if(opponent.est_mort())
            {
                jeu_fini = true;
                logger.info(opponent.get_name() + " has " + opponent.get_pv() + " life points, he is dead, congrats.");
            }



            roundCounter++;
        }

    }








}