package cs3500.hw03;

import java.util.Collections;
import java.util.List;

import cs3500.hw02.Player;
import cs3500.hw02.StandardDeckCard;

/**
 * represents a whist player
 */
public class WhistPlayer extends Player{

  // keeps track of how many hands a player has won
  private int howManyHandsWon;

  // the constructor
  public WhistPlayer(List<StandardDeckCard> PlayerCards, int howManyHandsWon) {
    super(PlayerCards);
    this.howManyHandsWon = howManyHandsWon;
  }

  // updates the tally of the WhistPlayer
  public void updateTally() {
    this.howManyHandsWon += 1;
  }

  /**
   *
   * @return how many hands this player has won
   */
  public int getHowManyHandsWon() {
    return this.howManyHandsWon;
  }


  /**
   * prints out the list of cards this player has
   * and sorts the cards in order
   * and printed as a comma-separated list
   */
  @Override
  public String printCards() {
    String result = "";
    Collections.sort(this.playerCards);
    for (int i = 0; i < this.playerCards.size(); i++) {
      result += " " + this.playerCards.get(i).toString() + ",";
    }
    if (result.length() == 0) {
      return result;
    }
    else {
      return result.substring(0, result.length() - 1);
    }
  }

}




