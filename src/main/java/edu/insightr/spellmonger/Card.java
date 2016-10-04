package edu.insightr.spellmonger;

/*
** Card abstract class id means the "name" of the card
 */

public abstract class Card {
    private final String id;

    public Card(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}