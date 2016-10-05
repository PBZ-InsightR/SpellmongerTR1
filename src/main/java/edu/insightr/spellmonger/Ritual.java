package edu.insightr.spellmonger;

/**
 * Constructor for Ritual card which can be either a Curse or a Blessing.
 * Ritual inherits its id from the superclass Card.
 * Depending on the id the curse will be choosen in the main class.
 */
public class Ritual extends Card{

    /**
     * @param id an absolute string id giving the name relative to the card
     */

    private final int value;

    public Ritual(String id){
        super(id);

        switch(id) {
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

    public int getValue(){
        return this.value;
    }
}
