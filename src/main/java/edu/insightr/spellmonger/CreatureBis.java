package edu.insightr.spellmonger;

/**
 * Méthode enum : main ==> CreatureBis c= CreatureBis.Eagle;
 */
public enum CreatureBis {

    Eagle("Eagle",1),
    Wolf("Wolf",2),
    Bear("Bear",3);

    String name;
    int damage;

    CreatureBis(String name,int damage){
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
