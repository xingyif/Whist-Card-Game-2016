package cs3500.hw03;

import cs3500.hw02.GenericCardGameModel;
import cs3500.hw02.StandardDeckCard;

/**
 * represents a card game model
 */
public interface CardGameModel<K> extends GenericCardGameModel<K> {

  /**
   * places the cards at cardIdx from playerNo
   * @param playerNo the player who has the card at cardIdx
   * @param cardIdx the card which the player plays
   */
  void play(int playerNo, int cardIdx);

  /**
   * determines whose turn to play
   * @return the player who has the turn to play
   */
  int getCurrentPlayer();

  /**
   * determines if the game is over
   * @return true if the game is over, vice versa
   */
  boolean isGameOver();
}
