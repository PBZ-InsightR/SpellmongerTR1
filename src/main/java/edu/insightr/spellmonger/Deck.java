package edu.insightr.spellmonger;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
/**
 * Created by Chloé on 04/10/2016.
 *
 */
class Deck {

        private List<Card> l_carte;


        Deck(){

            l_carte= new ArrayList<>(70);
            mix();
        }


        private void mix() // Melange
        {
            List<String> ListPourMelanger = new ArrayList<>();

            int compteur=1;

            ListPourMelanger.add("Eagle");
            ListPourMelanger.add("Wolf");
            ListPourMelanger.add("Bear");
            ListPourMelanger.add("Curse");
            ListPourMelanger.add("Blessing");

            // On prépare une table pour la vérification future
            HashMap<String, Integer> hashmap = new HashMap<>();
            for(String s: ListPourMelanger)
            {
                hashmap.put(s,0);
            }

            do {


                String carte_nom = ListPourMelanger.get(NombreAleatoire(0,ListPourMelanger.size()-1));
                //System.out.println(carte_nom);
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

                int max_size = 14;
                hashmap.put(carte_nom, hashmap.get(carte_nom)+1);
                if(hashmap.get(carte_nom) == max_size)
                {
                    // on l'enleve du deck
                    ListPourMelanger.remove(carte_nom);
                }

            }while(compteur<70);


        }

        private static boolean EstUneCreature(String s)
        {
            boolean res = false;
            if(s.equals("Eagle") || s.equals("Wolf") ||s.equals("Bear"))
            {
                res = true;
            }

            return res;
        }

        private int NombreAleatoire(int min , int max ) // Renvoi un nombre aléatoire entre les bornes choisies
        {
            Random rand = new Random();

            return rand.nextInt(max-min+1)+min; //Formule mathematique

        }

        Card DrawCard()
        {
            Card carte_pioche = null;
            if(l_carte.size() != 0){
                carte_pioche=l_carte.get(0);
                l_carte.remove(0);
            }


            return carte_pioche;
        }

    }

