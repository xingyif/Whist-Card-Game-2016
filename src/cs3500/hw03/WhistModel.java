package cs3500.hw03;

import java.util.ArrayList;
import java.util.List;

import cs3500.hw02.GenericStandardDeckGame;
import cs3500.hw02.Player;
import cs3500.hw02.StandardDeckCard;
import cs3500.hw02.Suit;

/**
 * represents a whist game
 */
public class WhistModel extends GenericStandardDeckGame implements CardGameModel<StandardDeckCard> {

  // represents the list of player of the game
  protected List<WhistPlayer> listOfWhistPlayer;
  // represents who's turn it is
  protected int whosTurn;
  // represents the current hand
  protected List<StandardDeckCard> currentHand;

  // represents the current game state
  protected GameStatus gameStatus;


  // the zero constructor
  public WhistModel() {
    super();
    this.listOfWhistPlayer = new ArrayList<WhistPlayer>();
    this.whosTurn = 0;
    this.currentHand = new ArrayList<StandardDeckCard>();
    this.gameStatus = gameStatus.Playing;
  }

  // convenience constructor for tests
  WhistModel(List<WhistPlayer> ListOfWhistPlayer, int WhosTurn,
             List<StandardDeckCard> currentHand, GameStatus GameStatus){
    super();
    this.listOfWhistPlayer = ListOfWhistPlayer;
    this.whosTurn = WhosTurn;
    this.currentHand = currentHand;
    this.gameStatus = GameStatus;
  }


  /**
   * Gets the current game state
   * @return a String that contains the entire state of the game as follows,
   *  one on each line
  Number of players: N (printed as a normal decimal number)
  Player 1: cards in sorted order (printed as a comma-separated list)
  Player 2: cards in sorted order (printed as a comma-separated list)
  ...
  Player N: cards in sorted order (printed as a comma-separated list)
  Player 1: X hands won (where X is the number of hands won)
  Player 2: Y hands won (where Y is the number of hands won)
  ...
  Player N: Z hands won (where Z is the number of hands won)
  Special message
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
      specialMessage = "Turn: Player " + String.valueOf(this.whosTurn + 1);
    }
    else {
      specialMessage = "Game over. " + "Player " + this.getWinner()
              + " won.";
    }

    String result = theFirstPart + theSecondPart + specialMessage;



    return result;

  }

  /**
   * helper for getGameState
   * find the winner of the game
   * @return the winner(s) index as a string for this game
   */
  protected String getWinner() {

      String winner = "";
      WhistPlayer WinnerSoFar = this.listOfWhistPlayer.get(0);
      winner = String.valueOf(1);
      for (int i = 0; i < this.listOfWhistPlayer.size() - 1; i = i + 1) {
        int nextPlayer = i + 1;
        // when the next winner won more hands than the current one
        if (WinnerSoFar.getHowManyHandsWon()
                < this.listOfWhistPlayer.get(nextPlayer).getHowManyHandsWon()) {
          // the player won the most hand
          WinnerSoFar = this.listOfWhistPlayer.get(nextPlayer);
          // the index of the winning player
          int winnerPlayerIndex = this.listOfWhistPlayer.indexOf(WinnerSoFar);
          winner = String.valueOf(winnerPlayerIndex + 1);
        }
        // when there are more than one winner for the game
        else if (WinnerSoFar.getHowManyHandsWon()
                == this.listOfWhistPlayer.get(nextPlayer).getHowManyHandsWon()) {
          winner = winner + ", Player " + String.valueOf(nextPlayer + 1);
        }
      }
      return winner;
  }

