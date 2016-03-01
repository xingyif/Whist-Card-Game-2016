package cs3500.hw03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.hw02.CardValue;
import cs3500.hw02.StandardDeckCard;
import cs3500.hw02.Suit;

import static org.junit.Assert.assertEquals;


/**
 * test the methods
 */
public class TestWhistModel {


  StandardDeckCard Aclub = new StandardDeckCard(CardValue.Ace, Suit.Club);
  StandardDeckCard Kclub = new StandardDeckCard(CardValue.King, Suit.Club);
  StandardDeckCard Qclub = new StandardDeckCard(CardValue.Queen, Suit.Club);
  StandardDeckCard Jclub = new StandardDeckCard(CardValue.Jack, Suit.Club);
  StandardDeckCard Tclub = new StandardDeckCard(CardValue.Ten, Suit.Club);
  StandardDeckCard Twoclub = new StandardDeckCard(CardValue.Two, Suit.Club);
  StandardDeckCard Thclub = new StandardDeckCard(CardValue.Three, Suit.Club);
  StandardDeckCard Fclub = new StandardDeckCard(CardValue.Four, Suit.Club);

  StandardDeckCard KDiamond = new StandardDeckCard(CardValue.King,
          Suit.Diamond);
  StandardDeckCard QDiamond = new StandardDeckCard(CardValue.Queen,
          Suit.Diamond);
  StandardDeckCard TwoDiamond = new StandardDeckCard(CardValue.Two,
          Suit.Diamond);
  StandardDeckCard ThDiamond = new StandardDeckCard(CardValue.Three,
          Suit.Diamond);

  StandardDeckCard AHeart = new StandardDeckCard(CardValue.Ace, Suit.Heart);
  StandardDeckCard KHeart = new StandardDeckCard(CardValue.King, Suit.Heart);
  StandardDeckCard QHeart = new StandardDeckCard(CardValue.Queen, Suit.Heart);
  StandardDeckCard ThHeart = new StandardDeckCard(CardValue.Three, Suit.Heart);


  List<StandardDeckCard> PlayerCards1 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards2 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards3 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards4 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards52 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards53 = new ArrayList<>();

  List<StandardDeckCard> currentHand1 = new ArrayList<>();

  List<WhistPlayer> listOfPlayer1 = new ArrayList<WhistPlayer>();
  List<WhistPlayer> listOfPlayer2 = new ArrayList<WhistPlayer>();
  List<WhistPlayer> listOfPlayer3 = new ArrayList<WhistPlayer>();
  WhistPlayer player1;
  WhistPlayer player2;
  WhistPlayer player3;
  WhistPlayer player4;
  WhistModel whistModel1;
  WhistModel whistModel2;
  WhistModel whistModel3;
  WhistModel whistModelEndGame;

  // setup the initial conditions for a WhistModel with 4 players
  // each player has three cards
  // first player should win the hand
  public void initConditionRandom() {

    // initialize the list of cards each player has
    this.PlayerCards1.add(this.Aclub);
    this.PlayerCards1.add(this.KDiamond);
    this.PlayerCards1.add(this.AHeart);

    this.PlayerCards2.add(this.Kclub);
    this.PlayerCards2.add(this.QDiamond);
    this.PlayerCards2.add(this.KHeart);

    this.PlayerCards3.add(this.Qclub);
    this.PlayerCards3.add(this.ThDiamond);
    this.PlayerCards3.add(this.QHeart);

    this.PlayerCards4.add(this.Jclub);
    this.PlayerCards4.add(this.TwoDiamond);
    this.PlayerCards4.add(this.ThHeart);

    // initialize the players
    this.player1 = new WhistPlayer(this.PlayerCards1, 1);
    this.player2 = new WhistPlayer(this.PlayerCards2, 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(this.PlayerCards4, 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    // initialize the current hand
    this.currentHand1.add(Tclub);
    this.currentHand1.add(Thclub);
    this.currentHand1.add(Twoclub);



    // initialize the whist model
    this.whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);
    this.whistModel2 = new WhistModel(this.listOfPlayer1, 2,
            this.currentHand1, GameStatus.Playing);
    this.whistModel3 = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Playing);

  }


