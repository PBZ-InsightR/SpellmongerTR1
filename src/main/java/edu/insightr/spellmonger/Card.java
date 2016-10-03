package edu.insightr.spellmonger;

/*
** Card abstract class
 */

public abstract class Card {
    private final int id;

    public Card(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}