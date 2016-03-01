package cs3500.hw03;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import cs3500.hw04.WhistTrumpModel;

/**
 * Created by yifanxing on 2/13/16.
 */
public class MainClass {

  public static void main(String[] args) {
    WhistController w = new WhistController(new InputStreamReader(System.in),
            System.out);
    Scanner s0 = new Scanner(System.in);


    w.startGame(new WhistTrumpModel(), s0.nextInt());


    int cardIndex;
    cardIndex = -1;
    while (cardIndex < 0) {

      System.out.println("\nEnter a number of players to start: ");

      int numPlayers = s0.nextInt();

      try {

        w.startGame(new WhistTrumpModel(), numPlayers);

        //    System.out.println("\ndone playing");

      } catch (IllegalArgumentException i) {
        System.out.append("Try again, that was invalid input: " +
                i.getMessage());
      } catch (InputMismatchException e) {
        System.out.append("Try again, that was invalid input: " +
                "input is not an integer");
      }


    }
  }
}
