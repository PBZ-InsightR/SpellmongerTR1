package edu.insightr.spellmonger;

/**
 * Constructor for Creature card which can be either an Eagle, a wolf or a Bear.
 * Creature inherits its id from the superclass Card.
 * Depending on the id the curse will be choosen in the main class.
 *
**/

public class Creature extends Card
{
    /**
     * @param id an absolute string id giving the name relative to the card
     */
    private int damage; //Damage change with switch


    public Creature(String id) 
    { 
        super (id);
        int damage=0; //Initialisation

        switch(id)
        {
            case "Eagle" :

                damage = 1;
                break;
            case "Wolf" :

                damage = 2;
                break;
            case "Bear":
                damage = 3;
                break;
            default:
                System.out.println("FAIL ! This Creature doesn't exist !");
                break;
        }
        this.damage=damage;

    }

    public int getDamage(){ //Access for main, use this to alter life point
        return damage;
    }

    @Override
    public String toString(){       //Access for main, use this as an information message
        return "Creature is a " + id +
                " and deals  " + damage;
    }
}