  // setup the initial conditions for a WhistModel with 4 players
  // each player has three cards
  // last player should win the hand
  public void initConditionRandom2() {

    // initialize the list of cards each player has
    this.PlayerCards1.add(this.Aclub);
    this.PlayerCards1.add(this.KDiamond);
    this.PlayerCards1.add(this.AHeart);

    this.PlayerCards2.add(this.Kclub);
    this.PlayerCards2.add(this.QDiamond);
    this.PlayerCards2.add(this.KHeart);

    this.PlayerCards3.add(this.Qclub);
    this.PlayerCards3.add(this.ThDiamond);
    this.PlayerCards3.add(this.QHeart);

    this.PlayerCards4.add(this.Jclub);
    this.PlayerCards4.add(this.TwoDiamond);
    this.PlayerCards4.add(this.ThHeart);

    // initialize the players
    this.player1 = new WhistPlayer(this.PlayerCards1, 1);
    this.player2 = new WhistPlayer(this.PlayerCards2, 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(this.PlayerCards4, 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    // initialize the current hand
    this.currentHand1.add(Fclub);
    this.currentHand1.add(Twoclub);
    this.currentHand1.add(Tclub);



    // initialize the whist model
    this.whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);

  }

  // setup the initial condition for a game that only one player has cards left
  // and the current hand is empty
  public void initConditionEndGame() {

    // initialize the cards in player3's hand
    // only one card left
    this.PlayerCards3.add(this.QHeart);

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(new ArrayList<>(), 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(new ArrayList<>(), 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Playing);

  }

  // setup the initial condition for a game that only one player has cards left
  // and the current hand is not empty
  public void initConditionEndGame1() {

    // initialize the cards in player3's hand
    // only one card left
    this.PlayerCards3.add(this.QHeart);

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(new ArrayList<>(), 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 2);
    this.player4 = new WhistPlayer(new ArrayList<>(), 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    // initialize the current hand
    this.currentHand1.add(Fclub);
    this.currentHand1.add(Twoclub);
    this.currentHand1.add(Tclub);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 2,
            this.currentHand1, GameStatus.Playing);

  }

  // setup the initial condition for a game that more than one player has cards left
  // the game should not end in this case
  public void initConditionEndGame2() {

    // initialize the cards in player3's hand
    // only one card left
    this.PlayerCards1.add(this.AHeart);
    this.PlayerCards3.add(this.QHeart);

    // initialize the players
    this.player1 = new WhistPlayer(this.PlayerCards1, 1);
    this.player2 = new WhistPlayer(this.PlayerCards2, 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(this.PlayerCards4, 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    // initialize the current hand
    this.currentHand1.add(Tclub);
    this.currentHand1.add(Thclub);
    this.currentHand1.add(Twoclub);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);

  }

  // test the method getHandWinner
  @Test
  public void TestGetHandWinner() {
    // a list of cards, the first card has the biggest value
    this.initConditionRandom();
    assertEquals(0, this.whistModel1.getHandWinner(3, Suit.Club));
    assertEquals(1, this.whistModel1.getHandWinner(0, Suit.Club));
    assertEquals(0, this.whistModel1.getHandWinner(2, Suit.Club));
    assertEquals(2, this.whistModel1.getHandWinner(1, Suit.Club));

    // a different list of cards, the last card has the biggest value
    this.initConditionRandom2();
    assertEquals(3, this.whistModel1.getHandWinner(3, Suit.Club));
    assertEquals(0, this.whistModel1.getHandWinner(0, Suit.Club));
    assertEquals(2, this.whistModel1.getHandWinner(2, Suit.Club));
    assertEquals(1, this.whistModel1.getHandWinner(1, Suit.Club));
  }

  // test the method getHandWinner, there is a card with some other suit
  // that doesn't match the current suit, the method should ignore the card
  // and only compare cards with current suit
  @Test
  public void TestGetHandWinner2() {
    // a list of cards, the first card has the biggest value
    this.initConditionRandom();
    // modify the current hand so that there is a card with non-current suit
    this.whistModel1.currentHand.add(this.TwoDiamond);
    assertEquals(0, this.whistModel1.getHandWinner(3, Suit.Club));
    assertEquals(1, this.whistModel1.getHandWinner(0, Suit.Club));
    assertEquals(3, this.whistModel1.getHandWinner(2, Suit.Club));
    assertEquals(2, this.whistModel1.getHandWinner(1, Suit.Club));
  }

  // test the method getHandWinner, there is a card with some other suit
  // that doesn't match the current suit, the method should ignore the card
  // and only compare cards with current suit
  @Test
  public void TestGetHandWinner3() {
    // a different list of cards, the last card has the biggest value
    this.initConditionRandom2();
    // change the first card to a different suit card
    this.whistModel1.currentHand.set(0, this.ThDiamond);
    assertEquals(2, this.whistModel1.getHandWinner(3, Suit.Club));
    assertEquals(0, this.whistModel1.getHandWinner(0, Suit.Club));
    assertEquals(2, this.whistModel1.getHandWinner(2, Suit.Club));
    assertEquals(1, this.whistModel1.getHandWinner(1, Suit.Club));
  }

  // test the method getCurrentPlayer
  @Test
  public void TestGetCurrentPlayer() {
    // set up the initial condition
    this.initConditionRandom();

    assertEquals(0, this.whistModel1.getCurrentPlayer());
    assertEquals(2, this.whistModel2.getCurrentPlayer());
    assertEquals(3, this.whistModel3.getCurrentPlayer());
  }

  // test the method getCurrentPlayer, using startPlay() and then get a full deck using getDeck()
  @Test
  public void TestGetCurrentPlayer2() {
    // set up the initial condition for a list of 2 players
    this.initCondition2();

    assertEquals(0, this.whistModel1.getCurrentPlayer());
    assertEquals(1, this.whistModel2.getCurrentPlayer());
    assertEquals(2, this.whistModel3.getCurrentPlayer());
  }


  // tests the method isGameOver
  // players have many cards left
  // the game should not end in this test
  @Test
  public void TestIsGameOverNo() {
    // setup the initial conditions for a non-ended game
    this.initConditionRandom();
    assertEquals(false, this.whistModel1.isGameOver());
    assertEquals(false, this.whistModel2.isGameOver());
    assertEquals(false, this.whistModel3.isGameOver());
    assertEquals(GameStatus.Playing, this.whistModel1.gameStatus);

  }

  // tests the method isGameOver, 2 players, a deck, using startPlayer
  // the game should not end in this test
  @Test
  public void TestIsGameOverNo_StartPlay() {
    // setup the initial conditions for a non-ended game
    this.initCondition2();
    assertEquals(false, this.whistModel1.isGameOver());
    assertEquals(false, this.whistModel2.isGameOver());
    assertEquals(false, this.whistModel3.isGameOver());
    assertEquals(GameStatus.Playing, this.whistModel1.gameStatus);

  }

  // tests the method isGameOver
  // there are more than one player has cards left
  // the game should not end in this test
  @Test
  public void TestIsGameOverNo2() {
    // setup the initial condition for an ended game
    this.initConditionEndGame2();
    assertEquals(false, this.whistModelEndGame.isGameOver());
    assertEquals(GameStatus.Playing, this.whistModelEndGame.gameStatus);
  }

  // tests the method isGameOver
  // only one player has cards left
  // but the current hand is not empty, has three cards
  // the game should not end in this test
  @Test
  public void TestIsGameOverNo3() {
    // setup the initial condition for an ended game
    this.initConditionEndGame1();
    assertEquals(false, this.whistModelEndGame.isGameOver());
  }


  // tests the method isGameOver
  // only one player has cards left
  // the game should end in this test
  @Test
  public void TestIsGameOverYes() {
    // setup the initial condition for an ended game
    this.initConditionEndGame();
    assertEquals(true, this.whistModelEndGame.isGameOver());
  }

  // tests the method isGameOver
  // no player has cards left
  // the game should end in this test
  @Test
  public void TestIsGameOverYes1() {
    // setup the initial condition for an ended game

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(new ArrayList<>(), 2);
    this.player3 = new WhistPlayer(new ArrayList<>(), 3);
    this.player4 = new WhistPlayer(new ArrayList<>(), 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Playing);

    assertEquals(true, this.whistModelEndGame.isGameOver());
  }



  // tests the method updateTally
  @Test
  public void TestUpdateTally() {
    // setup the initial condition
    this.initConditionRandom();
    // update player1's tally
    this.player1.updateTally();
    assertEquals(2, this.player1.getHowManyHandsWon());
    // update player2's tally
    this.player2.updateTally();
    assertEquals(3, this.player2.getHowManyHandsWon());
    // update player3's tally
    this.player3.updateTally();
    assertEquals(4, this.player3.getHowManyHandsWon());
    // update player4's tally
    this.player4.updateTally();
    assertEquals(5, this.player4.getHowManyHandsWon());
  }

  // tests the method getHowManyHandsWon
  @Test
  public void TestGetHowManyHandsWon() {
    // setup the initial condition
    this.initConditionRandom();
    assertEquals(1, this.player1.getHowManyHandsWon());
    assertEquals(2, this.player2.getHowManyHandsWon());
    assertEquals(3, this.player3.getHowManyHandsWon());
    assertEquals(4, this.player4.getHowManyHandsWon());
  }

  // the initial condition of a ended game with many winners
  public void initConditionDuplicateWinner() {

    // only player3 has one card left
    this.PlayerCards3.add(this.QHeart);

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(new ArrayList<>(), 3);
    this.player3 = new WhistPlayer(this.PlayerCards3, 2);
    this.player4 = new WhistPlayer(new ArrayList<>(), 3);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Won);

  }

  // the initial condition of a ended game with many winners
  public void initConditionDuplicateWinner2() {

    // only player3 has one card left
    this.PlayerCards3.add(this.QHeart);

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(new ArrayList<>(), 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 7);
    this.player4 = new WhistPlayer(new ArrayList<>(), 7);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Won);

  }

  // the initial condition of a ended game with many winners
  public void initConditionMultiWinner() {

    // only player3 has one card left
    this.PlayerCards3.add(this.QHeart);

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(new ArrayList<>(), 3);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(new ArrayList<>(), 3);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Won);

  }

