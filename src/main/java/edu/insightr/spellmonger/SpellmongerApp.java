package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;



public class SpellmongerApp {

    public static void main(String[] args)
    {
        Deck deck = new Deck();
        int NOMBREDECARTE = 20;
        int roundCounter = 0;
        boolean jeu_fini = false;

        Player J1 = new Player("alice", NOMBREDECARTE ,deck.CreationMain());
        Player J2 = new Player("bob", NOMBREDECARTE ,deck.CreationMain());



        while (!jeu_fini) {

            System.out.println();
            System.out.println("Entering round " + roundCounter + "..."); //INFO

            if (roundCounter==NOMBREDECARTE)
            {
                if (J1.getPv()>J2.getPv())
                {
                    System.out.println(J1.getName() +" win because he got more life point and there is no more cards ! ");
                }
              if(J2.getPv()>J1.getPv())
                {
                    System.out.println(J2.getName() +" win because he got more life point and there is no more cards ! ");
                }
               if(J2.getPv()==J1.getPv())
               {
                   System.out.println(" Epic DRAW because same life point and there is no more cards ! ");
               }
                break;
            }
            Card card1 = J1.getDeckDuJoueur().get(roundCounter); //Pas encore d'ia, donc le joueur joue la carte 1 au t1, la carte 2 au t2, etc ..
            Card card2 = J2.getDeckDuJoueur().get(roundCounter);

            //System.out.println("Main de alice :");
           // deck.AfficherMain(deck_alice); //On affiche les main des joueurs. BUGGER ! A REGLER D'URGENCE POUR LE JAVA FX
            //System.out.println("Main de bob :");
            //deck.AfficherMain(deck_bob); //BUGGER ! A REGLER D'URGENCE POUR LE JAVA FX

            System.out.println(J1.getName()+" draw a "+ card1.getId()); //INFO
            System.out.println(J2.getName()+" draw a "+ card2.getId()); //INFO



              /*
             4 cas  sont possible ici ! Rituel vs Rituel,
                                          Crea vs Crea,
                                          Rituel vs Crea
                                          Crea vs Rituel.
               On gere tout les cas possibles.

              */



            if(card1 instanceof Creature && card2 instanceof Creature )
            {
                J2.creaVsCrea(card1,card2);
                J1.creaVsCrea(card2,card1);
            }

           if(card1 instanceof Ritual  &&  card2 instanceof Ritual )
            {
               J1.rituVsRitu(card1,card2);
               J2.rituVsRitu(card2,card1);

            }

            if(card1 instanceof Ritual  &&  card2 instanceof Creature )
            {
                boolean shield_J1 = ((Ritual) card1).getShield();
                int damage_rituel_J1 = ((Ritual) card1).getValue();
                int damage_creature_J2 = ((Creature) card2).getDamage();

                if (!shield_J1) {

                    if (damage_rituel_J1 > 0) {
                        J1.damage(damage_creature_J2);
                        J2.damage(damage_rituel_J1);
                    }
                    if (damage_rituel_J1 < 0) {
                        J1.damage(damage_creature_J2);
                        J1.damage(damage_rituel_J1); //soin
                    }
                }
            }

            if(card2 instanceof Ritual  &&  card1 instanceof Creature ) //Copié collé du dessus en inversant les joueurs et les cartes desole
            {
                boolean shield_J2 = ((Ritual) card2).getShield();
                int damage_rituel_J2 = ((Ritual) card2).getValue();
                int damage_creature_J1 = ((Creature) card1).getDamage();

                if(!shield_J2)
                {
                    if(damage_rituel_J2>0)
                    {
                    J1.damage(damage_creature_J1);
                    J2.damage(damage_rituel_J2);
                    }
                    if(damage_rituel_J2<0)
                    {
                    J2.damage(damage_creature_J1);
                    J2.damage(damage_rituel_J2); //soin
                    }
                }
            }



            //3 cas possible pour la victoire ou l'egalite

            if(J1.estMort() && J2.estEnVie())
            {
                jeu_fini = true;
                System.out.println(J1.getName() + " has " + J1.getPv() + " life points, he is dead, congrats to "+ J2.getName());
            }
            if(J2.estMort() && J1.estEnVie())
            {
                jeu_fini = true;
                System.out.println(J2.getName() + " has " + J2.getPv() + " life points, he is dead, congrats to "+ J1.getName());
            }
            if(J2.estMort() && J1.estMort())
            {
                jeu_fini = true;
                if(J1.getPv()>J2.getPv())
                {
                    System.out.println(J1.getName() + " and  " + J2.getName() + " are deads but"+ J1.getName() + " got more hp with "+ J1.getPv()+" against "+ J2.getPv() +" for "+J2.getName()+" so "+J1.getName()+"win !");
                }
                else
                {
                    System.out.println(J2.getName() + " and  " + J1.getName() + " are deads but"+ J2.getName() + " got more hp with "+ J2.getPv()+" against "+ J1.getPv() +" for "+J1.getName()+" so "+J2.getName()+"win !");
                }
            }



                System.out.println(J1.getName() +" got "+J1.getPv()+" life points");
                System.out.println(J2.getName() +" got "+J2.getPv()+" life points");
            

            roundCounter++;
        }

    }








}