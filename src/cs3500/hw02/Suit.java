package cs3500.hw02;

/**
 * represents the card suit
 * clubs = ♣, diamonds = ♦, hearts = ♥ and spades = ♠
 */
public enum Suit {
  Club, Diamond, Heart, Spade;


// gets the symbol of each suit
  public String getSymbol() {
    String symbol;
    switch (this) {
      case Club:
        symbol = "♣";
      break;
      case Diamond:
        symbol = "♦";
      break;
      case Heart:
        symbol = "♥";
      break;
      default:
        symbol = "♠";
      break;
    }
    return symbol;
  }
}