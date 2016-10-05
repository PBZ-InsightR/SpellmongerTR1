//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.insightr.spellmonger;

import edu.insightr.spellmonger.Card;
import edu.insightr.spellmonger.Creature;
import edu.insightr.spellmonger.Ritual;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> l_carte = new ArrayList(70);

    public Deck() {
        this.mix();
    }

    public void mix() {
        ArrayList ListPourMelanger = new ArrayList();
        int compteur = 1;
        ListPourMelanger.add("Eagle");
        ListPourMelanger.add("Wolf");
        ListPourMelanger.add("Bear");
        ListPourMelanger.add("Curse");
        ListPourMelanger.add("Blessing");
        HashMap hashmap = new HashMap();
        Iterator carte_nom = ListPourMelanger.iterator();

        while(carte_nom.hasNext()) {
            String max_size = (String)carte_nom.next();
            hashmap.put(max_size, Integer.valueOf(0));
        }

        do {
            String var6 = (String)ListPourMelanger.get(this.NombreAleatoire(0, ListPourMelanger.size() - 1));
            if(EstUneCreature(var6)) {
                Creature var7 = new Creature(var6);
                this.l_carte.add(var7);
            } else {
                Ritual var8 = new Ritual(var6);
                this.l_carte.add(var8);
            }

            ++compteur;
            byte var9 = 14;
            hashmap.put(var6, Integer.valueOf(((Integer)hashmap.get(var6)).intValue() + 1));
            if(((Integer)hashmap.get(var6)).intValue() == var9) {
                ListPourMelanger.remove(var6);
            }
        } while(compteur < 70);

    }

    public static boolean EstUneCreature(String s) {
        boolean res = false;
        if(s == "Eagle" || s == "Wolf" || s == "Bear") {
            res = true;
        }

        return res;
    }

    public int NombreAleatoire(int min, int max) {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min + 1) + min;
        return nombreAleatoire;
    }

    public Card DrawCard() {
        Card carte_pioche = null;
        if(this.l_carte.size() != 0) {
            carte_pioche = (Card)this.l_carte.get(0);
            this.l_carte.remove(0);
        }

        return carte_pioche;
    }

    public Card DiscardCard(Card cartepioche) {
        return this.DrawCard();
    }
}
