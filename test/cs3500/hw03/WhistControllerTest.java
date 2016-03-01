package cs3500.hw03;

import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.hw04.WhistModelCreator;
import cs3500.hw04.WhistTrumpModel;

import static org.junit.Assert.assertEquals;

/**
 * tests the controller
 */
public class WhistControllerTest {


  // tests a valid case when the user input valid info and output the game state
  // If the game has been won, the method returns.
  @Test
  public void testStartGame() {

      StringBuffer out = new StringBuffer();
    String finalGameState = "Number of players: 4\n" +
            "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 0 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 0 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 0 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 0 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 4 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 4 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 4 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 4 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 5 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 8♥, 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 6 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 7♥, 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 6 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 6♥, 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 6 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: 5♥, A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 6 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: 4♥, K♠, 9♠, 5♠\n" +
            "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: K♠, 9♠, 5♠\n" +
            "Player 2: 3♥, Q♠, 8♠, 4♠\n" +
            "Player 3: 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: K♠, 9♠, 5♠\n" +
            "Player 2: Q♠, 8♠, 4♠\n" +
            "Player 3: 2♥, J♠, 7♠, 3♠\n" +
            "Player 4: A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: K♠, 9♠, 5♠\n" +
            "Player 2: Q♠, 8♠, 4♠\n" +
            "Player 3: J♠, 7♠, 3♠\n" +
            "Player 4: A♠, 10♠, 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: K♠, 9♠, 5♠\n" +
            "Player 2: Q♠, 8♠, 4♠\n" +
            "Player 3: J♠, 7♠, 3♠\n" +
            "Player 4: 10♠, 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: K♠, 9♠, 5♠\n" +
            "Player 2: Q♠, 8♠, 4♠\n" +
            "Player 3: J♠, 7♠, 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 9♠, 5♠\n" +
            "Player 2: Q♠, 8♠, 4♠\n" +
            "Player 3: J♠, 7♠, 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 9♠, 5♠\n" +
            "Player 2: 8♠, 4♠\n" +
            "Player 3: J♠, 7♠, 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 7 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 9♠, 5♠\n" +
            "Player 2: 8♠, 4♠\n" +
            "Player 3: 7♠, 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 8 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1: 5♠\n" +
            "Player 2: 8♠, 4♠\n" +
            "Player 3: 7♠, 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 8 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1: 5♠\n" +
            "Player 2: 4♠\n" +
            "Player 3: 7♠, 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 8 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1: 5♠\n" +
            "Player 2: 4♠\n" +
            "Player 3: 3♠\n" +
            "Player 4: 6♠, 2♠\n" +
            "Player 1: 8 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1: 5♠\n" +
            "Player 2: 4♠\n" +
            "Player 3: 3♠\n" +
            "Player 4: 2♠\n" +
            "Player 1: 9 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 1\n" +
            "Number of players: 4\n" +
            "Player 1:\n" +
            "Player 2: 4♠\n" +
            "Player 3: 3♠\n" +
            "Player 4: 2♠\n" +
            "Player 1: 9 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 2\n" +
            "Number of players: 4\n" +
            "Player 1:\n" +
            "Player 2:\n" +
            "Player 3: 3♠\n" +
            "Player 4: 2♠\n" +
            "Player 1: 9 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 3\n" +
            "Number of players: 4\n" +
            "Player 1:\n" +
            "Player 2:\n" +
            "Player 3:\n" +
            "Player 4: 2♠\n" +
            "Player 1: 9 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Turn: Player 4\n" +
            "Number of players: 4\n" +
            "Player 1:\n" +
            "Player 2:\n" +
            "Player 3:\n" +
            "Player 4:\n" +
            "Player 1: 10 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Game over. Player 1 won.";

      Reader in = new StringReader(
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 " +
              "0 0 0 0 ");
      WhistController controller = new WhistController(in, out);
      controller.startGame(new WhistModel(), 4);
      assertEquals(finalGameState, out.toString());

  }


  /**
   * checks the exception cases
   * the controller is not going throw exceptions, but it prints a try again line to the player
   * and keeps run the game to look for the next valid input
   */


