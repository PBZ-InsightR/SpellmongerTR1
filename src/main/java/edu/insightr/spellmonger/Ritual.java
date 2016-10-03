package edu.insightr.spellmonger;

/**
 * Ritual
 */
public class Ritual {

    private final String type;
    private final int value;

    public Ritual(String type){
        this.type=type;

        switch(type) {
            case "Curse":
                value = -3;
                break;
            case "Blessing":
                value = 3;
                break;
            default:
                System.out.println("This is not a ritual.");
                value = 0;
                break;
        }
    }

    public String getType(){
        return this.type;
    }
    public int getValue(){
        return this.value;
    }
}
