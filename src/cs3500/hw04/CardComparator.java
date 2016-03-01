package cs3500.hw04;

import java.util.Comparator;

import cs3500.hw02.StandardDeckCard;

/**
 * a comparator class that compares two cards
 */
public class CardComparator implements Comparator<StandardDeckCard> {

  /**
   * compares two cards
   * Within each suit, cards should be ordered in descending order
   * by number with aces being highest (A, K, Q, J, 10, ..., 2)
   * @param o1 card
   * @param o2 card
   * @return the negative if o1
   */
  @Override
  public int compare(StandardDeckCard o1, StandardDeckCard o2) {
    // if two cards have the same suit
    if (o2.suit.ordinal() - o1.suit.ordinal() == 0) {
      return o2.cardvalue.getCardValue() - o1.cardvalue.getCardValue();
    }
    else {
    return o1.suit.ordinal() - o2.suit.ordinal();
    }
  }


}
