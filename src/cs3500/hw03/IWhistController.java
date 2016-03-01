package cs3500.hw03;

/**
 * represents the controller for the whist game
 */
public interface IWhistController {

  /**
   * starts the provided game with a given number of players
   * return only when the game has ended
   * @param game the given game to start
   * @param numPlayers the given number of players in the game
   */
  <K> void startGame(CardGameModel<K> game, int numPlayers);
}
