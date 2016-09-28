public class Creature
{
    private final String name; //Name can't change
    private int damage; //Damage change with switch


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

    public int getDamage(){ //Access for main, use this to alter life point
        return damage;
    }

    @Override
    public String toString(){       //Access for main, use this as an information message
        return "Creature is a " + name +
                " and deals  " + damage;
    }
}
