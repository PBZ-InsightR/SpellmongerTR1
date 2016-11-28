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
}