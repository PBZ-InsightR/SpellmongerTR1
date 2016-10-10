//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.insightr.spellmonger;


public class Ritual extends Card {
    private final int value;

    public Ritual(String id) {
        super(id);

        switch(id) {
            case "Curse":
                this.value = 3;
                break;
            case "Blessing":
                this.value = -3;
                break;
            default:
                System.out.println("This is not a ritual.");
                this.value = 0;
        }

    }

    int getValue() {
        return this.value;
    }
}