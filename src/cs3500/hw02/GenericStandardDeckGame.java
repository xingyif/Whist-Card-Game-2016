package cs3500.hw02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a generic standard deck game using cs3500.hw02.StandardDeckCard
 */
public class GenericStandardDeckGame implements GenericCardGameModel<StandardDeckCard> {
  // represents the number of players who are currently playing the game
  public List<Player> ListOfPlayer;


  // zero constructor
  public GenericStandardDeckGame() {
    this.ListOfPlayer = new ArrayList<>();
  }

  // constructor
  GenericStandardDeckGame(List<Player> ListOfPlayer) {
    this.ListOfPlayer = ListOfPlayer;
  }


  /**
   * an entire deck of card is 52 cards with 2, ..., jack, queen, king,
   * ace in each of clubs, diamonds, hearts and spades)
   * as a List of card objects
   * clubs = ♣, diamonds = ♦, hearts = ♥ and spades = ♠
   * @returns an entire deck of cards as a List<cs3500.hw02.StandardDeckCard>
   */

  public List<StandardDeckCard> getDeck() {
    List<StandardDeckCard> finalDeck = new ArrayList<StandardDeckCard>(52);

    CardValue cardvalue[] = CardValue.values();
      // value from A, K, Q, J, ... to 2 club
      for (int i = 0; i <= 12; i = i + 1) {

        finalDeck.add(new StandardDeckCard(cardvalue[i], Suit.Club));
      }
      // value from A, K, Q, J, ... to 2  diamonds
    for (int i = 0; i <= 12; i = i + 1) {
      finalDeck.add(new StandardDeckCard(cardvalue[i], Suit.Diamond));
    }
      // value from A, K, Q, J, ... to 2  hearts
    for (int i = 0; i <= 12; i = i + 1) {
      finalDeck.add(new StandardDeckCard(cardvalue[i], Suit.Heart));
    }
      // value from A, K, Q, J, ... to 2 spades
    for (int i = 0; i <= 12; i = i + 1) {
      finalDeck.add(new StandardDeckCard(cardvalue[i], Suit.Spade));
    }

    return finalDeck;


  }

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
        Player onePlayer = new Player(new ArrayList<StandardDeckCard>());
        for (int n = 0; n + i < alist.size(); n = n + numPlayers) {
          onePlayer.playerCards.add(alist.get(n + i));
        }
        this.ListOfPlayer.add(onePlayer);
      }
    }
  }

  /**
   * checks if the given deck is a valid deck
   * A deck is invalid if it does not have 52 cards,
   * or if there are duplicate cards
   * or if there are invalid cards (invalid suit or invalid number)
   * however, the deck cannot contain invalid card
   * since the enum class takes care of the card value and card type
   * @param alist
   * @return a boolean determines whether the deck is valid
   */
  protected boolean isValidDeck(List<StandardDeckCard> alist) {

    if (alist.size() != 52) {
      return false;
    }
    // checks if it has duplicate cards
    else {
      Set deck = new HashSet<StandardDeckCard>(alist);

      return (deck.size() == 52);
    }
  }

  /**
   * Gets the game state
   * @return a String that contains the entire state of the game as follows,
   *  one on each line Number of players: N (printed as a normal decimal number)
    cs3500.hw02.Player 1: cards in sorted order (printed as a comma-separated list)
    cs3500.hw02.Player 2: cards in sorted order (printed as a comma-separated list)
    ...
    cs3500.hw02.Player N: cards in sorted order (printed as a comma-separated list)
   */

  @Override
  public String getGameState() {

    int numberOfPlayer = this.ListOfPlayer.size();
    String GameState = "Number of players: "
            + String.valueOf(this.ListOfPlayer.size()) + "\n";
    String players = "";
    for (int i = 0; i < numberOfPlayer; i = i + 1) {
      Player currentPlayer = this.ListOfPlayer.get(i);
      // prints out the current player and his cards
      players = players + "Player " + String.valueOf(i + 1)
              + ":" + currentPlayer.printCards() + "\n";
    }
    String finalString = GameState + players;
    return finalString.substring(0, finalString.length() - 1);
  }

}