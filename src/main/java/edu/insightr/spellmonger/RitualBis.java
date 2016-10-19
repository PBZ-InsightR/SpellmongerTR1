package edu.insightr.spellmonger;

/**
 * Alison.
 */
public enum RitualBis {

        Curse("Curse",1),
        Shield("Shield",0), // return 0 
        Blessing("Blessing",3);

        String name;
        int damage;

    RitualBis(String name,int damage){
        this.name=name;
        this.damage=damage;
    }

    public void getDamage(){
        System.out.println("Damage:" + damage);
    }

    public String toString(){
        return name;
    }

}

