//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.insightr.spellmonger;


public class Ritual extends Card {
    private int value;
    private boolean shield=false;


    public Ritual(String id) {
        super(id);

        switch(id) {
            case "Curse":
                this.value = 3;
                break;

            case "Shield":
                this.shield=true;
                this.value=0;
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
    boolean getShield(){return this.shield;}
}