  // tests the method getWinner() with only one winner
  @Test
  public void TestGetWinner() {
    // setup the initial condition for only one winner
    this.initConditionEndGame();
    assertEquals("4", this.whistModelEndGame.getWinner());
  }


  // tests the method getWinner() with two winners
  @Test
  public void TestGetDuplicateWinner() {
    // setup the initial condition for two winners
    this.initConditionDuplicateWinner();
    assertEquals("2, Player 4", this.whistModelEndGame.getWinner());
  }

  // tests the method getWinner() with multiple winners
  @Test
  public void TestGetDuplicateWinner2() {
    // setup the initial condition for multiple winners
    this.initConditionDuplicateWinner2();
    assertEquals("3, Player 4", this.whistModelEndGame.getWinner());
  }

  // tests the method getWinner() with multiple winners
  @Test
  public void TestGetMultiWinner() {
    // setup the initial condition for multiple winners
    this.initConditionMultiWinner();
    assertEquals("2, Player 3, Player 4", this.whistModelEndGame.getWinner());
  }

  // setup the initial condition for testing the game state
  public void initConditionGameState() {
    // initialize the whist model
    this.whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);
    this.whistModel2 = new WhistModel(this.listOfPlayer2, 2,
            this.currentHand1, GameStatus.Playing);
    this.whistModel3 = new WhistModel(this.listOfPlayer3, 0,
            this.currentHand1, GameStatus.Playing);
    // 2 players and a deck
    this.whistModel1.startPlay(2, whistModel1.getDeck());
    // 10 players and a deck
    this.whistModel2.startPlay(10, whistModel2.getDeck());
  }

  // setup the initial condition for testing the game state
  public void initConditionGameState_Exception() {
    // initialize the whist model
    this.whistModel3 = new WhistModel(this.listOfPlayer3, 0,
            this.currentHand1, GameStatus.Playing);
    // 0 players and a deck
    this.whistModel3.startPlay(0, whistModel3.getDeck());
  }

  String GameState1 =
          "Number of players: 4\n" +
          "Player 1: A♣, K♦, A♥\n" +
          "Player 2: K♣, Q♦, K♥\n" +
          "Player 3: Q♣, 3♦, Q♥\n" +
          "Player 4: J♣, 2♦, 3♥\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 3 hands won\n" +
          "Player 4: 4 hands won\n" +
          "Turn: Player 1";

  String GameState1_1 =
          "Number of players: 4\n" +
                  "Player 1: A♣, K♦, A♥\n" +
                  "Player 2: K♣, Q♦, K♥\n" +
                  "Player 3: Q♣, 3♦, Q♥\n" +
                  "Player 4: J♣, 2♦, 3♥\n" +
                  "Player 1: 1 hands won\n" +
                  "Player 2: 2 hands won\n" +
                  "Player 3: 3 hands won\n" +
                  "Player 4: 4 hands won\n" +
                  "Turn: Player 3";

  String GameState2 = "Number of players: 4\n" +
          "Player 1:\n" +
          "Player 2:\n" +
          "Player 3: Q♥\n" +
          "Player 4:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 3 hands won\n" +
          "Player 4: 4 hands won\n" +
          "Game over. Player 4 won.";

  String GameState_Won =
          "Number of players: 4\n" +
                  "Player 1:\n" +
                  "Player 2:\n" +
                  "Player 3: Q♥\n" +
                  "Player 4:\n" +
                  "Player 1: 1 hands won\n" +
                  "Player 2: 3 hands won\n" +
                  "Player 3: 3 hands won\n" +
                  "Player 4: 3 hands won\n" +
                  "Game over. Player 2, Player 3, Player 4 won.";

  // tests the new GetGameState method, game state is playing
  @Test
  public void TestGetGameState_Playing() {
    // setup the initial condition
    this.initConditionRandom();
    // if there are four players, game state is playing
    assertEquals(4, this.whistModel1.listOfWhistPlayer.size());
    assertEquals(GameState1, this.whistModel1.getGameState());
    assertEquals(GameState1_1, this.whistModel2.getGameState());
  }

  String GameState5 = "Number of players: 4\n" +
          "Player 1:\n" +
          "Player 2:\n" +
          "Player 3:\n" +
          "Player 4:\n" +
          "Player 1: 1 hands won\n" +
          "Player 2: 2 hands won\n" +
          "Player 3: 3 hands won\n" +
          "Player 4: 4 hands won\n" +
          "Game over. Player 4 won.";

  // tests the new GetGameState method, game state is playing
  // there are 4 players, but only one player has card left
  @Test
  public void TestGetGameState_Player2() {
    // setup the initial condition
    this.initConditionEndGame1();

    // if there are four players, game state is won
    assertEquals(4, this.whistModelEndGame.listOfWhistPlayer.size());
    this.whistModelEndGame.play(this.whistModelEndGame.getCurrentPlayer(), 0);
    assertEquals(3, this.whistModelEndGame.getCurrentPlayer());
    assertEquals("4", this.whistModelEndGame.getWinner());
    assertEquals(this.GameState5, this.whistModelEndGame.getGameState());
  }

  // tests the new GetGameState method, game state is playing
  // there are 4 players, but only one player has card left
  // calling a wrong player, not his turn
  @Test(expected = IllegalArgumentException.class)
  public void TestGetGameState_ExceptionPlayer() {
    // setup the initial condition
    this.initConditionEndGame();

    // if there are four players, game state is playing
    assertEquals(4, this.whistModelEndGame.listOfWhistPlayer.size());
    assertEquals(GameState2, this.whistModelEndGame.getGameState());
    // invalid player, not his turn
    this.whistModelEndGame.play(2, 0);
    assertEquals("3", this.whistModelEndGame.getWinner());

    // invalid player, not exist
    this.whistModelEndGame.play(10, 0);
    // checks the state of the game
    assertEquals(false, this.whistModelEndGame.isGameOver());
  }

  // tests the new GetGameState method, game state is won
  @Test
  public void TestGetGameState_Won() {
    // setup the initial condition
    this.initConditionMultiWinner();

    // if there are four players, game state is won
    assertEquals(4, this.whistModelEndGame.listOfWhistPlayer.size());
    assertEquals(GameState_Won, this.whistModelEndGame.getGameState());
    assertEquals(true, this.whistModelEndGame.isGameOver());

  }

  String GameState3 = "Number of players: 2\n" +
          "Player 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, " +
          "9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n" +
          "Player 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦," +
          " 6♦, 4♦, 2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Turn: Player 1";
  String GameState4 = "Number of players: 10\n" +
          "Player 1: A♣, 4♣, 7♦, 10♥, K♠, 3♠\n" +
          "Player 2: K♣, 3♣, 6♦, 9♥, Q♠, 2♠\n" +
          "Player 3: Q♣, 2♣, 5♦, 8♥, J♠\n" +
          "Player 4: J♣, A♦, 4♦, 7♥, 10♠\n" +
          "Player 5: 10♣, K♦, 3♦, 6♥, 9♠\n" +
          "Player 6: 9♣, Q♦, 2♦, 5♥, 8♠\n" +
          "Player 7: 8♣, J♦, A♥, 4♥, 7♠\n" +
          "Player 8: 7♣, 10♦, K♥, 3♥, 6♠\n" +
          "Player 9: 6♣, 9♦, Q♥, 2♥, 5♠\n" +
          "Player 10: 5♣, 8♦, J♥, A♠, 4♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Player 5: 0 hands won\n" +
          "Player 6: 0 hands won\n" +
          "Player 7: 0 hands won\n" +
          "Player 8: 0 hands won\n" +
          "Player 9: 0 hands won\n" +
          "Player 10: 0 hands won\n" +
          "Turn: Player 3";

  // tests the new GetGameState method, game state is playing, 2 players and 10 players
  // using startPlay and getDeck
  // call startPay with getDeck, pass it into play, then get gameState, sheck the status of the game
  // and getCurrentPlayer, then check whether the game isGameOver
  @Test
  public void TestGetGameState_Playing2() {
    // setup the initial condition
    this.initConditionGameState();

    // if there are 2 players, game state is playing (just start)
    assertEquals(2, this.whistModel1.listOfWhistPlayer.size());
    assertEquals(0, this.whistModel1.getCurrentPlayer());
    assertEquals(this.GameState3, this.whistModel1.getGameState());
    // if there are 10 players, game state is playing (just start)
    assertEquals(10, this.whistModel2.listOfWhistPlayer.size());
    assertEquals(this.GameState4, this.whistModel2.getGameState());
    assertEquals(2, this.whistModel2.getCurrentPlayer());
    assertEquals(false, this.whistModel1.isGameOver());
    assertEquals(false, this.whistModel2.isGameOver());
    // play the game
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(1, this.whistModel1.getCurrentPlayer());
    this.whistModel2.play(this.whistModel2.getCurrentPlayer(), 0);
    assertEquals(3, this.whistModel2.getCurrentPlayer());
  }
  // invalid suit
  // tests the new GetGameState method, game state is playing, 2 players and 10 players
  // using startPlay and getDeck
  @Test(expected = IllegalArgumentException.class)
  public void TestGetGameState_ExceptionPlaying2() {
  // setup the initial condition
  this.initConditionGameState();

  // if there are 2 players, game state is playing (just start)
  assertEquals(0, this.whistModel1.getCurrentPlayer());
  assertEquals(this.GameState3, this.whistModel1.getGameState());
  // if there are 10 players, game state is playing (just start)
  assertEquals(this.GameState4, this.whistModel2.getGameState());
  assertEquals(2, this.whistModel2.getCurrentPlayer());
  assertEquals(false, this.whistModel1.isGameOver());
  assertEquals(false, this.whistModel2.isGameOver());
  // play the game
  this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 3);
  assertEquals(1, this.whistModel1.getCurrentPlayer());
  this.whistModel2.play(this.whistModel2.getCurrentPlayer(), 2);
  assertEquals(3, this.whistModel2.getCurrentPlayer());
}
  /**
   * pass play with exception in startPlay
   * not enough player
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayAndStartPlayException() {
    // setup the initial condition
    this.initConditionGameState_Exception();
    // if there are 0 player, game state is playing (just start)
    assertEquals(0, this.whistModel2.listOfWhistPlayer.size());
    assertEquals(this.GameState4, this.whistModel3.getGameState());
  }

  /**
   * pass play with exception in play, then call getGameState
   * not enough player
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayAndStartPlayException2() {
    // setup the initial condition
    this.initConditionGameState_Exception();
    // if there are 0 player, game state is playing (just start)
    assertEquals(0, this.whistModel2.listOfWhistPlayer.size());
    this.whistModel2.play(this.whistModel2.getCurrentPlayer(), 0);
    assertEquals(this.GameState4, this.whistModel3.getGameState());
  }

  /**
   * pass play with exception in play, then call getGameState
   * not given player's turn
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayAndStartPlayException3() {
    // setup the initial condition
    this.initConditionGameState();
    this.whistModel1.play(2, 0);
    assertEquals(this.GameState3, this.whistModel1.getGameState());
  }

  /**
   * invalid given player
   * pass play with exception in play, then call getGameState
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayAndStartPlayException4() {
    // setup the initial condition
    this.initConditionGameState();
    this.whistModel1.play(5, 0);
    assertEquals(this.GameState3, this.whistModel1.getGameState());
  }




  // initial condition for play
  public void initialConditionPlay() {

    // initialize the whist model
    // first player starts play
    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);
    // last player starts play
    whistModel2 = new WhistModel(this.listOfPlayer2, 3,
            this.currentHand1, GameStatus.Playing);

    // 4 players with a full deck
    this.whistModel1.startPlay(4, this.whistModel1.getDeck());
    // 2 players with a full deck
    this.whistModel2.startPlay(2, this.whistModel2.getDeck());
  }

  // tests the method play, we are at the beginning of the game, there are
  // valid players play a valid card
  @Test
  public void TestPlay() {
    // setup the initial condition
    this.initialConditionPlay();
    // valid player plays a valid suit
    // current hand is full, should be initialized to 0
    //if the player is the first player in the hand
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(1, this.whistModel1.currentHand.size());
    assertEquals(1, this.whistModel1.getCurrentPlayer());
    assertEquals(GameStatus.Playing, this.whistModel1.gameStatus);
    assertEquals(this.Aclub, this.whistModel1.currentHand.get(0));
    assertEquals(Suit.Club, this.whistModel1.currentHand.get(0).suit);
    assertEquals(12, this.whistModel1.listOfWhistPlayer.get(0).playerCards.size());
    assertEquals(13, this.whistModel1.listOfWhistPlayer.get(1).playerCards.size());
    assertEquals(13, this.whistModel1.listOfWhistPlayer.get(2).playerCards.size());
    assertEquals(13, this.whistModel1.listOfWhistPlayer.get(3).playerCards.size());

    // if the player is the last player of the hand
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(2, this.whistModel1.currentHand.size());
    assertEquals(2, this.whistModel1.getCurrentPlayer());
    assertEquals(GameStatus.Playing, this.whistModel1.gameStatus);
    assertEquals(this.Kclub, this.whistModel1.currentHand.get(1));
    assertEquals(12, this.whistModel1.listOfWhistPlayer.get(0).playerCards.size());


    // at the end of a hand
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    // current hand was full, initialized to zero
    assertEquals(0, this.whistModel1.currentHand.size());
    assertEquals(0, this.whistModel1.getCurrentPlayer());
    assertEquals(GameStatus.Playing, this.whistModel1.gameStatus);
    // player 1 won the hand, checks if his tally is updated
    assertEquals(1, this.whistModel1.listOfWhistPlayer.get(0).getHowManyHandsWon());
    assertEquals(12, this.whistModel1.listOfWhistPlayer.get(0).playerCards.size());
    assertEquals(12, this.whistModel1.listOfWhistPlayer.get(1).playerCards.size());
    assertEquals(12, this.whistModel1.listOfWhistPlayer.get(2).playerCards.size());
    assertEquals(12, this.whistModel1.listOfWhistPlayer.get(3).playerCards.size());

  }

  // tests the method play, at the end of a hand
  // and we are also at the end of the game,
  // valid player playing valid cards
  @Test
  public void TestPlay2() {
    // setup the initial condition
    this.initConditionEndGame1();
    // valid player plays a valid suit
    // current hand has three cards, only one player is left with a card
    //if the player is the first player in the hand
    this.whistModelEndGame.play(this.whistModelEndGame.getCurrentPlayer(), 0);
    // current hand was full, initialized to zero
    assertEquals(0, this.whistModelEndGame.currentHand.size());
    // player 3 won the hand, checks if his tally is updated
    assertEquals(3, this.whistModelEndGame.listOfWhistPlayer.get(2).getHowManyHandsWon());
    assertEquals(3, this.whistModelEndGame.getCurrentPlayer());
    // updated game status
    assertEquals(GameStatus.Won, this.whistModelEndGame.gameStatus);
    // updated players' cards. all of them should run our of cards
    assertEquals(0, this.whistModelEndGame.listOfWhistPlayer.get(0).playerCards.size());
    assertEquals(0, this.whistModelEndGame.listOfWhistPlayer.get(1).playerCards.size());
    assertEquals(0, this.whistModelEndGame.listOfWhistPlayer.get(2).playerCards.size());
    assertEquals(0, this.whistModelEndGame.listOfWhistPlayer.get(3).playerCards.size());
  }

  // when the player at whosturn doesn't have any cards
  // skip this player, find the next one who has a valid card
  @Test
  public void TestPlayer3() {

    // setup the initial condition
    this.initCondition53();
    // 53 players
    assertEquals(53, this.whistModel1.listOfWhistPlayer.size());
    // plays the card round, since there are 53 players, players will run out of cards
    // when they play once, they don't have card anymore, the play method should
    // find a player who has a card and keep the game running
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(1, this.whistModel1.getCurrentPlayer());
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(2, this.whistModel1.getCurrentPlayer());
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(3, this.whistModel1.getCurrentPlayer());
  }

  // test the method play when given a wrong suit
  // when the player doesn't have any valid card that matches the current suit
  // then allow the player discard the card
  @Test
  public void TestPlayer4() {

    // setup the initial condition
    this.initConditionRandom();
    // 4 players
    assertEquals(4, this.whistModel1.listOfWhistPlayer.size());
    // remove a valid suit to make the player doesn't own any valid card that matches
    // the current suit
    this.whistModel1.listOfWhistPlayer.get(0).playerCards.remove(0);
    assertEquals(2, this.whistModel1.listOfWhistPlayer.get(0).playerCards.size());
    // plays the game
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(0, this.whistModel1.getCurrentPlayer());
    // his card got discard (removed from his cards)
    assertEquals(1, this.whistModel1.listOfWhistPlayer.get(0).playerCards.size());
    // card got added to the current hand, the hand is initialized to zero
    // that card's value doesn't count
    assertEquals(0, this.whistModel1.currentHand.size());
    assertEquals(2, this.whistModel1.listOfWhistPlayer.get(1).getHowManyHandsWon());
    assertEquals(GameStatus.Playing, this.whistModel1.gameStatus);
    // keep playing the game
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 0);
    assertEquals(1, this.whistModel1.getCurrentPlayer());
  }


  /**
   * test method play with exceptions
   */

  // test the method play when given a wrong suit
  // if the player has a valid suit in his hand
  // play will not allow the player discard the given card
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayerException() {
    // setup the initial condition
    this.initConditionRandom();
    // 4 players
    assertEquals(4, this.whistModel1.listOfWhistPlayer.size());
    // plays the game, gives a wrong suit card
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 2);
    // pass it into getGameSate
    this.whistModel1.getGameState();
  }

  // invalid given card index
  // towards the end of the game when a player doesn't have card
  // given a card index that does not exist
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayerException1() {
    // set up the initial condition
    this.initConditionUpdateWhosTurn();
    this.whistModelEndGame.play(this.whistModelEndGame.getCurrentPlayer(), 0);
  }
  // when the given card index doesn't belong to the player
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayerException2() {
    // set up the initial condition
    this.initialConditionPlay();
    // given a card index that doesn't belong to the player
    // index larger than the length of the player's list of cards
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 30);
    this.whistModel1.play(this.whistModel1.getCurrentPlayer(), 13);
    this.whistModel2.play(this.whistModel2.getCurrentPlayer(), -1);
    this.whistModel2.play(this.whistModel2.getCurrentPlayer(), 26);
  }
  // when given player index is not valid
  // it is not the player's turn yet
  @Test(expected = IllegalArgumentException.class)
  public void TestPlayerException3() {
    // set up the initial condition
    this.initialConditionPlay();
    // given an play not his turn
    this.whistModel1.play(1, 0);
    this.whistModel1.play(2, 2);
    this.whistModel1.play(3, 12);
    this.whistModel2.play(1, 0);
    this.whistModel2.play(0, 12);
    this.whistModel2.play(2, 3);
    // given an invalid player number
    this.whistModel1.play(-1, 0);
    this.whistModel2.play(-1, 2);
  }


  // the initial condition of a ended game with many winners
  public void initConditionUpdateWhosTurn() {

    // only player2 and 3 has one card left
    this.PlayerCards2.add(this.ThHeart);
    this.PlayerCards2.add(this.AHeart);
    this.PlayerCards3.add(this.QHeart);
    this.PlayerCards3.add(this.KHeart);

    // initialize the players
    this.player1 = new WhistPlayer(new ArrayList<>(), 1);
    this.player2 = new WhistPlayer(this.PlayerCards2, 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(new ArrayList<>(), 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    this.whistModelEndGame = new WhistModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Playing);

  }
  // tests the method updatWhosTurn for a normal case
  @Test
  public void TestUpdateWhosTurn() {
    // set up the initial condition
    this.initialConditionPlay();
    // before update next player
    assertEquals(0, this.whistModel1.getCurrentPlayer());
    // update to the next player
    this.whistModel1.updateWhosTurn();
    assertEquals(1, this.whistModel1.getCurrentPlayer());
    // update to the next player
    this.whistModel1.updateWhosTurn();
    assertEquals(2, this.whistModel1.getCurrentPlayer());
    // update to the next player
    this.whistModel1.updateWhosTurn();
    assertEquals(3, this.whistModel1.getCurrentPlayer());
    // update to the next player
    this.whistModel1.updateWhosTurn();
    assertEquals(0, this.whistModel1.getCurrentPlayer());

  }

  // tests the method updatWhosTurn for the the next player doesn't have any cards
  @Test
  public void TestUpdateWhosTurn2() {
    // set up the initial condition
    this.initConditionUpdateWhosTurn();
    // before update next player
    assertEquals(3, this.whistModelEndGame.getCurrentPlayer());
    // update to the next player who has a card
    this.whistModelEndGame.updateWhosTurn();
    assertEquals(1, this.whistModelEndGame.getCurrentPlayer());
    // update to the next player who has a card
    this.whistModelEndGame.updateWhosTurn();
    assertEquals(2, this.whistModelEndGame.getCurrentPlayer());
    // update to the next player who has a card
    this.whistModelEndGame.updateWhosTurn();
    assertEquals(1, this.whistModelEndGame.getCurrentPlayer());
    // update to the next player who has a card
    this.whistModelEndGame.updateWhosTurn();
    assertEquals(2, this.whistModelEndGame.getCurrentPlayer());
  }


  // setup the initial conditions for list of 53 Whistplayers
  public void initCondition53() {

    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);

    // 53 players and a deck
    this.whistModel1.startPlay(53, this.whistModel1.getDeck());

    // gets the list of cards the first player has
    PlayerCards1 = whistModel1.listOfWhistPlayer.get(0).playerCards;

    // gets the list of cards the second player has
    PlayerCards2 = whistModel1.listOfWhistPlayer.get(1).playerCards;

    // gets the list of cards the third player has
    PlayerCards3 = whistModel1.listOfWhistPlayer.get(2).playerCards;

    // gets the list of cards the 52 player has
    PlayerCards52 = whistModel1.listOfWhistPlayer.get(51).playerCards;

    // gets the list of cards the 53 player has
    PlayerCards53 = whistModel1.listOfWhistPlayer.get(52).playerCards;

  }

  // test the method startPlay with 53 player
  @Test
  public void TestManyPlayers() {
    // setup the initial conditions
    this.initCondition53();
    // 53 players and a deck
    // checks the size of list of players, should be 53
    assertEquals(53, this.whistModel1.listOfWhistPlayer.size());
    // checks the size of list of a player's cards
    assertEquals(1, PlayerCards1.size());  // the first player
    assertEquals(1, PlayerCards2.size());   // the second player
    assertEquals(1, PlayerCards3.size());   // the third player
    assertEquals(1, PlayerCards52.size());   // the 52nd player
    assertEquals(0, PlayerCards53.size());   // the 53rd player
  }

  /**
   * tests the method startPlay exceptions
   */

  // not enough player, 1 player
  @Test(expected = IllegalArgumentException.class)
  public void NotEnoughPlayerException() {

    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);

    this.whistModel1.startPlay(1, this.whistModel1.getDeck());
  }

  // not enough player, 0 player
  @Test(expected = IllegalArgumentException.class)
  public void NotEnoughPlayerException2() {
    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);
    this.whistModel1.startPlay(0, this.whistModel1.getDeck());
  }

  // not enough player, -1 player
  @Test(expected = IllegalArgumentException.class)
  public void NotEnoughPlayerException3() {
    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);
    this.whistModel1.startPlay(-1, this.whistModel1.getDeck());
  }


  List<StandardDeckCard> invalidDeck;
  List<StandardDeckCard> invalidDeck2;
  List<StandardDeckCard> invalidDeck3;
  List<StandardDeckCard> invalidDeck4;

  // setup the initial conditions of deck of cards
  public void initCondition() {

    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);

    invalidDeck = new ArrayList();
    invalidDeck2 = this.whistModel1.getDeck();
    invalidDeck3 = this.whistModel1.getDeck();
    invalidDeck4 = this.whistModel1.getDeck();

    // a deck with only two cards
    invalidDeck.add(Aclub);
    invalidDeck.add(Kclub);

    // set a duplicate card in a deck
    invalidDeck2.remove(1);
    invalidDeck2.set(1, Aclub);

    // a deck with not enough cards, 50 cards
    invalidDeck3.remove(2);

    // a deck with more than 52 cards
    invalidDeck4.add(Aclub);
  }


  /**
   * tests the method startPlay exceptions
   */
  // pass in invalid deck with only two cards
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException() {
    this.initCondition();
    this.whistModel1.startPlay(2, invalidDeck);
  }

  // pass in invalid deck with a duplicate card in a deck
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException1() {
    this.initCondition();
    this.whistModel1.startPlay(3, invalidDeck2);
  }

  // pass in invalid deck with not enough cards, 50 cards
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException2() {
    this.initCondition();
    this.whistModel1.startPlay(5, invalidDeck3);
  }

  // pass in invalid deck with more than 52 cards
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException3() {
    this.initCondition();
    this.whistModel1.startPlay(52, invalidDeck4);
  }

  // setup the initial conditions for list of 2 players
  public void initCondition2() {
    whistModel1 = new WhistModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing);

    // two players and a deck
    this.whistModel1.startPlay(2, this.whistModel1.getDeck());

    // gets the list of cards the first player has
    PlayerCards1 = this.whistModel1.listOfWhistPlayer.get(0).playerCards;

    // gets the list of cards the second player has
    PlayerCards2 = this.whistModel1.listOfWhistPlayer.get(1).playerCards;

    whistModel2 = new WhistModel(this.listOfPlayer1, 1,
            this.currentHand1, GameStatus.Playing);

    // 3 players and a deck
    this.whistModel2.startPlay(3, this.whistModel2.getDeck());

    whistModel3 = new WhistModel(this.listOfPlayer1, 2,
            this.currentHand1, GameStatus.Playing);

    // 36 players and a deck
    this.whistModel3.startPlay(36, this.whistModel2.getDeck());
  }

  // player1's list of cards
  String player1cards = " A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦," +
          " 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠";
  // player2's list of cards
  String player2cards = " K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦," +
          " K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠";
  /**
   * tests the method printCards
   */
  @Test
  public void TestPrintCards() {
    // setup the inition condition
    this.initCondition2();

    // print the list of cards the first player has
    assertEquals(player1cards, this.whistModel1.listOfWhistPlayer.get(0).printCards());
    // print the list of cards the second player has
    assertEquals(player2cards, this.whistModel1.listOfWhistPlayer.get(1).printCards());
  }

}
