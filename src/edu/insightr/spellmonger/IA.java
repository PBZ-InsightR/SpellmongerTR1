package edu.insightr.spellmonger;
import java.util.*;

public class IA
{

    Card Curse = new Ritual("Curse");
    Card Shield = new Ritual("Shield");
    Card Blessing = new Ritual("Blessing");

    Card Wolf = new Creature("Wolf");
    Card Bear = new Creature("Bear");
    Card Eagle = new Creature("Eagle");

    Card ChooseBestCard(List<Card> liste_de_carte)
    {
        if(liste_de_carte.isEmpty())
        {
            System.out.println("Plus de cartes ! ");
        }
        else if(liste_de_carte.contains(Curse))
        {
            return Curse;
        }
        else if(liste_de_carte.contains(Bear))
        {
            return Bear;
        }
        else if(liste_de_carte.contains(Wolf))
        {
            return Wolf;
        }
        else if(liste_de_carte.contains(Eagle))
        {
            return Eagle;
        }
        else if(liste_de_carte.contains(Shield))
        {
            return Shield;
        }
        else if(liste_de_carte.contains(Blessing))
        {
            return Blessing;
        }

        Creature end = new Creature("XXX"); // <--- Horrible chose que je viens de faire
        return end;

    }


}
