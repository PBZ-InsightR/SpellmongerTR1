package edu.insightr.spellmonger;
import java.util.*;

public class IA
{
    private Player player;
    private Player ennemy;
 //   private final int maxPv;
    private List<Card> liste_de_carte;

    public IA(Player player, Player ennemy) {
        this.player = player;
        this.ennemy = ennemy;
 //       this.maxPv = player.getPv();
        this.liste_de_carte=player.GetMainDuJoueur();
    }

    Card attack_cards() {
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Bear")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Curse")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Wolf")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Eagle")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i = 0; i < liste_de_carte.size(); i++) {
            if (liste_de_carte.get(i).getId().equals("Shield")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i = 0; i < liste_de_carte.size(); i++) {
            if (liste_de_carte.get(i).getId().equals("Blessing")) {
                return liste_de_carte.get(i);
            }
        }

        return null;
    }

    Card defense_cards() {
        for (int i = 0; i < liste_de_carte.size(); i++) {
            if (liste_de_carte.get(i).getId().equals("Blessing")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i = 0; i < liste_de_carte.size(); i++) {
            if (liste_de_carte.get(i).getId().equals("Shield")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Bear")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Wolf")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Eagle")) {
                return liste_de_carte.get(i);
            }
        }
        for (int i=0; i<liste_de_carte.size() ; i++) {
            if (liste_de_carte.get(i).getId().equals("Curse")) {
                return liste_de_carte.get(i);
            }
        }

        return null;
    }

    Card ChooseBestCard() {
        if (liste_de_carte.isEmpty()) {
            System.out.println("Plus de cartes ! ");
        }


        if (player.getPv() >= ennemy.getPv()) {
            Card card = attack_cards();
            if (card == null)
                card = defense_cards();
            if (card != null)
                return card;
        }
        else if (player.getPv() < ennemy.getPv()) {
            Card card = defense_cards();
            if (card == null)
                card = attack_cards();

            if (card != null)
                return card;
        }

        System.out.println("ERREUR !!");
        return new Creature("XXX"); //HORREUR ULTIMEEEE

    }


}