  /**
   * plays the cards at cardIdx from playerNo
   *
   * add the card to the current hand
   *
   * if the player is the first player in the current hand,
   * then the card determine this hand's suit
   *
   * if the player is the last player, then determine who won the hand
   *
   * update the tally of hands for the player
   *
   * determines who play next
   *
   * @param playerNo the player who has the card at cardIdx
   * @param cardIdx the card which the player plays
   */
  @Override
  public void play(int playerNo, int cardIdx) {

    // the current (valid) suit of the current hand
    Suit currentSuit;

    // the suit of the player's card
    Suit playerSuit;

    // the current card at the given index of the given player
    StandardDeckCard currentCard;


    // checks if it is the player's turn
    if (playerNo != this.whosTurn) {
      throw new IllegalArgumentException("Invalid Player");
    }

    // checks if the card index is valid
    else if (cardIdx >= this.listOfWhistPlayer.get(whosTurn).playerCards.size()) {
      throw new IllegalArgumentException("Card does not Exist");
    }

    else {
      currentCard = this.listOfWhistPlayer.get(playerNo).playerCards.get(cardIdx);
      //if the player is the first player in the current hand,
      // then the card determine this hand's suit
      if (this.currentHand.size() == 0) {

        // adds the card to the current hand
        this.currentHand.add(currentCard);

        // set the suit of the current hand
        currentSuit = this.currentHand.get(0).suit;

        // remove the card from the player's cards
        this.listOfWhistPlayer.get(playerNo).playerCards.remove(cardIdx);

        // determine who will play next
        this.updateWhosTurn();
      }
      // if the player is not the first player in the current hand
      else {
        // the current suit of the hand
        currentSuit = this.currentHand.get(0).suit;
        // the suit of the player's card
        playerSuit = this.listOfWhistPlayer.get(playerNo).playerCards.get(cardIdx).suit;

        // checks if it is the wrong suit
        if (currentSuit != playerSuit) {

          // checks if the player has a card with a valid suit
          boolean result = false;
          for (StandardDeckCard e : this.listOfWhistPlayer.get(playerNo).playerCards) {
            if (e.suit == currentSuit) {
              result = true;
            }
          }

          // when the player has a card with valid suit, but didn't play the card
          // don't allow the player play other cards with an invalid suit
          if (result) {
            throw new IllegalArgumentException("Invalid Suit");
          }
          // when the player has no card matches the current suit
          // let player discards a card by playing any other card
          else {
            // add the card to the current hand
            this.currentHand.add(currentCard);
            // remove the card from the player's cards
            this.listOfWhistPlayer.get(playerNo).playerCards.remove(cardIdx);

          }
        }
        // valid playerNo and valid cardIdx and suit
        else {
          // adds the card to the current hand
          this.currentHand.add(currentCard);

          // remove the card from the player's cards
          this.listOfWhistPlayer.get(playerNo).playerCards.remove(cardIdx);
          // determine who will play next for this next turn
        }
        // if the player is the last player, then determine who won the hand
        if (this.currentHand.size() == this.listOfWhistPlayer.size()) {
          // determine who wins the hand
          int handWinnerIndex = this.getHandWinner(playerNo, currentSuit);
          // updates the tally of hands for the player
          this.listOfWhistPlayer.get(handWinnerIndex).updateTally();
          // the next player is the current winner of the hand
          this.whosTurn = handWinnerIndex;
          // initialize the current hand to 0
          this.currentHand.clear();
          // if the game is ended, find the winner of the game
          if (this.isGameOver()) {
            // update the game state
            this.gameStatus = gameStatus.Won;
          }
          // if the player doesn't have any card, then find the next player who has a card
        if (this.listOfWhistPlayer.get(this.whosTurn).playerCards.size() == 0) {
            this.updateWhosTurn();
         }
        }
        else {
          this.updateWhosTurn();
        }
      }
    }
  }

  /**
   * determine who's turn to play next
   */
  protected void updateWhosTurn() {
    // increment whosTurn
    this.whosTurn = (this.whosTurn + 1) % this.listOfWhistPlayer.size();
    // if the player who suppose to play doesn't have any card,
    // and the game is still running, then find a player has card
    while ((this.listOfWhistPlayer.get(this.whosTurn).playerCards.size() == 0)
          && !this.isGameOver()) {
        this.whosTurn = (this.whosTurn + 1) % this.listOfWhistPlayer.size();
    }
  }


  /**
   * determines who win the current suit
   * @param playerNo the index of the last player of this current hand
   * @param currentSuit the current suit of the hand
   * @return the player who plays the largest card value
   */
  protected int getHandWinner(int playerNo, Suit currentSuit) {


    // the index of first player who plays the first card for the current hand
    int firstPlayerIndex = (playerNo - (this.listOfWhistPlayer.size() - 1))
            % this.listOfWhistPlayer.size();
    if (firstPlayerIndex < 0) {
      firstPlayerIndex += this.listOfWhistPlayer.size();
    }
    // the index of the card that has the biggest value in the current hand
    int biggestCardIndex = 0;
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
    // gets the player who plays the biggest card
    int handWinner = (firstPlayerIndex + biggestCardIndex) % this.currentHand.size();

    return handWinner;
  }

  /**
   * determines whose turn to play
   * @return the index of the player who has the turn to play
   */
  @Override
  public int getCurrentPlayer() {
    return this.whosTurn;
  }

  /**
   * determines if the game is over
   *
   * the game is ended
   * when there is only one player left with cards.
   * Those remaining cards are discarded, i.e. they are not counted as a hand.
   *
   * @return true if the game is over, vice versa
   */
  @Override
  public boolean isGameOver() {

      // keeps track of how many players has run out of cards
    int PlayerWithoutCards = 0;
    // check how many player have no cards left
    for (WhistPlayer p : this.listOfWhistPlayer) {
      if (p.playerCards.size() == 0) {
        PlayerWithoutCards += 1;
      }
    }
    // if only 1 player has cards left, then the game is ended
    if ((PlayerWithoutCards >= this.listOfWhistPlayer.size() - 1)
            && (this.currentHand.size() == 52 % this.listOfWhistPlayer.size())) {
      return true;
    }

    else if ((PlayerWithoutCards >= this.listOfWhistPlayer.size() - 1)
            && (this.currentHand.size() == 0)) {
      return true;
    }
    return false;
  }

  @Override
  // distribute these cards in the specified
  // order among the players in round-robin fashion
  public void startPlay(int numPlayers, List<StandardDeckCard> alist) {
    if (numPlayers <= 1) {
      throw new IllegalArgumentException("not enough player");
    }
    else if (!this.isValidDeck(alist))  {
      throw new IllegalArgumentException("invalid deck");
    }
    // valid deck
    else {
      for (int i = 0; i < numPlayers; i = i + 1) {  // for each player
        WhistPlayer OnePlayer = new WhistPlayer(new ArrayList<>(), 0);
        for (int n = 0; n + i < alist.size(); n = n + numPlayers) {
          OnePlayer.playerCards.add(alist.get(n + i));
        }
        listOfWhistPlayer.add(OnePlayer);
      }
    }
  }

}
