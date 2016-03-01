package cs3500.hw04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cs3500.hw02.CardValue;
import cs3500.hw02.StandardDeckCard;
import cs3500.hw02.Suit;
import cs3500.hw03.CardGameModel;
import cs3500.hw03.GameStatus;
import cs3500.hw03.WhistPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


// tests the methods

public class TestWhistTrumpModel {



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
  WhistTrumpModel whistTrumpModel1;
  WhistTrumpModel whistTrumpModel2;
  WhistTrumpModel whistTrumpModel3;
  WhistTrumpModel whistTrumpModelEndGame;
  WhistTrumpModel whistTrumpModel_Trump;
  WhistTrumpModel whistTrumpModel_Trump1;
  // setup the initial conditions for list of 2 players
  public void initCondition() {

    this.whistTrumpModel1 = new WhistTrumpModel();

    // two players and a deck
    this.whistTrumpModel1.startPlay(2, this.whistTrumpModel1.getDeck());
    this.whistTrumpModel2 = new WhistTrumpModel();
    this.whistTrumpModel2.startPlay(4, this.whistTrumpModel2.getDeck());



    this.whistTrumpModel3 = new WhistTrumpModel();
    List<StandardDeckCard> deck = this.whistTrumpModel3.getDeck();
    // sets the first card in the deck a heart
    int indexHeart = deck.indexOf(KHeart);
    deck.set(0, KHeart);
    deck.set(indexHeart, Aclub);
    this.whistTrumpModel3.startPlay(5, deck);

    this.whistTrumpModelEndGame = new WhistTrumpModel();
    this.whistTrumpModelEndGame.startPlay(10, this.whistTrumpModelEndGame.getDeck());

  }

  // tests the method startPlay to see
  // if it set the trump suit in the beginning of a game
  @Test
  public void TestStartPlay() {
    // setup the initial condition
    this.initCondition();
    // checks if the trump suit is setup
    assertEquals(Suit.Club, this.whistTrumpModel1.getTrumpSuit());
  }

  // tests the helper method getTrumpSuit
  @Test
  public void TestGetTrumpSuit() {

    // setup the initial condition
    this.initCondition();

    assertEquals(Suit.Club, this.whistTrumpModel1.getTrumpSuit());
    assertEquals(Suit.Club, this.whistTrumpModel2.getTrumpSuit());
    assertEquals(Suit.Heart, this.whistTrumpModel3.getTrumpSuit());
  }



  String GameState = "Number of players: 2\n" +
          "Player 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, " +
          "9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n" +
          "Player 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦," +
          " 6♦, 4♦, 2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣";

  String GameState2 = "Number of players: 4\n" +
          "Player 1: A♣, 10♣, 6♣, 2♣, J♦, 7♦, 3♦, Q♥, 8♥, 4♥, K♠, 9♠, 5♠\n" +
          "Player 2: K♣, 9♣, 5♣, A♦, 10♦, 6♦, 2♦, J♥, 7♥, 3♥, Q♠, 8♠, 4♠\n" +
          "Player 3: Q♣, 8♣, 4♣, K♦, 9♦, 5♦, A♥, 10♥, 6♥, 2♥, J♠, 7♠, 3♠\n" +
          "Player 4: J♣, 7♣, 3♣, Q♦, 8♦, 4♦, K♥, 9♥, 5♥, A♠, 10♠, 6♠, 2♠\n" +
          "Player 1: 0 hands won\n" +
          "Player 2: 0 hands won\n" +
          "Player 3: 0 hands won\n" +
          "Player 4: 0 hands won\n" +
          "Turn: Player 1\n" +
          "Trump suit: ♣";

  // tests the method getGameState
  @Test
  public void TestGetGameState() {

    // setup the initial condition
    this.initCondition();
    // if there are 2 players, game state is playing (just start)
    assertEquals(0, this.whistTrumpModel1.getCurrentPlayer());
    assertEquals(Suit.Club, this.whistTrumpModel1.getTrumpSuit());
    assertEquals(this.GameState, this.whistTrumpModel1.getGameState());
    assertEquals(this.GameState2, this.whistTrumpModel2.getGameState());
  }

