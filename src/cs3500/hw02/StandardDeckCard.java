package cs3500.hw02;

/**
 * This class represents a single card from a standard deck
 */
public class StandardDeckCard implements Comparable<StandardDeckCard>{

  // represents the value of a card
  // jack = J, queen = Q, king = K, ace = A
  public CardValue cardvalue;

  // represents the value of a card, there are four types of card
  // clubs = ♣, diamonds = ♦, hearts = ♥ and spades = ♠
  public Suit suit;


  // the constructor
  public StandardDeckCard(CardValue cardvalue, Suit suit) {
    this.cardvalue = cardvalue;
    this.suit = suit;
  }



  // prints the cardvalue and suit as a string
  @Override
  public String toString() {
    return this.cardvalue.getCardType() + this.suit.getSymbol();
  }

  /**
   * checks if the two cards are the same
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof StandardDeckCard) {
      StandardDeckCard that = (StandardDeckCard) obj;
      return this.cardvalue.equals(that.cardvalue) &&
              this.suit.equals(that.suit);
    }
    else {
      return false;
    }
  }

  /**
   * returns a hashcode for the card
   */
  @Override
  public int hashCode() {
    int result = cardvalue.hashCode();
    result = 31 * result + suit.hashCode();
    return result;
  }

  /**
   * comparas this card with the given cards
   * @param that
   * @return a positive number if the value of this card is smaller than the given card
   * return a negative number if the value of this card is bigger than the given card
   * return zero if the value of this card is the same as the given card
   */

  // sorted order
  // ♣, ♦, ♥, ♠
  // Within each suit, cards should be ordered in descending order
  // by number with aces being highest (A, K, Q, J, 10, ..., 2)

  @Override
  public int compareTo(StandardDeckCard that) {
    if (this.suit.equals(that.suit)) {
      return that.cardvalue.value - this.cardvalue.value;
    }
    else {
      return this.suit.compareTo(that.suit);
    }
  }
}
