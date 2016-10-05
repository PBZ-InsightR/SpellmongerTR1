package edu.insightr.spellmonger;

public class Creature extends Card
{
    private String name; //Name can't change
    private int damage; //Damage change with switch


    public Creature(String id) 
    { 
        super (id);
        int damage=0; //Initialisation

        switch(id)
        {
            case "Eagle" :
            name = "Eagle";
                damage = 1;
                break;
            case "Wolf" :
            name="Wolf";
                damage = 2;
                break;
            case "Bear" :
            name = "Bear"; 
                damage = 3;
                break;
            default:
                System.out.println("FAIL ! This Creature doesn't exist !");
                break;
        }
        this.damage=damage;

    }


    public String getName(){
        return name;
    }

    public int getDamage(){ //Access for main, use this to alter life point
        return damage;
    }

    @Override
    public String toString(){       //Access for main, use this as an information message
        return "Creature is a " + name +
                " and deals  " + damage;
    }
}