  // setup the initial conditions for a WhistModel with 4 players
  // each player has three cards
  // first player should win the hand
  public void initCondition_Mock() {

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
    this.whistTrumpModel1 = new WhistTrumpModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing, Suit.Heart);
    this.whistTrumpModel2 = new WhistTrumpModel(this.listOfPlayer1, 2,
            this.currentHand1, GameStatus.Playing, Suit.Club);
    this.whistTrumpModel3 = new WhistTrumpModel(this.listOfPlayer1, 3,
            this.currentHand1, GameStatus.Playing, Suit.Diamond);

  }

  // setup the initial conditions for a WhistModel with 4 players
  // each player has three cards
  // last player should win the hand
  public void initCondition_Mock2() {

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
    this.whistTrumpModel1 = new WhistTrumpModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing, Suit.Spade);

  }
  // test the method getHandWinner, no trump suit in current hand
  @Test
  public void TestGetHandWinner() {
    // a list of cards, the first card has the biggest value
    this.initCondition_Mock();
    assertEquals(0, this.whistTrumpModel1.getHandWinner(3, Suit.Club));
    assertEquals(1, this.whistTrumpModel1.getHandWinner(0, Suit.Club));
    assertEquals(0, this.whistTrumpModel1.getHandWinner(2, Suit.Club));
    assertEquals(2, this.whistTrumpModel1.getHandWinner(1, Suit.Club));

    // a different list of cards, the last card has the biggest value
    this.initCondition_Mock2();
    assertEquals(3, this.whistTrumpModel1.getHandWinner(3, Suit.Club));
    assertEquals(0, this.whistTrumpModel1.getHandWinner(0, Suit.Club));
    assertEquals(2, this.whistTrumpModel1.getHandWinner(2, Suit.Club));
    assertEquals(1, this.whistTrumpModel1.getHandWinner(1, Suit.Club));
  }

  // test the method getHandWinner, there is a card with some other suit
  // that doesn't match the current suit, the method should ignore the card
  // and only compare cards with current suit
  @Test
  public void TestGetHandWinner3() {
    // a different list of cards, the last card has the biggest value
    this.initCondition_Mock2();
    // change the first card to a different suit card
    assertEquals(2, this.whistTrumpModel1.getHandWinner(3, Suit.Club));
    assertEquals(0, this.whistTrumpModel1.getHandWinner(0, Suit.Club));
    assertEquals(2, this.whistTrumpModel1.getHandWinner(2, Suit.Club));
    assertEquals(1, this.whistTrumpModel1.getHandWinner(1, Suit.Club));
  }


  // setup the initial conditions for a WhistModel with 4 players
  // each player has three cards, except player4, who only has trump suit card
  // player 4 should win the hand
  public void initCondition_Mock3() {

    this.PlayerCards1.clear();
    this.PlayerCards2.clear();
    this.PlayerCards3.clear();
    this.PlayerCards4.clear();

    // initialize the list of cards each player has
    this.PlayerCards1.add(this.Aclub);
    this.PlayerCards1.add(this.KDiamond);
    this.PlayerCards1.add(this.AHeart);

    this.PlayerCards2.add(this.Kclub);
    this.PlayerCards2.add(this.QDiamond);
    this.PlayerCards2.add(this.KHeart);

    this.PlayerCards3.add(this.Jclub);
    this.PlayerCards3.add(this.TwoDiamond);


    // player 4 only has trump suit
    this.PlayerCards4.add(this.KHeart);
    this.PlayerCards4.add(this.QHeart);


    // initialize the players
    this.player1 = new WhistPlayer(this.PlayerCards1, 1);
    this.player2 = new WhistPlayer(this.PlayerCards2, 2);
    this.player3 = new WhistPlayer(this.PlayerCards3, 3);
    this.player4 = new WhistPlayer(this.PlayerCards4, 4);

    // initialize the listofPlayer, adds the players to the list
    this.listOfPlayer1.clear();
    this.listOfPlayer1.add(this.player1);
    this.listOfPlayer1.add(this.player2);
    this.listOfPlayer1.add(this.player3);
    this.listOfPlayer1.add(this.player4);

    // initialize the current hand
    this.currentHand1.clear();
    this.currentHand1.add(Fclub);
    this.currentHand1.add(ThHeart);
    this.currentHand1.add(Twoclub);
    this.currentHand1.add(Tclub);


    // initialize the whist model
    this.whistTrumpModel_Trump1 = new WhistTrumpModel(this.listOfPlayer1, 0,
            this.currentHand1, GameStatus.Playing, Suit.Heart);

  }

  // tests the method getHandWinner, has one trump suit in the current hand
  @Test
  public void TestGetHandWinner_Trump1() {
    // setup the initial condition
    this.initCondition_Mock3();
    // player 4 plays a trump suit card
   // this.whistTrumpModel1.play(3, 0);
    assertEquals(Suit.Heart, this.whistTrumpModel_Trump1.getTrumpSuit());
  }


  // change the first card in a deck from suit club to diamond
  // and see if the trump suit is right
  @Test
  public void TestTrumpSuit() {
    WhistModelCreator creator = new WhistModelCreator();
    CardGameModel whistModel = creator.create(WhistModelCreator.ModelType.NOTRUMP);
    CardGameModel whistTrumpModel = creator.create(WhistModelCreator.ModelType.TRUMP);

    List<StandardDeckCard> aDeck = whistModel.getDeck();


    // modify a deck to make the first card suit not a club
    int cardIdx = aDeck.indexOf(Aclub);
    aDeck.set(aDeck.indexOf(KDiamond),
            Aclub);
    aDeck.set(cardIdx, KDiamond);

    assertEquals(Suit.Diamond, aDeck.get(0).suit);

    whistModel.startPlay(3, aDeck);

    assertEquals("Number of players: 3\n" +
            "Player 1: J♣, 8♣, 5♣, 2♣, K♦, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: A♣, Q♣, 9♣, 6♣, 3♣, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 0 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 1", whistModel.getGameState());


    List<StandardDeckCard> anotherDeck = whistTrumpModel.getDeck();


    // modify a deck to make the first card suit not a club
    int cardIndex = anotherDeck.indexOf(Aclub);
    anotherDeck.set(anotherDeck.indexOf(KDiamond),
            Aclub);
    anotherDeck.set(cardIndex, KDiamond);

    assertEquals(Suit.Diamond, anotherDeck.get(0).suit);


    assertEquals(Suit.Diamond, anotherDeck.get(0).suit);

    whistTrumpModel.startPlay(10, anotherDeck);
    // checks if the trump suit matches the first card's suit
    assertTrue(whistTrumpModel.getGameState().contains("Trump suit: ♦"));

    assertEquals("Number of players: 10\n" +
            "Player 1: 4♣, K♦, 7♦, 10♥, K♠, 3♠\n" +
            "Player 2: K♣, 3♣, 6♦, 9♥, Q♠, 2♠\n" +
            "Player 3: Q♣, 2♣, 5♦, 8♥, J♠\n" +
            "Player 4: J♣, A♦, 4♦, 7♥, 10♠\n" +
            "Player 5: A♣, 10♣, 3♦, 6♥, 9♠\n" +
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
            "Turn: Player 1\n" +
            "Trump suit: ♦", whistTrumpModel.getGameState());

  }









  //test the method getHandWinner, there is a card with some other suit
  // that doesn't match the current suit, the method should ignore the "discarded" card
  // and only compare cards with current suit
  @Test
  public void TestGetHandWinnerAndPlay() {
    WhistTrumpModel game = new WhistTrumpModel();
    game.startPlay(3, game.getDeck());
    // checks the trump suit before plays
    assertEquals(Suit.Club, game.getTrumpSuit());
    game.play(0, 5);
    game.play(1, 5);
    game.play(2, 5);

    game.play(0, 5);
    game.play(1, 5);
    game.play(2, 5);

    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, J♣, 8♣, 5♣, 2♣, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, A♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Trump suit: ♣", game.getGameState());
    game.play(0, 5);
    game.play(1, 5);
    game.play(2, 5);

    game.play(0, 5);
    game.play(1, 4);
    game.play(2, 4);

    game.play(1, 4);
    // plays a trump suit
    game.play(2, 0);
    game.play(0, 1);

    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, 8♣, 5♣, 2♣, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: 9♣, 6♣, 3♣, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 2 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Trump suit: ♣", game.getGameState());
    // test getHandWinner by checking who is the hand winner in getGameState
    // player 2 should win the trick because he plays a trump suit in the hand
    assertEquals(true, game.getGameState().contains("Turn: Player 2"));

    // player 2 starts another trick, and he plays a trump suit as the first card,
    // in this trick, whoever plays the largest value wins the hand

    game.play(1, 0);
    game.play(2, 0);
    game.play(0, 0);
    assertEquals("Number of players: 3\n" +
            "Player 1: 8♣, 5♣, 2♣, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: 10♣, 7♣, 4♣, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: 6♣, 3♣, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 4 hands won\n" +
            "Player 2: 2 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Trump suit: ♣", game.getGameState());
    // player 1 wins the game because he has the largest value in the trick
    assertEquals(true, game.getGameState().contains("Turn: Player 1"));
    assertEquals(Suit.Club, game.getTrumpSuit());
}

  //test the method getHandWinner, there is a card with some other suit
  // that doesn't match the current suit, the method should ignore the card
  // and only compare cards with current suit
  @Test(expected = IllegalArgumentException.class)
  public void TestGetHandWinner_Play() {
    WhistTrumpModel game = new WhistTrumpModel();
    game.startPlay(3, game.getDeck());
    // checks the trump suit before plays
    assertEquals(Suit.Club, game.getTrumpSuit());
    game.play(0, 5);
    game.play(1, 5);
    game.play(2, 5);

    game.play(0, 0); // this should throw an exception since player2 is giving a wrong suit
    game.play(1, 7);
    game.play(2, 0);

    game.play(0, 5);
    game.play(1, 5);
    game.play(2, 5);

    game.play(0, 5);
    game.play(1, 5);
    game.play(2, 5);

    game.play(0, 5);
    game.play(1, 4);
    game.play(2, 4);
    assertEquals("Number of players: 3\n" +
        "Player 1: A♣, J♣, 8♣, 5♣, 2♣, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
        "Player 2: K♣, 10♣, 7♣, 4♣, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
        "Player 3: Q♣, 9♣, 6♣, 3♣, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
        "Player 1: 3 hands won\n" +
        "Player 2: 1 hands won\n" +
        "Player 3: 0 hands won\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣", game.getGameState());

    game.play(1, 4);
    // plays a trump suit
    game.play(2, 0);
    game.play(0, 1);

    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, 8♣, 5♣, 2♣, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: 9♣, 6♣, 3♣, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 2 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 2\n" +
            "Trump suit: ♣", game.getGameState());
    // test getHandWinner by checking who is the hand winner in getGameState
    // player 2 should win the trick because he plays a trump suit in the hand
    assertEquals(true, game.getGameState().contains("Turn: Player 2"));

    game.play(0, 0); // this should throw an exception since it is not player 1's turn
    game.play(1, 0);
    game.play(2, 0);

  }

  /**
   * test the method create
   */
  @Test
  public void TestCreate() {
    WhistModelCreator creator = new WhistModelCreator();
    CardGameModel whistModel = creator.create(WhistModelCreator.ModelType.NOTRUMP);
    CardGameModel whistTrumpModel = creator.create(WhistModelCreator.ModelType.TRUMP);


    whistModel.startPlay(3, whistModel.getDeck());
    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 0 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 1", whistModel.getGameState());
    assertEquals(0, whistModel.getCurrentPlayer());
    assertEquals(false, whistModel.isGameOver());
    whistModel.play(0, 5);
    whistModel.play(1, 5);
    whistModel.play(2, 5);
    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, J♣, 8♣, 5♣, 2♣, 9♦, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, A♦, 8♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 7♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 1", whistModel.getGameState());
    whistModel.play(0, 5);
    whistModel.play(1, 5);
    whistModel.play(2, 5);
    assertEquals("Number of players: 3\n" +
            "Player 1: A♣, J♣, 8♣, 5♣, 2♣, 6♦, 3♦, K♥, 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠\n" +
            "Player 2: K♣, 10♣, 7♣, 4♣, A♦, 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠\n" +
            "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 4♦, A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Turn: Player 1", whistModel.getGameState());
    whistModel.play(0, 5);
    whistModel.play(1, 5);
    assertEquals(2, whistModel.getCurrentPlayer());
    assertEquals(false, whistModel.isGameOver());
    whistModel.play(2, 5);


    whistTrumpModel.startPlay(6, whistModel.getDeck());
    // checks the trump suit before plays
    assertEquals(0, whistModel.getCurrentPlayer());
    assertEquals(false, whistModel.isGameOver());
    whistTrumpModel.play(0, 5);
    // player1 played, it is player 2's turn
    assertEquals("Number of players: 6\n" +
            "Player 1: A♣, 8♣, 2♣, 9♦, 3♦, 4♥, J♠, 5♠\n" +
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
            "Trump suit: ♣", whistTrumpModel.getGameState());
    assertEquals(1, whistTrumpModel.getCurrentPlayer());
    assertEquals(false, whistTrumpModel.isGameOver());
    whistTrumpModel.play(1, 5);
    whistTrumpModel.play(2, 5);
    whistTrumpModel.play(3, 5);
    whistTrumpModel.play(4, 5);
    whistTrumpModel.play(5, 5);
    assertEquals("Number of players: 6\n" +
            "Player 1: A♣, 8♣, 2♣, 9♦, 3♦, 4♥, J♠, 5♠\n" +
            "Player 2: K♣, 7♣, A♦, 8♦, 2♦, 3♥, 10♠, 4♠\n" +
            "Player 3: Q♣, 6♣, K♦, 7♦, A♥, 2♥, 9♠, 3♠\n" +
            "Player 4: J♣, 5♣, Q♦, 6♦, K♥, A♠, 8♠, 2♠\n" +
            "Player 5: 10♣, 4♣, J♦, 5♦, Q♥, K♠, 7♠\n" +
            "Player 6: 9♣, 3♣, 10♦, 4♦, J♥, Q♠, 6♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 0 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Player 5: 0 hands won\n" +
            "Player 6: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Trump suit: ♣", whistTrumpModel.getGameState());
    whistTrumpModel.play(0, 5);
    whistTrumpModel.play(1, 5);
    whistTrumpModel.play(2, 4);
    whistTrumpModel.play(3, 4);
    whistTrumpModel.play(4, 4);
    whistTrumpModel.play(5, 4);

    assertEquals("Number of players: 6\n" +
            "Player 1: A♣, 8♣, 2♣, 9♦, 3♦, J♠, 5♠\n" +
            "Player 2: K♣, 7♣, A♦, 8♦, 2♦, 10♠, 4♠\n" +
            "Player 3: Q♣, 6♣, K♦, 7♦, 2♥, 9♠, 3♠\n" +
            "Player 4: J♣, 5♣, Q♦, 6♦, A♠, 8♠, 2♠\n" +
            "Player 5: 10♣, 4♣, J♦, 5♦, K♠, 7♠\n" +
            "Player 6: 9♣, 3♣, 10♦, 4♦, Q♠, 6♠\n" +
            "Player 1: 1 hands won\n" +
            "Player 2: 0 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Player 5: 0 hands won\n" +
            "Player 6: 0 hands won\n" +
            "Turn: Player 3\n" +
            "Trump suit: ♣", whistTrumpModel.getGameState());
    // player 3 is going to play heart, which no one has
    // player 4 is going to play a trump suit
    // player 5 is going to discard a card
    whistTrumpModel.play(2, 4);
    whistTrumpModel.play(3, 1);  // 5 club, trump suit
    whistTrumpModel.play(4, 4);  // discard
    whistTrumpModel.play(5, 0);  // 10 club, trump suit
    whistTrumpModel.play(0, 1);  // 8 club, trump suit
    whistTrumpModel.play(1, 0);   //K club , trump suit
    // player 2 should win the hand, because he plays the largest value trump suit
    assertTrue(whistTrumpModel.getGameState().contains("Turn: Player 2"));
    assertTrue(whistTrumpModel.getGameState().contains("Trump suit: ♣"));


    // finish playing the game
    whistTrumpModel.play(1, 0);
    whistTrumpModel.play(2, 0);
    whistTrumpModel.play(3, 0);
    whistTrumpModel.play(4, 0);
    whistTrumpModel.play(5, 0);
    whistTrumpModel.play(0, 0);

    assertEquals("Number of players: 6\n" +
            "Player 1: 2♣, 9♦, 3♦, J♠, 5♠\n" +
            "Player 2: A♦, 8♦, 2♦, 10♠, 4♠\n" +
            "Player 3: 6♣, K♦, 7♦, 9♠, 3♠\n" +
            "Player 4: Q♦, 6♦, A♠, 8♠, 2♠\n" +
            "Player 5: 4♣, J♦, 5♦, 7♠\n" +
            "Player 6: 10♦, 4♦, Q♠, 6♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Player 5: 0 hands won\n" +
            "Player 6: 0 hands won\n" +
            "Turn: Player 1\n" +
            "Trump suit: ♣", whistTrumpModel.getGameState());
// finish playing the game
    whistTrumpModel.play(0, 0);
    whistTrumpModel.play(1, 0); // discards a card
    whistTrumpModel.play(2, 0);
    whistTrumpModel.play(3, 0);
    whistTrumpModel.play(4, 0);
    whistTrumpModel.play(5, 0);
    assertEquals("Number of players: 6\n" +
            "Player 1: 9♦, 3♦, J♠, 5♠\n" +
            "Player 2: 8♦, 2♦, 10♠, 4♠\n" +
            "Player 3: K♦, 7♦, 9♠, 3♠\n" +
            "Player 4: 6♦, A♠, 8♠, 2♠\n" +
            "Player 5: J♦, 5♦, 7♠\n" +
            "Player 6: 4♦, Q♠, 6♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Player 5: 0 hands won\n" +
            "Player 6: 1 hands won\n" +
            "Turn: Player 6\n" +
            "Trump suit: ♣", whistTrumpModel.getGameState());


    whistTrumpModel.play(5, 0);
    whistTrumpModel.play(0, 0);
    whistTrumpModel.play(1, 0);
    whistTrumpModel.play(2, 0);
    whistTrumpModel.play(3, 0);
    whistTrumpModel.play(4, 0);
    assertEquals("Number of players: 6\n" +
            "Player 1: 3♦, J♠, 5♠\n" +
            "Player 2: 2♦, 10♠, 4♠\n" +
            "Player 3: 7♦, 9♠, 3♠\n" +
            "Player 4: A♠, 8♠, 2♠\n" +
            "Player 5: 5♦, 7♠\n" +
            "Player 6: Q♠, 6♠\n" +
            "Player 1: 2 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 0 hands won\n" +
            "Player 5: 1 hands won\n" +
            "Player 6: 1 hands won\n" +
            "Turn: Player 5\n" +
            "Trump suit: ♣", whistTrumpModel.getGameState());

    whistTrumpModel.play(4, 0);
    whistTrumpModel.play(5, 0);
    whistTrumpModel.play(0, 0);
    whistTrumpModel.play(1, 0);
    whistTrumpModel.play(2, 0);
    whistTrumpModel.play(3, 0);
    assertTrue(whistTrumpModel.getGameState().contains("Turn: Player 4"));

    whistTrumpModel.play(3, 0);
    whistTrumpModel.play(4, 0);
    whistTrumpModel.play(5, 0);
    whistTrumpModel.play(0, 0);
    whistTrumpModel.play(1, 0);
    whistTrumpModel.play(2, 0);
    System.out.print(whistTrumpModel.getGameState());

    // left with four players have cards

    whistTrumpModel.play(0, 0);
    whistTrumpModel.play(1, 0);
    whistTrumpModel.play(2, 0);
    whistTrumpModel.play(3, 0);
    assertEquals("Number of players: 6\n" +
            "Player 1:\n" +
            "Player 2:\n" +
            "Player 3:\n" +
            "Player 4:\n" +
            "Player 5:\n" +
            "Player 6:\n" +
            "Player 1: 3 hands won\n" +
            "Player 2: 1 hands won\n" +
            "Player 3: 1 hands won\n" +
            "Player 4: 1 hands won\n" +
            "Player 5: 1 hands won\n" +
            "Player 6: 1 hands won\n" +
            "Game over. Player 1 won.", whistTrumpModel.getGameState());

  }



  /*
  test the exception could be thrown if input is incorrect
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestCreator_Execption() {

    WhistModelCreator creator = new WhistModelCreator();
    CardGameModel whistModel = creator.create(WhistModelCreator.ModelType.NOTRUMP);
    CardGameModel whistTrumpModel = creator.create(WhistModelCreator.ModelType.TRUMP);


    whistModel.startPlay(3, whistModel.getDeck());
    whistModel.startPlay(0, whistModel.getDeck());  // invalid input number of players
    List<StandardDeckCard> deck = whistModel.getDeck();  // invalid input deck
    deck.remove(2);
    whistModel.startPlay(2, deck);


    whistTrumpModel.startPlay(-1, whistTrumpModel.getDeck());// invalid input number of players
    List<StandardDeckCard> anDeck = whistTrumpModel.getDeck();
    deck.set(4, Aclub); // duplicate cards
    whistTrumpModel.startPlay(7, anDeck);

    whistTrumpModel.startPlay(2, whistTrumpModel.getDeck());
    whistTrumpModel.play(10, 9); // invalid player index
    whistTrumpModel.play(1, 200); // invalid card index

    whistTrumpModel.play(0, 0);
    whistTrumpModel.play(1, 10); // wrong suit
    whistTrumpModel.play(1, 0);  // not the player's turn

  }

  /**
   * tests comparator
   */
  @Test
  public void testComparator() {
    cs3500.hw03.CardGameModel model = new WhistTrumpModel();

    CardComparator comp = new CardComparator();
    assertTrue(comp.compare(this.Aclub, this.AHeart) < 0);
    assertTrue(comp.compare(this.Aclub, this.KDiamond) < 0);
    assertTrue(comp.compare(this.TwoDiamond, this.AHeart) < 0);
    assertEquals(-2, comp.compare(this.Aclub, this.AHeart));
    assertTrue(comp.compare(this.TwoDiamond, this.AHeart) < 0);
    assertTrue(comp.compare(this.TwoDiamond, this.Tclub) > 0);
    assertTrue(comp.compare(this.TwoDiamond, this.ThDiamond) > 0);
  }

  /**
   * tests comparator
   */
  @Test
  public void testComparator2() {
    // tests the notrump version
    cs3500.hw03.CardGameModel model = new WhistTrumpModel();
    List<StandardDeckCard> deck =
            testComparatorHelper(model.getDeck(), new CardComparator());
    model.startPlay(3, deck);

    List<StandardDeckCard> adeck = model.getDeck();
    StandardDeckCard card = adeck.remove(0);

    adeck.add(card);

    Collections.sort(adeck, new CardComparator());
    assertEquals(adeck, deck);

    // tests the trump version

    cs3500.hw03.CardGameModel NoTrump_model = new WhistTrumpModel();

    List<StandardDeckCard> deck2 =
            testComparatorHelper(NoTrump_model.getDeck(), new CardComparator());
    NoTrump_model.startPlay(6, deck2);

    List<StandardDeckCard> adeck2 = NoTrump_model.getDeck();

    StandardDeckCard card2 = adeck2.get(7);

    int indexOfAHeart = adeck2.indexOf(AHeart);
    adeck2.set(7, AHeart);
    adeck2.set(indexOfAHeart, card2);

    Collections.sort(adeck2, new CardComparator());
    assertEquals(adeck2, deck2);

  }

  /**
   * Helper method for testing the comparator
   * @param list
   * @param comparator
   * @param <S>
   * @param <T>
   * @return a sorted list using the given comparator
   */
  private <S, T extends Comparator<S>> List<S> testComparatorHelper(List<S> list, T comparator) {
    List<S> temp = new ArrayList<S>();
    for (S item : list) {
      temp.add(item);
    }
    Collections.sort(temp, comparator);
    return temp;
  }


}
