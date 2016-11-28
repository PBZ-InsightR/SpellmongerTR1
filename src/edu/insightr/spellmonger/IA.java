package edu.insightr.spellmonger;
import java.util.*;

public class IA
{
    private List<Card> liste_de_carte;

    public IA(List<Card> liste_de_carte)
    {
        this.liste_de_carte=liste_de_carte;
    }

    Card ChooseBestCard()
    {
        if(liste_de_carte.isEmpty())
        {
            System.out.println("Plus de cartes ! ");
        }
        int taille = liste_de_carte.size();

        for (int i=0; i<taille ; i++) {
            if (liste_de_carte.get(i).getId().equals("Curse")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<taille ; i++) {
            if (liste_de_carte.get(i).getId().equals("Bear")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<taille ; i++) {
            if (liste_de_carte.get(i).getId().equals("Wolf")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<taille ; i++) {
            if (liste_de_carte.get(i).getId().equals("Eagle")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<taille ; i++) {
            if (liste_de_carte.get(i).getId().equals("Shield")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<taille ; i++) {
            if (liste_de_carte.get(i).getId().equals("Blessing")) {
                return liste_de_carte.get(i);
            }
        }


        System.out.println("ERREUR !!");
        return new Creature("XXX"); //HORREUR ULTIMEEEE

    }


}
