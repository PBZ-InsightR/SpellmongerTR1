Feature: SpellmongerGame

  Scenario: Initialisation

    Given player "Alice" joins the game
    And player "Bob" joins the game

    Then "Alice" has 20 points and 3 cards in her deck
    And "Bob" has 20 points and 3 cards in her deck