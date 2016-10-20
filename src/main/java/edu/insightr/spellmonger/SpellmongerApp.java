package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;



public class SpellmongerApp {

    public static void main(String[] args)
    {
        Deck deck = new Deck(); //Creer un deck de 40 cartes en theorie mais la methode split le deck en 2 BUG
        Deck deck2 = new Deck();

        Player alice = new Player("alice", 20);
        Player bob = new Player("bob", 20);

        List<Player> players = new ArrayList<>(2);
        players.add(alice);
        players.add(bob);

        List<Card> deck_alice = deck.CreationMain();
        List<Card> deck_bob = deck2.CreationMain();

        int roundCounter = 0;

        boolean jeu_fini = false;
        while (!jeu_fini) {


            Player J1 = alice; //Definit le tour des joueurs
            Player J2 = bob;

            System.out.println();
            System.out.println("Entering round " + roundCounter + "..."); //INFO

            if (roundCounter==20)
            {
                if (J1.get_pv()>J2.get_pv())
                {
                    System.out.println(J1.get_name() +" win because he got more life point and there is no more cards ! ");
                }
              if(J2.get_pv()>J1.get_pv())
                {
                    System.out.println(J2.get_name() +" win because he got more life point and there is no more cards ! ");
                }
               if(J2.get_pv()==J1.get_pv())
               {
                   System.out.println(" Epic DRAW because same life point and there is no more cards ! ");
               }
                break;
            }
            Card card1 = deck_alice.get(roundCounter); //Pas encore d'ia, donc le joueur joue la carte 1 au t1, la carte 2 au t2, etc ..
            Card card2 = deck_bob.get(roundCounter);

            //System.out.println("Main de alice :");
           // deck.AfficherMain(deck_alice); //On affiche les main des joueurs. BUGGER ! A REGLER D'URGENCE POUR LE JAVA FX
            //System.out.println("Main de bob :");
            //deck.AfficherMain(deck_bob); //BUGGER ! A REGLER D'URGENCE POUR LE JAVA FX

            System.out.println(J1.get_name()+" draw a "+ card1.getId()); //INFO
            System.out.println(J2.get_name()+" draw a "+ card2.getId()); //INFO



              /*
             4 cas  sont possible ici ! Rituel vs Rituel,
                                          Crea vs Crea,
                                          Rituel vs Crea
                                          Crea vs Rituel.
               On gere tout les cas possibles.

              */



            if(card1 instanceof Creature && card2 instanceof Creature )
            {
                int damage_creature_J1 = ((Creature) card1).getDamage();
                int damage_creature_J2 = ((Creature) card2).getDamage();

               if(damage_creature_J1>damage_creature_J2)
                    {
                        J2.damage(damage_creature_J1-damage_creature_J2);
                    }
                else
                    {
                        J1.damage(damage_creature_J2-damage_creature_J1);
                    }
            }

           if(card1 instanceof Ritual  &&  card2 instanceof Ritual )
            {
                boolean shield_J1 = ((Ritual) card1).getShield();
                boolean shield_J2 = ((Ritual) card2).getShield();

                int damage_rituel_J1 = ((Ritual) card1).getValue();
                int damage_rituel_J2 = ((Ritual) card2).getValue();

                if(shield_J2 && damage_rituel_J1>0) //Si shield J2 on annule les degat du J1
                    {
                        damage_rituel_J1=0;
                    }
                if(shield_J1 && damage_rituel_J2>0) //Si shield J1 on annule les degat du J2
                    {
                        damage_rituel_J2=0;
                    }

                if(damage_rituel_J1>=0)//Si curse J1 on inflige a J2
                    {
                        J2.damage(damage_rituel_J1);
                    }
                else
                    {
                        J1.damage(damage_rituel_J1); //Sinon on soigne J1 pour son rituel soin
                    }

                if(damage_rituel_J2>=0) //Si curse J2 on inflige a J1
                    {
                        J1.damage(damage_rituel_J2);
                    }
                else                                //Sinon on soigne J1 pour son rituel soin
                    {
                        J2.damage(damage_rituel_J2);
                    }

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

            if(J1.est_mort() && J2.est_en_vie())
            {
                jeu_fini = true;
                System.out.println(J1.get_name() + " has " + J1.get_pv() + " life points, he is dead, congrats to "+ J2.get_name());
            }
            if(J2.est_mort() && J1.est_en_vie())
            {
                jeu_fini = true;
                System.out.println(J2.get_name() + " has " + J2.get_pv() + " life points, he is dead, congrats to "+ J1.get_name());
            }
            if(J2.est_mort() && J1.est_mort())
            {
                jeu_fini = true;
                if(J1.get_pv()>J2.get_pv())
                {
                    System.out.println(J1.get_name() + " and  " + J2.get_name() + " are deads but"+ J1.get_name() + " got more hp with "+ J1.get_pv()+" against "+ J2.get_pv() +" for "+J2.get_name()+" so "+J1.get_name()+"win !");
                }
                else
                {
                    System.out.println(J2.get_name() + " and  " + J1.get_name() + " are deads but"+ J2.get_name() + " got more hp with "+ J2.get_pv()+" against "+ J1.get_pv() +" for "+J1.get_name()+" so "+J2.get_name()+"win !");
                }
            }


            if (J1.est_en_vie() && J2.est_en_vie())
            {
                System.out.println(J1.get_name() +" got "+J1.get_pv()+" life points");
                System.out.println(J2.get_name() +" got "+J2.get_pv()+" life points");
            }

            roundCounter++;
        }

    }








}