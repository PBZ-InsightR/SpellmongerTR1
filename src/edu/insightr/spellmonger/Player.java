package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private List<Card> deckDuJoueur;
    private int points_de_vie;

    Player(String name, int points_de_vie, List<Card> deckDuJoueur) {
        this.points_de_vie = points_de_vie;
        this.name = name;
        this.deckDuJoueur=deckDuJoueur;
    }

    void damage(int degats) {
        points_de_vie -= degats;
    }

    boolean estMort() { return points_de_vie <= 0; }
    boolean estEnVie() { return points_de_vie > 0; }

    void creaVsCrea(Card card1, Card card2) {
        int damageCreatureCard1 = ((Creature) card1).getDamage();
        int damageCreatureCard2 = ((Creature) card2).getDamage();

        if(damageCreatureCard1>damageCreatureCard2) {
            damage(damageCreatureCard1-damageCreatureCard2);
        }
    }

    void rituVsRitu(Card card1, Card card2) {
        boolean shield_J1 = ((Ritual) card1).getShield();
        boolean shield_J2 = ((Ritual) card2).getShield();

        int damage_rituel_J1 = ((Ritual) card1).getValue();
        int damage_rituel_J2 = ((Ritual) card2).getValue();

        if(shield_J2 && damage_rituel_J1>0) {	//Si shield J2 on annule les degat du J1
            damage_rituel_J1=0;
        }
        if(shield_J1 && damage_rituel_J2>0) {	//Si shield J1 on annule les degat du J2
            damage_rituel_J2=0;
        }
        if(damage_rituel_J1<0) {				//Si soin J1
            damage(damage_rituel_J1);
        }
        if(damage_rituel_J2>=0) {				//Si curse J2
            damage(damage_rituel_J2);
        }
    }

    void CreaVsRituJ1(Card card1, Card card2) {
        boolean shield_J1 = ((Ritual) card1).getShield();
        int damage_rituel_J1 = ((Ritual) card1).getValue();
        int damage_creature_J2 = ((Creature) card2).getDamage();

        if (!shield_J1) {
            damage(damage_creature_J2);
            if (damage_rituel_J1 < 0) {
                damage(damage_rituel_J1);
            }
        }
    }

    void CreaVsRituJ2(Card card1, Card card2) {
        int damage_rituel_J1 = ((Ritual) card1).getValue();
        if(damage_rituel_J1>0) {
            damage(damage_rituel_J1);
        }
    }

    int getPv() {
        return points_de_vie;
    }
    String getName() {
        return name;
    }
    List<Card> getDeckDuJoueur()
    {
        return deckDuJoueur;
    }

    void SetDeckDuJoueur(List<Card> deck){deckDuJoueur=deck;}

}