  // when the given input with a wrong suit
  // using a creator to create the model
  @Test
  public void TestStartGame() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 10 1 0 " +
            "0 0 0 0 " +
            "1 0 0 0 " +
            "0 0 0 0 " +
            "0 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "1 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    WhistModelCreator creator = new WhistModelCreator();
    controller.startGame(creator.create(WhistModelCreator.ModelType.NOTRUMP), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: Invalid Suit"));
  }


  // when the given input is not enough, the game is not over yet
  @Test
  public void TestStartGameNotOverGame() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 10 1 0 " +
            "0 0 0 0 " +
            "1 0 0 0 " +
            "0 0 0 0 " +
            "0 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "1 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: Invalid Suit"));
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input:" +
                    " no more input and the game is not over"));
  }

  // when the given input in not an integer
  @Test
  public void TestStartGame2() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("sd");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: input is not an integer"));
  }

  // when the given input is an invalid int
  // the game should not crash,
  // or propagate the IllegalArgumentException throw by the model
  @Test
  public void TestStartGame3() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("kdjchiojdskc ");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: input is not an integer"));
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame4() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("sd");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 0);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame5() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 ");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), -1);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame6() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 ");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 1);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame7() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("10 0 0 0 " +
            "0 100 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 0);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests when a given card does not exist
  // the model should throw an "card does not exist" exception
  // the controller should print it out,
  // and find the next valid card index and continue with the game
  @Test
  public void TestStartGame8() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 0 0 0 " +
            "0 100 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistModel(), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: Card does not Exist"));
  }


/**
 * test the controller for the trump model
 */

