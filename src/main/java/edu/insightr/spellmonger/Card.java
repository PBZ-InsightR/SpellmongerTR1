package edu.insightr.spellmonger;

/**
 * Abstract class
 * Constructor Card which has a string id to determine the type of card.
 *

 */

public abstract class Card {
 /**
  * @param id an absolute string id giving the name relative to the card
*/

    protected final String id;

    public Card(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}