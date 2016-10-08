package edu.insightr.spellmonger;

/*
** Card abstract class id means the "name" of the card
 */

public abstract class Card {
    private String id;

    public Card(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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






}