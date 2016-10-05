package edu.insightr.spellmonger;

public class Creature extends Card
{
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
