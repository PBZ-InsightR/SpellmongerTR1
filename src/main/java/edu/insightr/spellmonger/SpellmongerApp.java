// Mon test de Push

package edu.insightr.spellmonger;


        public class SpellmongerApp {

    public static void main(String[] args) {


       int bob =20; //Points de vie Alice et bob
       int alice=20;


        int bob_damage =0; //Dommage de alice et bob en fct de leur creature
        int alice_damage=0;

        Deck deck =new Deck();
        deck.mix();
        Card carte;
        Creature crea=new Creature("0"); //Creature d'initialisation
        Ritual ritu = new Ritual("0"); //Rituel d'initialisation
        String id=""; //Id d'initialisation
        int count=0; //Variable de test pour une creature/Curse/Blessing
        int turn=0; //Nombres de tour

        while (alice>=0 && bob >=0) {

            carte = deck.DrawCard(); //On tire une carte
            id=carte.getId(); //On regarde son ID et en fonction de son id on va allez dans les différents test par la variable count

            if(id.equals("Wolf") || id.equals("Eagle") || id.equals("Bear"))
            {
                crea= new Creature(id);
                count=1;
            }

            if(id.equals("Curse"))
            {
                ritu= new Ritual(id);
                count=2;
            }
            if(id.equals("Blessing"))
            {
                ritu= new Ritual(id);
                count=3;
            }

            if(turn%2==0) { //Alice TURN (tour pair)

                if (count == 1) { //Si creature, on augmente les dommages
                    alice_damage += crea.getDamage();
                }
                if (count == 2) { //Si rituel curse on fait -3 sur bob
                    bob -= ritu.getValue();
                }
                if (count == 3) { //Si rituel blessing on fait +3 sur alice
                    alice -= ritu.getValue();
                }
                bob-=alice_damage; //On enleve la somme des dommages de bob dans les pdv d'alice
            }
            else { //Bob TURN (tour impair)

                if (count == 1) { //Si creature, on augmente les dommages de bob
                    bob_damage += crea.getDamage();
                }
                if (count == 2) {  //Si rituel curse on fait -3 sur alice
                    alice -= ritu.getValue();
                }
                if (count == 3) { //Si rituel blessing on fait +3 sur bob
                    bob -= ritu.getValue();
                }
                alice-=bob_damage; //On enleve la somme des dommages d'alice dans les pdv de bob
            }

            turn++;
            System.out.println("Fin du tour :"+turn);
            System.out.println("Les dommages de Alice par tour sont de "+alice_damage);
            System.out.println("Les dommages de Bob par tour sont de "+bob_damage);
            System.out.println("Point de vie de Alice : "+alice);
            System.out.println("Point de vie de Bob : "+bob);

        }


    }




}