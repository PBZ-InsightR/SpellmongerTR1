package edu.insightr.spellmonger;


public class SpellmongerApp {

    public static void main(String[] args)
    {
        Deck deck = new Deck();
        final int NOMBREDECARTE = 20;
        final int LIFEPOINT = 20;
        int roundCounter = 0;
        boolean jeu_fini = false;

        Player J1 = new Player("alice", LIFEPOINT ,deck.DistributionCarte());
        Player J2 = new Player("bob", LIFEPOINT ,deck.DistributionCarte());

        do  {

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
            //IMPLEMENTER L'IA ICI
            IA IA_J1= new IA(J1.getDeckDuJoueur());
            Card card1 = IA_J1.ChooseBestCard();
            //Card card1 = J1.getDeckDuJoueur().get(roundCounter); //Pas encore d'ia, donc le joueur joue la carte 1 au t1, la carte 2 au t2, etc ..
            Card card2 = J2.getDeckDuJoueur().get(0);
/*
            System.out.println("/n Main de alice :");
            deck.AfficherMain(J1.getDeckDuJoueur()); //On affiche les main des joueurs. Mais prend bcp de place dans les logs
            System.out.println("/n Main de bob :");
            deck.AfficherMain(J2.getDeckDuJoueur());
*/
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
                J1.CreaVsRituJ1(card1,card2);
                J2.CreaVsRituJ2(card1,card2);

            }
            if(card2 instanceof Ritual  &&  card1 instanceof Creature )
            {
                J2.CreaVsRituJ1(card2,card1);
                J1.CreaVsRituJ2(card2,card1);
            }

            J1.getDeckDuJoueur().remove(card1);
            J2.getDeckDuJoueur().remove(card2);

            //Affichage des points de vie des joueurs
            System.out.println(J1.getName() +" got "+J1.getPv()+" life points");
            System.out.println(J2.getName() +" got "+J2.getPv()+" life points");

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
                    System.out.println(J1.getName() + " and  " + J2.getName() + " are deads but "+ J1.getName() + " got more hp with "+ J1.getPv()+" against "+ J2.getPv() +" for "+J2.getName()+" so "+J1.getName()+" win !");
                }
                else
                {
                    System.out.println(J2.getName() + " and  " + J1.getName() + " are deads but "+ J2.getName() + " got more hp with "+ J2.getPv()+" against "+ J1.getPv() +" for "+J1.getName()+" so "+J2.getName()+" win !");
                }
            }

            roundCounter++;
        } while (!jeu_fini);

    }








}