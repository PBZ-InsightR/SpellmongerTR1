package edu.insightr.spellmonger;

/**
 * Created by Ken on 21/09/2016r
 */
public class Creature {

    private final String name;
    private int damage;


    public Creature(String name)
    {
        int damage=0; //Initialisation
        this.name = name;
        switch(name)
        {
            case "Eagle":
                damage = 1;
                break;
            case "Wolf":
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

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    @Override
    public String toString(){
        return "Creature is a " + name +
                " and deals  " + damage;

    }


}
