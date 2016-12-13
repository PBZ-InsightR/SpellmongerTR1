package edu.insightr.spellmonger;

import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Test in a simple scenario(initialisation) with cucumber
 */
public class GameStepdefs {
    @Then("Alice has (\\d+) points and (\\d+) cards in her deck$")
    public void hasPointsAndCardsInHerDeck(String arg0, int arg1, int arg2) throws Throwable {
        // arg(0) means the player
        // arg(1) means the point number
        // arg(2) means the number of card in their deck

        Player player = new Player("Alice");
        if ("Alice".equals(player.getName())) {
            assertThat(player.getName(), is(equalTo(arg0)));
            assertThat(player.getPv(), is(equalTo(arg1)));
            assertThat(player.getDeckDuJoueur(), is(equalTo(arg2)));

            //throw new PendingException();
        }
    }

    @Then("Bob has (\\d+) points and (\\d+) cards in her deck$")
    public void hasPointsAndCardsInHerDeck(String arg0, int arg1, int arg2) throws Throwable {
        // arg(0) means the player
        // arg(1) means the point number
        // arg(2) means the number of card in their deck
        Player player = new Player("Bob");
        if ("Bob".equals(player.getName())) {
            assertThat(player.getName(), is(equalTo(arg0)));
            assertThat(player.getPv(), is(equalTo(arg1)));
            assertThat(player.getDeckDuJoueur(), is(equalTo(arg2)));
        }
    }
}