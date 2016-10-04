package edu.insightr.spellmonger;

/**
 * Ritual is either a curse or a blessing.
 */
public class Ritual extends Card{

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
