package cs3500.hw04;

import java.util.List;

import cs3500.hw02.Player;
import cs3500.hw02.StandardDeckCard;
import cs3500.hw02.Suit;
import cs3500.hw03.GameStatus;
import cs3500.hw03.WhistModel;
import cs3500.hw03.WhistPlayer;

/**
 * represents a Whist game with trump cards
 */
public class WhistTrumpModel extends WhistModel{

  // represents the current trump suit
  private Suit trumpSuit;

  // the zero constructor
  public WhistTrumpModel() {
    super();
    this.trumpSuit = null;
  }

  // convenience constructor for tests
  WhistTrumpModel(List<WhistPlayer> ListOfWhistPlayer, int WhosTurn,
             List<StandardDeckCard> currentHand, GameStatus GameStatus, Suit trumpSuit){

    this.listOfWhistPlayer = ListOfWhistPlayer;
    this.whosTurn = WhosTurn;
    this.currentHand = currentHand;
    this.gameStatus = GameStatus;
    this.trumpSuit = trumpSuit;
  }

  /**
   * starts the game, distributes the cards to each player in a round robin fashion
   * @param numPlayers
   * @param alist
   */
  @Override
  public void startPlay(int numPlayers, List<StandardDeckCard> alist) {
    // sets the trump suit of this game as the first card in the deck suit
    this.trumpSuit = alist.get(0).suit;

    super.startPlay(numPlayers, alist);

  }

  /**
   * add a "Trump Suit: X" at the end
   * @return the current game state
   */
  @Override
  public String getGameState() {

    int numberOfPlayer = this.listOfWhistPlayer.size();
    String GameState = "Number of players: "
            + String.valueOf(this.listOfWhistPlayer.size()) + "\n";
    String players = "";
    String players1 = "";


    for (int i = 0; i < numberOfPlayer; i = i + 1) {
      Player currentPlayer = this.listOfWhistPlayer.get(i);
      // prints out the current player and his cards
      players = players + "Player " + String.valueOf(i + 1)
              + ":" + currentPlayer.printCards() + "\n";
    }
    String finalString = GameState + players;
    String theFirstPart = finalString;
    //finalString.substring(0, finalString.length());


    for (int i = 0; i < numberOfPlayer; i = i + 1) {
      WhistPlayer currentPlayer = this.listOfWhistPlayer.get(i);
      // prints out the current player and his cards
      players1 = players1 + "Player " + String.valueOf(i + 1)
              + ": " + String.valueOf(currentPlayer.getHowManyHandsWon())
              + " hands won" + "\n";
    }
    String theSecondPart = players1.substring(0, players1.length());

    String specialMessage;
    if (!this.isGameOver()) {
      specialMessage = "Turn: Player " + String.valueOf(this.whosTurn + 1) + "\n"
                        + "Trump suit: " + this.trumpSuit.getSymbol();

    }
    else {
      specialMessage = "Game over. " + "Player " + this.getWinner()
              + " won.";
    }

    String result = theFirstPart + theSecondPart + specialMessage;
    return result;
  }


  /**
   * determines who win the current suit
   * if a card of the trump suit is played,
   * the values of the hand’s suit do not matter anymore for that hand.
   * @param playerNo the index of the last player of this current hand
   * @param currentSuit the current suit of the hand
   * @return the player who plays the largest card value
   */
  @Override
  public int getHandWinner(int playerNo, Suit currentSuit) {
    // stores the current hand size
    int currentHandSize = this.currentHand.size();
    // the index of first player who plays the first card for the current hand
    int firstPlayerIndex = (playerNo - (this.listOfWhistPlayer.size() - 1))
            % this.listOfWhistPlayer.size();
    if (firstPlayerIndex < 0) {
      firstPlayerIndex += this.listOfWhistPlayer.size();
    }
    // the index of the card that has the biggest value in the current hand
    int biggestCardIndex = 0;

    //accumulates to see if the hand has a trump suit card
    boolean hasTrumpSuit = false;
    // checks if the current suit has any trump card
    for (int i = 0; i < this.currentHand.size() - 1; i++) {
      StandardDeckCard currentCard = this.currentHand.get(i);

      if (currentCard.suit == this.trumpSuit) {
        hasTrumpSuit = true;
      }
    }

    // if the current hand has a card with trump suit
    if (hasTrumpSuit) {
      // gets the biggest value card index
      for (int i = 0; i < this.currentHand.size() - 1; i++) {
        StandardDeckCard currentCard = this.currentHand.get(i);
        StandardDeckCard nextCard = this.currentHand.get(i + 1);
        if (currentCard.suit == this.trumpSuit) {
          // gets the biggest value card of the trump suit if there is one
          if (currentCard.cardvalue.getCardValue() < nextCard.cardvalue.getCardValue()) {
            biggestCardIndex = i + 1;
          }
        }
      }
    }
    // the current hand doesn't have any trump suit
    else {
      // gets the biggest value card index
      for (int i = 0; i < this.currentHand.size() - 1; i++) {
        StandardDeckCard currentCard = this.currentHand.get(i);
        StandardDeckCard nextCard = this.currentHand.get(i + 1);
        // gets the biggest value card of the correct suit
        if (currentSuit == currentCard.suit) {
          if (currentCard.cardvalue.getCardValue() < nextCard.cardvalue.getCardValue()) {
            biggestCardIndex = i + 1;
          }
        }
      }
    }
    // gets the player who plays the card with the largest value
    int handWinner = (firstPlayerIndex + biggestCardIndex) % currentHandSize;
    return handWinner;
  }


/**
 * gets the trump suit of the current game
 */
  public Suit getTrumpSuit() {
    return this.trumpSuit;
  }


}
