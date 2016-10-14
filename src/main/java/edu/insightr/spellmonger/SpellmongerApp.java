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
        int degats_joueur1;
        int degats_joueur2;
        while (!jeu_fini) {


            Player J1 = alice; //Definit le tour des joueurs
            Player J2 = bob;

            System.out.println();
            System.out.println("Entering round " + roundCounter + "..."); //INFO

            Card card1 = deck.DrawCard();
            Card card2 = deck.DrawCard();

            System.out.println(J1.get_name()+" draw a "+ card1.getId()); //INFO
            System.out.println(J2.get_name()+" draw a "+ card2.getId()); //INFO

            if(card1==null || card2==null )
            {
                jeu_fini = true;
                System.out.println("Plus de cartes ! EGALITE !");
            }

            if(card1 instanceof Creature && card2 instanceof Creature )
            {
                int damage_creature_J1 = ((Creature) card1).getDamage();
                int damage_creature_J2 = ((Creature) card2).getDamage();

                int tab[]={ damage_creature_J1, damage_creature_J2 };


                //IMPLEMENTER POUR 2 CREA
            }
           if(card1 instanceof Creature  &&  card2 instanceof Creature )
            {
                int damage_rituel_J1 = ((Creature) card1).getDamage();
                int damage_rituel_J2 = ((Creature) card2).getDamage();

                //IMPLEMENTER POUR 2 Ritu
            }

            else
            {


            }










            /*Implementer une méthode pour comparer les dégats des joueurs
            if (degats_joueur1==0 || degats_joueur2==0){
                degats_joueur1=0;
                degats_joueur2=0;
            }
            if (degats_joueur1>degats_joueur2) {
                J2.damage(degats_joueur1-degats_joueur2); //Inflige des degats a l'adversaire
                System.out.println(J2.get_name()+" is hurt, "+ J2.get_pv()+" hp left!");

            }
            if(opponent.est_mort())
            {
                jeu_fini = true;
                logger.info(opponent.get_name() + " has " + opponent.get_pv() + " life points, he is dead, congrats.");
            }
            */

            roundCounter++;
        }

    }








}