// tests the controller for the trump model
// 6 players and during the game there are some given invalid suit cards
// using a creator to create the trump model
@Test
public void TestStartGame_Trump() {
  StringBuffer out = new StringBuffer();
  Reader in = new StringReader("0 1 1 0 " +
          "0 0 0 0 " +
          "1 0 0 0 " +
          "0 0 0 0 " +
          "0 0 1 0 " +
          "0 0 0 0 " +
          "0 1 0 0 " +
          "0 0 0 0 " +
          "0 0 0 0 " +
          "1 0 1 0 " +
          "0 0 0 0 " +
          "0 1 1 1 " +
          "1 1 1 1 1 0 0 0 0 0 0 0");
  WhistController controller = new WhistController(in, out);
  WhistModelCreator creator = new WhistModelCreator();
  controller.startGame(creator.create(WhistModelCreator.ModelType.TRUMP), 6);
  assertEquals("Number of players: 6\n" +
          "Player 1: A♣, 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, 7♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, 6♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: J♣, 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 10♣, 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, 7♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, 6♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: J♣, 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 10♣, 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, 6♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: J♣, 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 10♣, 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: J♣, 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 10♣, 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 10♣, 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 5♣, Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 4♣, J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 3♣, 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Number of players: 6\n" +
          "Player 1: 8♣, 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: K♣, A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: Q♣, K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: A♦, 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 1 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: K♦, 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 1 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: Q♦, 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 1 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: J♦, 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 1 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 10♦, 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 1 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 9♦, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 1 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 8♦, 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 7♦, A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 6♦, K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 5♦, Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: 4♦, J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 3♦, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 2♦, 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: A♥, 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: K♥, 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: Q♥, 6♥, K♠, 7♠\n" +
          "Player 6: J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 6♥, K♠, 7♠\n" +
          "Player 6: J♥, 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 2♣, 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 6♥, K♠, 7♠\n" +
          "Player 6: 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 8♥, 2♥, 9♠, 3♠\n" +
          "Player 4: 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 6♥, K♠, 7♠\n" +
          "Player 6: 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: 7♥, A♠, 8♠, 2♠\n" +
          "Player 5: 6♥, K♠, 7♠\n" +
          "Player 6: 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: 6♥, K♠, 7♠\n" +
          "Player 6: 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: 5♥, Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, 4♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 9♥, 3♥, 10♠, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 3 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 3♥, 10♠, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 9♠, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Try again, that was invalid input: Invalid Suit\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 8♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠, 7♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠, 6♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, J♠, 5♠\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥, 5♠\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥, 4♠\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥, 3♠\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥\n" +
          "Player 4: A♠, 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥\n" +
          "Player 4: 2♠\n" +
          "Player 5: K♠\n" +
          "Player 6: Q♠\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 5\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥\n" +
          "Player 4: 2♠\n" +
          "Player 5:\n" +
          "Player 6: Q♠\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 1 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 6\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥\n" +
          "Player 4: 2♠\n" +
          "Player 5:\n" +
          "Player 6:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 2 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 4\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1: 10♥\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥\n" +
          "Player 4:\n" +
          "Player 5:\n" +
          "Player 6:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 2 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1:\n" +
          "Player 2: 3♥\n" +
          "Player 3: 2♥\n" +
          "Player 4:\n" +
          "Player 5:\n" +
          "Player 6:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 2 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 2\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1:\n" +
          "Player 2:\n" +
          "Player 3: 2♥\n" +
          "Player 4:\n" +
          "Player 5:\n" +
          "Player 6:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 2 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Turn: Player 3\n" +
          "Trump suit: ♣\n" +
          "Number of players: 6\n" +
          "Player 1:\n" +
          "Player 2:\n" +
          "Player 3:\n" +
          "Player 4:\n" +
          "Player 5:\n" +
          "Player 6:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 4 hands won\n" +
          "Player 3: 1 hands won\n" +
          "Player 4: 2 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Game over. Player 2 won.", out.toString());
}
  /**
   * checks the exception cases for the trump model
   * the controller is not going throw exceptions, but it prints a try again line to the player
   * and keeps run the game to look for the next valid input
   */

  // when the given input with a wrong suit
  @Test
  public void TestStartGame_Trump2() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 10 1 0 " +
            "0 0 0 0 " +
            "1 0 0 0 " +
            "0 0 0 0 " +
            "0 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "1 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistTrumpModel(), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: Invalid Suit"));
  }


  // when the given input is not enough, the game is not over yet
  @Test
  public void TestStartGameNotOverGame_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 10 1 0 " +
            "0 0 0 0 " +
            "1 0 0 0 " +
            "0 0 0 0 " +
            "0 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "1 0 1 0 " +
            "0 0 0 0 " +
            "0 1 0 0 " +
            "0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistTrumpModel(), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: Invalid Suit"));
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input:" +
                    " no more input and the game is not over"));
  }

  // when the given input in not an integer
  @Test
  public void TestStartGame2_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("sd");
    WhistController controller = new WhistController(in, out);
    WhistModelCreator creator = new WhistModelCreator();
    controller.startGame(creator.create(WhistModelCreator.ModelType.TRUMP), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: input is not an integer"));
  }

  // when the given input is an invalid int
  // the game should not crash,
  // or propagate the IllegalArgumentException throw by the model
  @Test
  public void TestStartGame3_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("kdjchiojdskc ");
    WhistController controller = new WhistController(in, out);
    WhistModelCreator creator = new WhistModelCreator();
    controller.startGame(creator.create(WhistModelCreator.ModelType.TRUMP), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: input is not an integer"));
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame4_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("sd");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistTrumpModel(), 0);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame5_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 ");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistTrumpModel(), -1);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame6_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 ");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistTrumpModel(), 1);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests the controller when its given an invalid number of players
  @Test
  public void TestStartGame7_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("10 0 0 0 " +
            "0 100 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    controller.startGame(new WhistTrumpModel(), 0);
    assertEquals("Try again, that was invalid input: not enough player", out.toString());
  }

  // tests when a given card does not exist
  // the model should throw an "card does not exist" exception
  // the controller should print it out as a string,
  // and find the next valid card index and continue with the game
  @Test
  public void TestStartGame8_Trump() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 0 0 0 " +
            "0 100 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 0");
    WhistController controller = new WhistController(in, out);
    WhistModelCreator creator = new WhistModelCreator();
    controller.startGame(creator.create(WhistModelCreator.ModelType.TRUMP), 2);
    assertEquals(true,
            out.toString().contains("Try again, that was invalid input: Card does not Exist"));
  }



}