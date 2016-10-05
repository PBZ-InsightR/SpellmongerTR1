/**
 * SpellmongerApp
 * Game which has 2 players having each 20 lifepoints and try to beat each other
 * at a card game containing 70 cards which may be either a Ritual or a Creature.
 * Each player draws a card after one another. Every card drawn out of the stack
 * are discarded from the game.
 */

package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    private Map<String, Integer>  playersLifePoints = new HashMap<>(2);
    private Map<String, Integer> playersCreature = new HashMap<>(2);
    private List<Card> cardPool = new ArrayList<>(70);


    /**
     * Creates two players and sets them up with 20 life points each.
     * Sets up the randomness of the card drawn during the game.
     *
     * @return          a cardname and associated points
     */
    private SpellmongerApp() {
        /**
         *  @param ritualmod the type of randomness giving turns in types of cards drawn
         * @param cardname the name of the card drawn from the stack
         * @param compteur incrementation until the 70 total cards from the stack are drawn

            */


        playersLifePoints.put("Alice", 20);
        playersLifePoints.put("Bob", 20);
        playersCreature.put("Alice", 0);
        playersCreature.put("Bob", 0);
        int ritualMod = 3;
        String cardname="";
        int compteur=0;

        for (int i = 0; i < 70; i++) {
            if (i % ritualMod == 0) {
                if(i%2==0){
                    cardname="Curse";
                }
                else{
                    cardname="Blessing";
                }
                Ritual ritual= new Ritual(cardname);
                cardPool.add(ritual);
            }
            if (i % ritualMod != 0) {
                if(compteur==0){
                    cardname="Wolf";
                    compteur++;
                }
                else{
                    if(compteur==1){
                        cardname="Bear";
                        compteur++;
                    }
                    else{
                        cardname="Eagle";
                        compteur=0;
                    }
                }
                Creature creature= new Creature(cardname);
                cardPool.add(creature);
            }

            if (ritualMod == 3) {
                ritualMod = 2;
            } else {
                ritualMod = 3;
            }

        }
    }


    /**
     * Starts the Spellmonger game.
     * This continues until one of the players don't have anymore lifepoints
     *
     * @param args  arguments from the main
     */
    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp();

        boolean onePlayerDead = false;
        String currentPlayer = "Alice";
        String opponent = "Bob";
        int currentCardNumber = 0;
        int roundCounter = 1;
        String winner = null;

        while (!onePlayerDead) {
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);

            app.drawACard(currentPlayer, opponent, currentCardNumber);

            logger.info(opponent + " has " + app.playersLifePoints.get(opponent) + " life points and " + currentPlayer + " has " + app.playersLifePoints.get(currentPlayer) + " life points ");

            if (app.playersLifePoints.get(currentPlayer) <= 0) {
                winner = opponent;
                onePlayerDead = true;
            }
            if (app.playersLifePoints.get(opponent) <= 0) {
                winner = currentPlayer;
                onePlayerDead = true;
            }

            if ("Alice".equalsIgnoreCase(currentPlayer)) {
                currentPlayer = "Bob";
                opponent = "Alice";
            } else {
                currentPlayer = "Alice";
                opponent = "Bob";
            }
            currentCardNumber++;
            roundCounter++;
        }

        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + winner + " !!!");
        logger.info("******************************");


    }


    /**
     * Creates a new card from the stack between the 2 players.
     *
     *
     * @param currentPlayer player drawing the first card
     * @param opponent player drawing the second card
     * @param currentCardNumber the current card number being played
     */
    private void drawACard(String currentPlayer, String opponent, int currentCardNumber) {
        Card card =cardPool.get(currentCardNumber);
        if (card instanceof Creature) {
            card=(Creature) card;
            logger.info(currentPlayer + " draw a"+card.getId());
            playersCreature.put(currentPlayer, playersCreature.get(currentPlayer) + 1);
            int nbCreatures = playersCreature.get(currentPlayer);
            if (nbCreatures > 0) {
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent) - nbCreatures));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer + " attack and deal " + nbCreatures + " damages to its opponent");
            }

        }
        if (card instanceof Ritual) {
            card=(Ritual) card;
            logger.info(currentPlayer + " draw a"+ card.getId());
            int nbCreatures = playersCreature.get(currentPlayer);
            if (nbCreatures > 0) {
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent) - nbCreatures - 3));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer + " attack and deal " + nbCreatures + " damages to its opponent");
            }
            logger.info(currentPlayer + " cast a ritual that deals 3 damages to " + opponent);
        }
    }

}