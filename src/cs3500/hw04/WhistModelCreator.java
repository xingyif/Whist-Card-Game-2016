package cs3500.hw04;

import cs3500.hw02.StandardDeckCard;
import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;

/**
 * represents the white model creator
 */
public class WhistModelCreator {
  // represents the model type
  // with trump version, or no trump version
  public enum ModelType {
    TRUMP, NOTRUMP;
  }

  /**
   * produces a model according to teh given type
   * @param type the given type of a model (trump/notrump)
   * @return the model depends on the given type
   */
  public static CardGameModel<StandardDeckCard> create(ModelType type) {

    if (type == ModelType.NOTRUMP) {
      return new WhistModel();
    }
    else {
      return new WhistTrumpModel();
    }
  }


}
