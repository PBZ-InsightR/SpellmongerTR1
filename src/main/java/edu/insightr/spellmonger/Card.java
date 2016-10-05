package edu.insightr.spellmonger;

public abstract class Card {
    private String id;

    public Card(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
