package cs3500.hw02;

/**
 * represents the card value
 */
public enum CardValue {

  Ace("A", 14), King("K", 13), Queen("Q", 12), Jack("J", 11),
  Ten("10", 10), Nine("9", 9), Eight("8", 8), Seven("7", 7),
  Six("6", 6), Five("5", 5), Four("4", 4), Three("3", 3), Two("2", 2);
  public final String type;
  public final int value;

  CardValue(String type, int value) {
    this.type = type;
    this.value = value;
  }

  // gets the type of the card
  public String getCardType() {
    return this.type;
  }
  // gets the value of a card
  public int getCardValue() {
    return this.value;
  }



}
