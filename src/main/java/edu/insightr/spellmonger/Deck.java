package edu.insightr.spellmonger;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
/**
 * Created by Chloé on 04/10/2016.
 */
public class Deck {

        private List<Card> l_carte;


        public Deck(){

            l_carte= new ArrayList<>(70);
            mix();
        }


        public void mix() // Melange
        {
            List<String> ListPourMelanger = new ArrayList<>();

            int compteur=1;

            ListPourMelanger.add("Eagle");
            ListPourMelanger.add("Wolf");
            ListPourMelanger.add("Bear");
            ListPourMelanger.add("Curse");
            ListPourMelanger.add("Blessing");

            do {


                String carte_nom = ListPourMelanger.get(NombreAleatoire(0,4));
                if(EstUneCreature(carte_nom))
                {
                    Card new_carte= new Creature(carte_nom);
                    l_carte.add(new_carte);
                }
                else
                {
                    Card new_carte= new Ritual(carte_nom);//choisit au hasard une carte.
                    l_carte.add(new_carte);
                }

                compteur++;

            /*dés qu'il y a eu au moins 14 cartes créees il est possible qu'un type soit repeté plus  de 14 fois.
            Donc je vérifie pour chaque type,dans le deck,ci celui ci n'est pas present plus de 14 fois ; si c'est le cas je la supprime
            de "ListPourMelanger" pour qu'elle ne soit plus crée dans le deck.*/

                if (compteur>=14) {
                    int verification=0;
                    for (Card carte : l_carte) {
                        if (carte.getId().equals("Eagle"))
                            verification++;
                        if (verification > 14) {

                            for (int i = 0; i < ListPourMelanger.size(); i++) {
                                if ("Eagles".equals(ListPourMelanger.get(i)))
                                    ListPourMelanger.remove(i);

                            }

                        }
                    }
                    verification = 0;
                    for (Card carte : l_carte) {
                        if (carte.getId().equals("Wolf"))
                            verification++;
                        if (verification > 14) {

                            for (int i = 0; i < ListPourMelanger.size(); i++) {
                                if ("Wolf".equals(ListPourMelanger.get(i)))
                                    ListPourMelanger.remove(i);

                            }

                        }
                    }
                    verification = 0;
                    for (Card carte : l_carte) {
                        if (carte.getId().equals("Bear"))
                            verification++;
                        if (verification > 14) {

                            for (int i = 0; i < ListPourMelanger.size(); i++) {
                                if ("Bear".equals(ListPourMelanger.get(i)))
                                    ListPourMelanger.remove(i);

                            }

                        }
                    }
                    verification = 0;
                    for (Card carte : l_carte) {
                        if (carte.getId().equals("Curse"))
                            verification++;
                        if (verification > 14) {

                            for (int i = 0; i < ListPourMelanger.size(); i++) {
                                if ("Curse".equals(ListPourMelanger.get(i)))
                                    ListPourMelanger.remove(i);

                            }

                        }
                    }
                    verification = 0;
                    for (Card carte : l_carte) {
                        if (carte.getId().equals("Blessing"))
                            verification++;
                        if (verification > 14) {

                            for (int i = 0; i < ListPourMelanger.size(); i++) {
                                if ("Blessing".equals(ListPourMelanger.get(i)))
                                    ListPourMelanger.remove(i);

                            }

                        }
                    }
                }

            }while(compteur<70);


        }

        public static boolean EstUneCreature(String s)
        {
            boolean res = false;
            if(s == "Eagle" || s == "Wolf" ||s == "Bear")
            {
                res = true;
            }

            return res;
        }

        public int NombreAleatoire(int min , int max ) // Renvoi un nombre aléatoire entre les bornes choisies
        {
            Random rand = new Random();

            int nombreAleatoire= rand.nextInt(max-min+1)+min; //Formule mathematique

            return nombreAleatoire;

        }

        public Card DrawCard()
        {
            Card carte_pioche = null;
            if(l_carte.size() == 0)
            {
            }
            else
            {
                carte_pioche=l_carte.get(0);
                l_carte.remove(0);
            }

            return carte_pioche;
        }

        public Card DiscardCard(Card cartepioche) // Not sure what it means, draw a card and not use it ?
        {
            return DrawCard();
        }
    }

