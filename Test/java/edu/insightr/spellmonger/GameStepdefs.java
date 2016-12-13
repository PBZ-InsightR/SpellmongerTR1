package edu.insightr.spellmonger;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert.*;


/**
 * Test in a simple scenario(initialisation) with cucumber
 */
public class GameStepdefs {
    @Then("^\"([^\"]*)\" has (\\d+) points and (\\d+) cards in her deck$")
    public void hasPointsAndCardsInHerDeck(String arg0, int arg1, int arg2) throws Throwable {
        // arg(0) means the player
        // arg(1) means the point number
        // arg(2) means the number of card in their deck

        
        throw new PendingException();
    }
}
