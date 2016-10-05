// Mon test de Push

package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    private Map<String, Integer>  playersLifePoints = new HashMap<>(2);
    private Map<String, Integer> playersCreature = new HashMap<>(2);
    private List<String> cardPool = new ArrayList<>(70);

    private SpellmongerApp() {
        playersLifePoints.put("Alice", 20);
        playersLifePoints.put("Bob", 20);
        playersCreature.put("Alice", 0);
        playersCreature.put("Bob", 0);
        int ritualMod = 3;

        for (int i = 0; i < 70; i++) { //Creation du paquet de 70 cartes au hasard, ajouter les differents types de ritual
            if (i % ritualMod == 0) {
                cardPool.add("Ritual");
            }
            if (i % ritualMod != 0) {
                cardPool.add("Creature");
            }

            if (ritualMod == 3) {
                ritualMod = 2;
            } else {
                ritualMod = 3;
            }

        }
    }
    /*public static List<Creature> GenerationAleatoirePaquet(int nbCarte)
    {
        List<String> cardPool = new ArrayList<>(nbCarte);
        int n=0;
        while(n<nbCarte) {
            int nbAleatoire = (int)(Math.random()*4+1);
            switch (nbAleatoire) {
                case 1:
                    cardPool.add();
                case 2:

                case 3:

                case 4:
                case 5:

            }
            n++;
        }

    }
    */
    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp();

       int bob =20;
       int alice=20;


        int bob_damage =0;
        int alice_damage=0;

        Deck deck =new Deck();
        deck.mix();
        Card carte;
        Creature crea=new Creature("0");
        Ritual ritu = new Ritual("0");;
        String id="";
        int count=0;
        int turn=0;
        while (alice>=0 && bob >=0) {

            carte = deck.DrawCard();
            id=carte.getId();
            if(id.equals("Wolf") || id.equals("Eagle") || id.equals("Bear"))
            {
            crea= new Creature(id);
            count=1;
            }

            if(id.equals("Curse") || id.equals("Blessing"))
            {
            ritu= new Ritual(id);
            count=2;
            }

            if(turn%2==0) { //Alice TURN

                if (count == 1) {
                    alice_damage += crea.getDamage();
                }
                if (count == 2) {
                    bob -= ritu.getValue();
                }
                bob-=alice_damage;
            }
            else { //Bob TURN

                if (count == 1) {
                    bob_damage += crea.getDamage();
                }
                if (count == 2) {
                    alice -= ritu.getValue();
                }
                alice-=bob_damage;
            }

            turn++;

            System.out.println("alice damage= "+alice_damage);
            System.out.println("bob_damage= "+bob_damage);
            System.out.println("alice pdv= "+alice);
            System.out.println("bob pdv= "+bob);

        }
        System.out.println("alice pdv= "+alice);
        System.out.println("bob pdv= "+bob);

    }




}