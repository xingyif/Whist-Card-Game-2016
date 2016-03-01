package cs3500.hw03;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * represents the whist controller for the whist game
 */
public class WhistController implements IWhistController{
  final Readable in;
  final Appendable out;

  public WhistController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }


    /**
   * starts the provided game with a given number of players
   * return only when the game has ended
   * @param game the given game to start
   * @param numPlayers the given number of players in the game
   */
  @Override
  public <K> void startGame(CardGameModel<K> game, int numPlayers) {
    Scanner scan = new Scanner(this.in);

    if (numPlayers <= 1) {
      try {
        // start the game
        game.startPlay(numPlayers, game.getDeck());
      } catch (IllegalArgumentException i) {
        try {
          this.out.append("Try again, that was invalid input: " +
                  i.getMessage());
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    } else {

      // start the game
      game.startPlay(numPlayers, game.getDeck());

      int cardIndex;
      // the game is still running
      while (!game.isGameOver()) {
        // output the message to the player
        try {
          this.out.append(game.getGameState() + "\n");
        } catch (IOException e) {
          e.printStackTrace();
        }

        cardIndex = -1;
        while (cardIndex < 0) {
          // wait for the user input from the input stream
          try {
            cardIndex = scan.nextInt();
            // if the cardIndex passed in is an invalid index or invalid suit
            // an exception thrown by the model, then catch the exception,
            // print the try again line and then set the cardIndex to -1
            // move on to find the next valid, else get out of this while loop
            try {
              game.play(game.getCurrentPlayer(), cardIndex);
            } catch (IllegalArgumentException i) {
              try {
                this.out.append("Try again, that was invalid input: " + i.getMessage() + "\n");
              } catch (IOException e) {
                e.printStackTrace();
              }
              cardIndex = -1;
            }
          } catch (InputMismatchException i) {
            try {
              this.out.append("Try again, that was invalid input:" +
                      " input is not an integer" + "\n");
            } catch (IOException e) {
              e.printStackTrace();
            }
            scan.next();
            cardIndex = -1;
          } catch (NoSuchElementException e) {
            try {
              this.out.append("Try again, that was invalid input:" +
                      " no more input and the game is not over" + "\n");
            } catch (IOException i) {
              i.printStackTrace();
            }
            return;
          }
        }
      }
      try {
        String state = game.getGameState();
        this.out.append(state);
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }

}


