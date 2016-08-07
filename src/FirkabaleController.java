import java.util.Stack;
import java.util.ArrayList;

class FirkabaleController {
  ArrayList deck, cardStacks;
  Stack cardStack1, cardStack2, cardStack3, cardStack4;

  FirkabaleController(ArrayList deck) {
    this.deck = deck;
    this.cardStacks = new ArrayList<Stack<Card>>(4);
  }

  boolean playGame() {
    while (!deck.isEmpty()) {
      dealCards();
      // Then compare the top suit of each cardStack to one another
      // Do this stupidly to begin with, optimize as you go along
      while (true) {
        if (!getIdenticalSuits()) break;
        // ELSE pop() card belonging to suit with the lower numerical value.
        // Should getIdenticalSuits() maybe return an array of the indexes
        // of cards belonging to the same suit? That could be rad.
        
        // Check here if any stack is empty and transfer the highest card
        // on top of the remaining stacks to this stack. Then break to start
        // over comparing suits.
        for (int i = 0; i < 4; i++) {
          if (cardStacks.get(i).empty()) {
            // Pop card from one stack and push it to the empty one.
            // FIRST RULE: choose the card with the highest numerical value.
            int popIdx = getHighestTopCardIdx(i);
            Card transferredCard = cardStacks.get(popIdx).pop();
            cardStacks.get(i).push(transferredCard);
            break;
          }
        }
      }
    }

    return succeeded();
  }

  boolean succeeded() {
    for (Stack cardStack : cardStacks) {
      if (cardStack.size() != 1 || cardStack.peek().value != 14) {
        return false;
      }
    }

    return true;
  }

  int getHighestTopCardIdx(int emptyStackIdx) {
    int idx = 0;
    int value = 0;

    for (int i = 0; i < 4; i++) {
      if (i == emptyStackIdx) continue;
      
      newValue = cardStacks.get(i).value;
      if (newValue > value) {
        value = newValue;
        idx = i;
      }
    }

    return idx;
  }

  boolean getIdenticalSuits() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (j == i) continue;

        if (cardStacks.get(i).peek().suit.equals(cardStacks.get(j).peek().suit)) {
          int idx = (cardStacks.get(i).peek().value < cardStacks.get(j).peek().value) ? i : j;
          cardStacks.get(idx).pop();
          return true;
        }
      }
    }

    return false;
  }

  boolean removeCard() {
    cardStacks.get((cardStacks.get(i).peek().value < cardStacks.get(j).peek().value) ? i : j).pop();
  }

  void dealCards() {
    int idx;

    for (Stack cardStack : cardStacks) {
      idx = Random().nextInt(deck.size());
      cardStack.push(deck.get(idx));
    }
  }
}