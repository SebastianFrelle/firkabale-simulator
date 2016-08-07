import java.util.ArrayList;

class SimulationController {
  ArrayList deck;
  int noOfSuccesses, noOfFailures;

  static SimulationController instance = null;

  private SimulationController() {
    this.deck = buildDeck();
    noOfSuccesses = 0;
    noOfFailures = 0;
  }

  static SimulationController getInstance() {
    if (instance.equals(null)) {
      instance = new SimulationController();
    }

    return instance;
  }

  double run(int noOfIterations) {
    for (int i = 0; i < noOfIterations; i++) {
      FirkabaleController firkabaleController = new FirkabaleController(deck);
      boolean won = firkabaleController.playGame();
      if (won) {
        noOfSuccesses++;
      } else {
        noOfFailures++;
      }
    }

    return winRatio();
  }

  double winRatio() {
    return ((double) noOfSuccesses)/((double) (noOfSuccesses + noOfFailures));
  }

  private ArrayList buildDeck() {
    String[] suits = {"hearts", "diamonds", "spades", "clubs"};

    ArrayList deck = new ArrayList<Card>();

    for (int i = 2; i <= 14; i++) {
      for (String suit : suits) {
        deck.add(new Card(i, suit));
      }
    }

    return deck;
  }
}