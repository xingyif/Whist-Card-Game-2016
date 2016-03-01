package cs3500.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * tests for {@link GenericStandardDeckGame}s.
 */
public class TestGenericStandardDeckGame {

  StandardDeckCard Aclub = new StandardDeckCard(CardValue.Ace, Suit.Club);
  StandardDeckCard Kclub = new StandardDeckCard(CardValue.King, Suit.Club);
  StandardDeckCard Qclub = new StandardDeckCard(CardValue.Queen, Suit.Club);
  StandardDeckCard Jclub = new StandardDeckCard(CardValue.Jack, Suit.Club);
  StandardDeckCard Tclub = new StandardDeckCard(CardValue.Ten, Suit.Club);
  StandardDeckCard Twoclub = new StandardDeckCard(CardValue.Two, Suit.Club);
  StandardDeckCard Thclub = new StandardDeckCard(CardValue.Three, Suit.Club);
  StandardDeckCard Fclub = new StandardDeckCard(CardValue.Four, Suit.Club);

  StandardDeckCard ADiamond = new StandardDeckCard(CardValue.Ace,
          Suit.Diamond);
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
  StandardDeckCard TwoHeart = new StandardDeckCard(CardValue.Two, Suit.Heart);
  StandardDeckCard ThHeart = new StandardDeckCard(CardValue.Three, Suit.Heart);

  StandardDeckCard ASpade = new StandardDeckCard(CardValue.Ace, Suit.Spade);
  StandardDeckCard KSpade = new StandardDeckCard(CardValue.King, Suit.Spade);
  StandardDeckCard QSpade = new StandardDeckCard(CardValue.Queen, Suit.Spade);
  StandardDeckCard TwoSpade = new StandardDeckCard(CardValue.Two, Suit.Spade);
  StandardDeckCard ThSpade = new StandardDeckCard(CardValue.Three, Suit.Spade);
  StandardDeckCard FSpade = new StandardDeckCard(CardValue.Four, Suit.Spade);


  List<Player> Players = new ArrayList<>();
  List<StandardDeckCard> PlayerCards = new ArrayList<>();
  List<StandardDeckCard> PlayerCards1 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards3 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards52 = new ArrayList<>();
  List<StandardDeckCard> PlayerCards53 = new ArrayList<>();


  GenericStandardDeckGame game1 = new GenericStandardDeckGame(Players);
  GenericStandardDeckGame game2 = new GenericStandardDeckGame(new ArrayList<>());

  List<StandardDeckCard> validDeck = this.game1.getDeck();


  /**
   * tests for getDeck()
   */
  @Test
  public void TestgetDeck() {
    assertEquals(52, game1.getDeck().size());
    assertEquals(Aclub.toString(), game1.getDeck().get(0).toString());
    assertEquals(Kclub.toString(), game1.getDeck().get(1).toString());
    assertEquals(Qclub.toString(), game1.getDeck().get(2).toString());
    assertEquals(Jclub.toString(), game1.getDeck().get(3).toString());
    assertEquals(Tclub.toString(), game1.getDeck().get(4).toString());
    assertEquals(Twoclub.toString(), game1.getDeck().get(12).toString());
    assertEquals(Thclub.toString(), game1.getDeck().get(11).toString());
    assertEquals(Fclub.toString(), game1.getDeck().get(10).toString());

    assertEquals(ADiamond.toString(), game1.getDeck().get(13).toString());
    assertEquals(KDiamond.toString(), game1.getDeck().get(14).toString());
    assertEquals(QDiamond.toString(), game1.getDeck().get(15).toString());
    assertEquals(TwoDiamond.toString(), game1.getDeck().get(25).toString());
    assertEquals(ThDiamond.toString(), game1.getDeck().get(24).toString());

    assertEquals(AHeart.toString(), game1.getDeck().get(26).toString());
    assertEquals(KHeart.toString(), game1.getDeck().get(27).toString());
    assertEquals(QHeart.toString(), game1.getDeck().get(28).toString());
    assertEquals(TwoHeart.toString(), game1.getDeck().get(38).toString());
    assertEquals(ThHeart.toString(), game1.getDeck().get(37).toString());

    assertEquals(ASpade.toString(), game1.getDeck().get(39).toString());
    assertEquals(KSpade.toString(), game1.getDeck().get(40).toString());
    assertEquals(QSpade.toString(), game1.getDeck().get(41).toString());
    assertEquals(ThSpade.toString(), game1.getDeck().get(50).toString());
    assertEquals(TwoSpade.toString(), game1.getDeck().get(51).toString());

    // clubs = ♣, diamonds = ♦, hearts = ♥ and spades = ♠
  }

