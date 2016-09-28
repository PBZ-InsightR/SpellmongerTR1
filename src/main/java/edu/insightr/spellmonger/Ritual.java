package edu.insightr.spellmonger;

/**
 * Created by Ken on 21/09/2016.
 */
public class Ritual {

    private String type;
    private int points;

    public Ritual(String type, int points)
    {
        this.type = type;
        this.points = points;
    }

    public String setType(String ritual){
       type = ritual;
        return type;
    }

    public String getType(){
        return type;
    }

    public int setPoints(int pts){
        points = pts;
        return points;
    }

    public int getPoint(){
        return points;
    }

    public void Attibution(String name)
    {
        name = getType();

        try{
            if (name.equals("Curse"))
            {
                setPoints(-3);
            }
            else if (name.equals("Blessing"))
            {
                setPoints(3);
            }
            else{
                setPoints(0);
            }
        }
        catch(ArithmeticException e)
        {
            System.out.println("Error");
        }

    }

    @Override
    public String toString(){
        if (getPoint() < 3) {
            return "The ritual used is  " + type +
                    " and you've lost " + getPoint() +
                    " damage points";
        }
        else
        {
            return "The ritual used is " + type +
                    " and you've gained  " + getPoint() +
                    " life points";
        }
    }
}
