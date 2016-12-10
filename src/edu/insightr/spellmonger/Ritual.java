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
        final String CurseCard = "Curse";
        final String ShieldCard = "Shield";
        final String BlessingCard = "Blessing";

        switch(id) {
            case CurseCard:
                this.value = 3;
                break;

            case ShieldCard:
                this.shield=true;
                this.value=0;
                break;

            case BlessingCard:
                this.value = -3;
                break;

            default:
                System.out.println("This is not a ritual.");
                this.value = 0;
        }

    }

    @Override
    public String toString(){       //Access for main, use this as an information message
        return "Rituel is a " + getId();
    }

    int getValue() {
        return this.value;
    }
    boolean getShield(){return this.shield;}
}