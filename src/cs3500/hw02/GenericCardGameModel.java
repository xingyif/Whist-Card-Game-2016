package cs3500.hw02; /**
 * this represents an interface cs3500.hw02.GenericCardGameModel
 * All these games have some common aspects. They can be played by many
 * players, and they use an entire deck of cards.
 * The deck of cards are distributed among all the players,
 * so that each player has a subset of cards at any time in the game.
 * Players give up their cards as the game progresses,
 * and the game ends when all players have run out of cards.
 */

import java.util.List;
public interface GenericCardGameModel<K> {

  /**
   *
   * @return an entire deck of cards as a List<K>
   */
  List<K> getDeck();

  /**distribute these cards in the specified order among the players in round-robin fashion
   * This method should throw an IllegalArgumentException in two cases:
   if the number of players is not greater than 1.
   if the deck passed to it is invalid. This is dependent on the implementation (see below).
   * @param numPlayers
   * @param alist
   */
  void startPlay(int numPlayers, List<K> alist);

  /**
   * @return a String that contains the entire state of the game
   */
  String getGameState();

}
