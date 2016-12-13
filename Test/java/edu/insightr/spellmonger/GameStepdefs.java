package edu.insightr.spellmonger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.insightr.spellmonger.model.Card;
import edu.insightr.spellmonger.model.Creature;
import edu.insightr.spellmonger.model.Player;
import edu.insightr.spellmonger.model.SpellmongerApp;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Test in a simple scenario(initialisation) with cucumber
 */
public class GameStepdefs {
    @Then("^\"([^\"]*)\" has (\\d+) points and (\\d+) cards in her deck$")
    public void hasPointsAndCardsInHerDeck(String arg0, int arg1, int arg2) throws Throwable {
        // arg(0) means the player
        // arg(1) means the point number
        // arg(2) means the number of card in their deck
        List<Card> hand = new ArrayList<>(arg2);
        Player player = app.getPlayer1();
        if ("Alice".equals(player.getName())) {
            assertThat(player.getName(), is(equalTo(arg0)));
            assertThat(player.getPv(), is(equalTo(arg1)));
        
        throw new PendingException();
    }
}
