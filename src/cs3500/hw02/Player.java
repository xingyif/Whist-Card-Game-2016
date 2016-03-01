package cs3500.hw02;

import java.util.Collections;
import java.util.List;

/**
 * represents a player
 */
public class Player {

  // represents how many cards a player has
  public List<StandardDeckCard> playerCards;

  // the constructor
  public Player(List<StandardDeckCard> PlayerCards) {
    this.playerCards = PlayerCards;
  }


  /**
   * prints out the list of cards this player has
   * and sorts the cards in order
   * and printed as a comma-separated list
    */
  public String printCards() {
    String result = "";
    Collections.sort(this.playerCards);
    for (int i = 0; i < this.playerCards.size(); i++) {
      result += " " + this.playerCards.get(i).toString() + ",";
    }
      return result.substring(0, result.length() - 1);
  }
}