  List<StandardDeckCard> invalidDeck = new ArrayList();
  List<StandardDeckCard> invalidDeck2 = game1.getDeck();
  List<StandardDeckCard> invalidDeck3 = game1.getDeck();
  List<StandardDeckCard> invalidDeck4 = game1.getDeck();

  // setup the initial conditions of deck of cards
  public void initCondition() {

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


  // tests the method isValidDeck()
  @Test
  public void TestIsValidDeck() {
    this.initCondition();
    assertEquals(true, game1.isValidDeck(validDeck));
    assertEquals(true, game1.isValidDeck(game1.getDeck()));
    assertEquals(false, game1.isValidDeck(invalidDeck));
    assertEquals(false, game1.isValidDeck(invalidDeck2));
    assertEquals(false, game1.isValidDeck(invalidDeck3));
    assertEquals(false, game1.isValidDeck(invalidDeck4));
  }


  // setup the initial conditions for list of 2 players
  public void initCondition2() {
    // two players and a deck
    this.game1.startPlay(2, game1.getDeck());

    // gets the list of cards the first player has
    PlayerCards1 = game1.ListOfPlayer.get(0).playerCards;

    // gets the list of cards the second player has
    PlayerCards = game1.ListOfPlayer.get(1).playerCards;

  }

  // tests the method with no exceptions
  @Test
  public void TestStartPlay() {
    //setup the initial conditions
    this.initCondition2();

    // two players and a deck
    // checks the size of list of players, should be 2
    assertEquals(2, game1.ListOfPlayer.size());
    // checks the size of list of a player's cards, should be 25
    assertEquals(26, PlayerCards.size());
    assertEquals(26, PlayerCards1.size());

    // checks if the first player has the right card from the deck
    assertEquals(Aclub, PlayerCards1.get(0));
    assertEquals(Qclub, PlayerCards1.get(1));
    assertEquals(Twoclub, PlayerCards1.get(6));
    assertEquals(ThDiamond, PlayerCards1.get(12));
    assertEquals(AHeart, PlayerCards1.get(13));
    assertEquals(ThSpade, PlayerCards1.get(25));

    // checks if the second player has the right card from the deck
    assertEquals(Kclub, PlayerCards.get(0));
    assertEquals(Jclub, PlayerCards.get(1));
    assertEquals(ADiamond, PlayerCards.get(6));
    assertEquals(QDiamond, PlayerCards.get(7));
    assertEquals(ThHeart, PlayerCards.get(18));
    assertEquals(TwoSpade, PlayerCards.get(25));
  }

  // setup the initial conditions for list of 3 players
  public void initCondition3() {

    // two players and a deck
    this.game1.startPlay(3, game1.getDeck());

    // gets the list of cards the first player has
    PlayerCards1 = game1.ListOfPlayer.get(0).playerCards;

    // gets the list of cards the second player has
    PlayerCards = game1.ListOfPlayer.get(1).playerCards;

    // gets the list of cards the third player has
    PlayerCards3 = game1.ListOfPlayer.get(2).playerCards;
  }

  // tests the method with no exceptions
  @Test
  public void TestStartPlay3Players() {

    // setup the initial conditions
    this.initCondition3();

    // three players and a deck
    // checks the size of list of players, should be 3
    assertEquals(3, game1.ListOfPlayer.size());
    // checks the size of list of a player's cards
    assertEquals(18, PlayerCards1.size());  // the first player
    assertEquals(17, PlayerCards.size());   // the second player
    assertEquals(17, PlayerCards3.size());   // the third player


    // checks if the first player has the right card from the deck
    assertEquals(Aclub, PlayerCards1.get(0));
    assertEquals(Jclub, PlayerCards1.get(1));
    assertEquals(Twoclub, PlayerCards1.get(4));
    assertEquals(ThDiamond, PlayerCards1.get(8));
    assertEquals(KHeart, PlayerCards1.get(9));
    assertEquals(ASpade, PlayerCards1.get(13));
    assertEquals(TwoSpade, PlayerCards1.get(17));

    // checks if the second player has the right card from the deck
    assertEquals(Kclub, PlayerCards.get(0));
    assertEquals(Fclub, PlayerCards.get(3));
    assertEquals(ADiamond, PlayerCards.get(4));
    assertEquals(QHeart, PlayerCards.get(9));
    assertEquals(KSpade, PlayerCards.get(13));
    assertEquals(FSpade, PlayerCards.get(16));

    // checks if the third player has the right card from the deck
    assertEquals(Qclub, PlayerCards3.get(0));
    assertEquals(Thclub, PlayerCards3.get(3));
    assertEquals(KDiamond, PlayerCards3.get(4));
    assertEquals(AHeart, PlayerCards3.get(8));
    assertEquals(QSpade, PlayerCards3.get(13));
    assertEquals(ThSpade, PlayerCards3.get(16));


  }

  // setup the initial conditions for list of 53 players
  public void initCondition53() {
    // 53 players and a deck
    this.game1.startPlay(53, game1.getDeck());

    // gets the list of cards the first player has
    PlayerCards1 = game1.ListOfPlayer.get(0).playerCards;

    // gets the list of cards the second player has
    PlayerCards = game1.ListOfPlayer.get(1).playerCards;

    // gets the list of cards the third player has
    PlayerCards3 = game1.ListOfPlayer.get(2).playerCards;

    // gets the list of cards the 52 player has
    PlayerCards52 = game1.ListOfPlayer.get(51).playerCards;

    // gets the list of cards the 53 player has
    PlayerCards53 = game1.ListOfPlayer.get(52).playerCards;

  }

  // test the method startPlay with 53 player
  @Test
  public void TestManyPlayers() {
    // setup the initial conditions
    this.initCondition53();
    // 53 players and a deck
    // checks the size of list of players, should be 53
    assertEquals(53, game1.ListOfPlayer.size());
    // checks the size of list of a player's cards
    assertEquals(1, PlayerCards1.size());  // the first player
    assertEquals(1, PlayerCards.size());   // the second player
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
    game1.startPlay(1, validDeck);
  }

  // not enough player, 0 player
  @Test(expected = IllegalArgumentException.class)
  public void NotEnoughPlayerException2() {
    game1.startPlay(0, validDeck);
  }

  // not enough player, -1 player
  @Test(expected = IllegalArgumentException.class)
  public void NotEnoughPlayerException3() {
    game1.startPlay(-1, validDeck);
  }


  /**
   * tests the method startPlay exceptions
   */
  // pass in invalid deck with only two cards
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException() {
    this.initCondition();
    game1.startPlay(2, invalidDeck);
  }

  // pass in invalid deck with a duplicate card in a deck
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException1() {
    this.initCondition();
    game1.startPlay(3, invalidDeck2);
  }

  // pass in invalid deck with not enough cards, 50 cards
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException2() {
    this.initCondition();
    game1.startPlay(5, invalidDeck3);
  }

  // pass in invalid deck with more than 52 cards
  @Test(expected = IllegalArgumentException.class)
  public void InvalidDeckException3() {
    this.initCondition();
    game1.startPlay(52, invalidDeck4);
  }

  // setup the initial condition for testing the game state
  public void initConditionGameState() {
    // three players and a deck
    this.game1.startPlay(3, game1.getDeck());
    // two player and a deck
    this.game2.startPlay(2, game1.getDeck());
  }


  String gameState1 = "Number of players: 3" + "\n"
          + "Player 1: A♣, J♣, 8♣, 5♣, 2♣, Q♦, 9♦, 6♦, 3♦, K♥," +
                      " 10♥, 7♥, 4♥, A♠, J♠, 8♠, 5♠, 2♠" + "\n"
          + "Player 2: K♣, 10♣, 7♣, 4♣, A♦, J♦, 8♦," +
                      " 5♦, 2♦, Q♥, 9♥, 6♥, 3♥, K♠, 10♠, 7♠, 4♠" + "\n"
          + "Player 3: Q♣, 9♣, 6♣, 3♣, K♦, 10♦, 7♦, 4♦," +
                      " A♥, J♥, 8♥, 5♥, 2♥, Q♠, 9♠, 6♠, 3♠";

  String gameState2 = "Number of players: 2" + "\n"
          + "Player 1: A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦," +
          " 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠" + "\n"
          + "Player 2: K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦," +
          " K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠";




  /**
   * tests the method getGameState
   */
  @Test
  public void TestGetGameState() {
    // setup the initial condition for testing the game state
    this.initConditionGameState();
    assertEquals(gameState1, this.game1.getGameState());
    assertEquals(gameState2, this.game2.getGameState());
  }


  /**
   * tests the method getCardType
   */
  @Test
  public void TestGetCardType() {
    assertEquals("A", Aclub.cardvalue.getCardType());
    assertEquals("K", KHeart.cardvalue.getCardType());
    assertEquals("2", TwoDiamond.cardvalue.getCardType());
    assertEquals("4", FSpade.cardvalue.getCardType());
  }


  /**
   * tests the method getCardValue
   */
  @Test
  public void TestGetCardValue() {
    assertEquals(14, Aclub.cardvalue.getCardValue());
    assertEquals(13, KHeart.cardvalue.getCardValue());
    assertEquals(4, FSpade.cardvalue.getCardValue());
    assertEquals(2, TwoDiamond.cardvalue.getCardValue());
  }

  /**
   * tests the getSymbol method in cs3500.hw02.Suit class
   */
  @Test
  public void TestGetSymbol() {
    assertEquals("♣", Aclub.suit.getSymbol());
    assertEquals("♦", KDiamond.suit.getSymbol());
    assertEquals("♥", TwoHeart.suit.getSymbol());
    assertEquals("♠", FSpade.suit.getSymbol());
  }


  // tests the method toString
  @Test
  public void TestToString() {
    assertEquals("A♣", Aclub.toString());
    assertEquals("K♦", KDiamond.toString());
    assertEquals("2♥", TwoHeart.toString());
    assertEquals("4♠", FSpade.toString());
  }

  // tests the method equals
  @Test
  public void TestEquals() {
    assertEquals(true, Aclub.equals(Aclub));
    assertEquals(false, Aclub.equals(Kclub));
    assertEquals(false, QDiamond.equals(Kclub));
    assertEquals(false, ASpade.equals(KHeart));
    assertEquals(false, ASpade.equals("A♣"));
  }

  // tests the method hashCode()
  @Test
  public void TestHashCode() {
    assertEquals(Aclub.hashCode(), Aclub.hashCode());
    assertEquals(ADiamond.hashCode(), ADiamond.hashCode());
    assertEquals(Kclub.hashCode(), Kclub.hashCode());
    assertEquals(KDiamond.hashCode(), KDiamond.hashCode());
    assertEquals(TwoHeart.hashCode(), TwoHeart.hashCode());
    assertEquals(FSpade.hashCode(), FSpade.hashCode());
  }

  /**
   * tests the method compareTo
   */
  @Test
  public void TestCompareTo() {
    assertEquals(-1, ADiamond.compareTo(KDiamond));
    assertEquals(1, Kclub.compareTo(Aclub));
    assertEquals(0, ASpade.compareTo(ASpade));
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
    // setup the initial condition
    this.initCondition2();

    // print the list of cards the first player has
    assertEquals(player1cards, game1.ListOfPlayer.get(0).printCards());
    // print the list of cards the second player has
    assertEquals(player2cards, game1.ListOfPlayer.get(1).printCards());
 }


}