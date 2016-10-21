package edu.insightr.spellmonger;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
/**
 * Created by Chloé +  Dams on 04/10/2016.
 *
 */
class Deck {

     private List<Card> l_carte;


    Deck(){

        l_carte= new ArrayList<>(40);
        mix();
    }


    private void mix() // Melange
    {
        List<String> ListPourMelanger = new ArrayList<>();

        int compteur=0;
        int max_size=0;

        ListPourMelanger.add("Eagle");
        ListPourMelanger.add("Wolf");
        ListPourMelanger.add("Bear");
        ListPourMelanger.add("Curse");
        ListPourMelanger.add("Blessing");
        ListPourMelanger.add("Shield");

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

                // Chaque Créature doit être presente au maximum 10 fois .
                max_size = 10;
                hashmap.put(carte_nom, hashmap.get(carte_nom)+1);
                if(hashmap.get(carte_nom) == max_size)
                {
                    // on l'enleve du deck
                    ListPourMelanger.remove(carte_nom);
                }
            }
            else
            {
                Card new_carte= new Ritual(carte_nom);//choisit au hasard une carte.
                l_carte.add(new_carte);
            // Les rituels ne sont pas tous present en nombre identique.
                if (new_carte.getId().equals("Curse")) {
                    max_size = 2;
                    hashmap.put(carte_nom, hashmap.get(carte_nom) + 1);
                    if (hashmap.get(carte_nom) == max_size) {

                        ListPourMelanger.remove(carte_nom);
                    }
                } else if (new_carte.getId().equals("Blessing")) {
                    max_size = 3;
                    hashmap.put(carte_nom, hashmap.get(carte_nom) + 1);
                        if (hashmap.get(carte_nom) == max_size) {

                            ListPourMelanger.remove(carte_nom);
                        }
                    else {
                        max_size = 5;
                        hashmap.put(carte_nom, hashmap.get(carte_nom) + 1);
                            if (hashmap.get(carte_nom) == max_size) {

                                ListPourMelanger.remove(carte_nom);
                            }
                        }
                }
            }

            compteur++;



        }while(compteur<40);


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

    //Permet à un joueur de recuperer une main de 20 cartes.

    public List<Card> CreationMain() {
        Card carte_pioche = null;
        List<Card> la_main= new ArrayList<>(20);
        if (l_carte.size() != 0) {
            for (int i = 0; i < 20; i++)
            {
                try {
                carte_pioche = l_carte.get(0);
                l_carte.remove(0);
                }
                catch (IndexOutOfBoundsException e){}
                la_main.add(carte_pioche);
            }

        } else {
            System.out.println("Deck vide");
            la_main=null;
        }
        return la_main;


    }

    // Fonction qui lorsqu'on lui donne une main affiche le contenu de la main du joueur concerné.

    public void AfficherMain(List<Card> Une_main ) {


        HashMap<String, Integer> hashmap = new HashMap();
        String[] tab = {" Eagle , Wolf , Bear , Curse , Blessing , Shield"};

        for (String carte : tab) {
            hashmap.put(carte, 0);
        }


        for (Card card : Une_main) {

            switch (card.getId()) {

                case "Eagle":
                    hashmap.put("Eagle", hashmap.get("Eagle") + 1);

                case "Wolf":
                    hashmap.put("Wolf", hashmap.get("Wolf") + 1);

                case "Bear":
                    hashmap.put("Bear", hashmap.get("Bear") + 1);

                case "Curse":
                    hashmap.put("Curse", hashmap.get("Curse") + 1);

                case "Blessing":
                    hashmap.put("Blessing", hashmap.get("Blessing") + 1);

                case "Shield":
                    hashmap.put("Shield", hashmap.get("Shield") + 1);

            }
        }

        System.out.print(
                "This is your hand : " +
                        "Eagle = " + hashmap.get("Eagle") +
                        "Wolf = " + hashmap.get("Wolf") +
                        "Bear = " + hashmap.get("Bear") +
                        "Curse = " + hashmap.get("Curse") +
                        "Blessing = " + hashmap.get("Blessing") +
                        "Shield =  " + hashmap.get("Eagle")
        );
    }
       public Card PickCard(List<Card> Une_main , int i)
        {
           Card carte_choisit;
           carte_choisit = Une_main.get(i);
           return carte_choisit;
        }
    }



