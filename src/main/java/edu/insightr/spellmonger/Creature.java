package edu.insightr.spellmonger;

/**
 * Created by Ken on 21/09/2016r
 */
public class Creature extends Carte {

    private final String name;
    private int damage;


    public Creature(String name, int damage)
    {
        this.name = name;
        this.damage = damage;

    }

    public String getName(){
        return name;
    }

    public int setDamage(int points){
        damage = points;
        return damage;
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
