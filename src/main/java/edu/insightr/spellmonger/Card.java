package edu.insightr.spellmonger;

/*
** Card abstract class id means the "name" of the card
 */

import java.util.Objects;

abstract class Card {
    private String id;

    Card(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }

    static boolean EstUneCreature(String s)
    {
        boolean res = false;
        if(Objects.equals(s, "Eagle") || Objects.equals(s, "Wolf") || Objects.equals(s, "Bear"))
        {
            res = true;
        }

        return res;
    }








}