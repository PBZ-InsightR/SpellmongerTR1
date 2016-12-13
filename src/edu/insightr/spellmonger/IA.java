package edu.insightr.spellmonger;
import java.util.*;

public class IA
{
    private Player player;
    private Player ennemy;
 //   private final int maxPv;
    private List<Card> liste_de_carte;

    public IA(Player player, Player ennemy, List<Card> main) {
        this.player = player;
        this.ennemy = ennemy;
 //       this.maxPv = player.getPv();
        this.liste_de_carte=main;
    }

    // To improve the AI we created 2 different stances to adapt the AI behaviour in function of the actual situation
    // These stances differ by the priority of each kind of cards
    // If the rules of the game asked to draw a new card on each turn instead of waiting the "main" (liste_de_carte) to be empty, the AI would be even more efficient

    // Creation of the aggressive stance of the AI
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

    // Creation of the defensive stance of the AI
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
        // if statement that tell if all cards were played
        if (liste_de_carte.isEmpty()) {
            System.out.println("Plus de cartes ! ");
        }

        // if statement to chose which stance to adopt
        if (player.getPv() >= ennemy.getPv()) { // If player has as much as or more Health Point than ennemy, adopt aggressive stance
            Card card = attack_cards();

            if (card == null)
                card = defense_cards();

            if (card != null)
                return card;
        }
        else if (player.getPv() < ennemy.getPv()) { // If player has less Health Point than ennemy, adopt defensive stance
            Card card = defense_cards();

            if (card == null)
                card = attack_cards();

            if (card != null)
                return card;
        }

        System.out.println("ERREUR !!");
        return new Creature("XXX");

    }


}
