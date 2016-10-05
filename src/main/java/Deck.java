import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dam's on 01/10/2016.
 *
 * Il y a 70 cartes: pour un melange cohérant,la fonction mix() creer un deck ou chaque carte (Eagle , Wolf , Bear,Curse , Blessing) existe 14 fois chacune ( 70/5)
 * Il faudrait demander au client si il souhaite un nombre de carte propre à chaque carte.
 */
public class Deck {


    private List<Carte> deck  ;

    private List<String> ListPourMelanger;
    public Deck(){

        deck= new ArrayList<>(70);
        mix();
    }


    public void mix() // Melange
    {
        int compteur=1;
        int verification=0;

        ListPourMelanger.add("Eagle");
        ListPourMelanger.add("Wolf");
        ListPourMelanger.add("Bear");
        ListPourMelanger.add("Curse");
        ListPourMelanger.add("Blessing");


        do {

            Carte new_carte=new Carte();
            new_carte.SetName(ListPourMelanger.get(NombreAleatoire(0,ListPourMelanger.size())));//choisit au hasard une carte.
            deck.add(new_carte);
            compteur++;

            /*dés qu'il y a eu au moins 14 cartes créees il est possible qu'un type soit repeté plus  de 14 fois.
            Donc je vérifie pour chaque type,dans le deck,ci celui ci n'est pas present plus de 14 fois ; si c'est le cas je la supprime
            de "ListPourMelanger" pour qu'elle ne soit plus crée dans le deck.*/

            if (compteur>=14) {
                for (Carte carte : deck) {
                    if (carte.GetName().equals("Eagle"))
                        verification++;
                    if (verification > 14) {

                        for (int i = 0; i < ListPourMelanger.size(); i++) {
                            if ("Eagles".equals(ListPourMelanger.get(i)))
                                ListPourMelanger.remove(i);

                        }

                    }
                }
                verification = 0;
                for (Carte carte : deck) {
                    if (carte.GetName().equals("Wolf"))
                        verification++;
                    if (verification > 14) {

                        for (int i = 0; i < ListPourMelanger.size(); i++) {
                            if ("Wolf".equals(ListPourMelanger.get(i)))
                                ListPourMelanger.remove(i);

                        }

                    }
                }
                verification = 0;
                for (Carte carte : deck) {
                    if (carte.GetName().equals("Bear"))
                        verification++;
                    if (verification > 14) {

                        for (int i = 0; i < ListPourMelanger.size(); i++) {
                            if ("Bear".equals(ListPourMelanger.get(i)))
                                ListPourMelanger.remove(i);

                        }

                    }
                }
                verification = 0;
                for (Carte carte : deck) {
                    if (carte.GetName().equals("Curse"))
                        verification++;
                    if (verification > 14) {

                        for (int i = 0; i < ListPourMelanger.size(); i++) {
                            if ("Curse".equals(ListPourMelanger.get(i)))
                                ListPourMelanger.remove(i);

                        }

                    }
                }
                verification = 0;
                for (Carte carte : deck) {
                    if (carte.GetName().equals("Blessing"))
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

    public int NombreAleatoire(int min , int max ) // Renvoi un nombre aléatoire entre les bornes choisies
    {
        Random rand = new Random();

        int nombreAleatoire= rand.nextInt(max-min+1)+min; //Formule mathematique

        return nombreAleatoire;

    }











}
