# Dev notes

* Use java.util.Stack instead of the user-defined Stack interface and its implementing class CardStack (the other thing was just for practice).
* Look to reduce number of redundant initializations for efficiency.
* Don't initialize a new controller each time the simulation is done.
    - I guess this could be done by implementing the controller as a singleton class and then just call some sort of reset method for each iteration of the test.
* When comparing suits "stupidly", there are 3 comparisons to do for each card, meaning 4 * 3 = 12 comparisons. If redundant (already executed) comparisons are "skipped", that number drops to 6 (1-2, 1-3, 1-4, 2-3, 2-4, 3-4).
    - How do we implement this method of comparison? Recursive comparisons on the "rest" of the list, probably.
```java
// Maybe return an array of those
// cards that are the same suit?
ArrayList<Card> compare(ArrayList<CardStack> cardStacks) {

}
```
* The comparison method could be implemented by initializing a new ArrayList for each stack consisting of the rest of the stacks and then comparing suits. Otherwise, we are going to have to compare the stack to itself, 

* We could implement this with a log tracking all the games, so we could go back and see what was on top at any given moment in any given game. That would be pretty fucking rad, I think.

## Classes and their properties

* Card
    - suit
    - numericalValue
* Firkabale (optionally FirkabaleController)
    - Manages the game as it's coming along, implementing the rules of the game, tasked with removing cards as well.
    - Should contain the building of the deck

We could do it like this:
* Two classes: FirkabaleController og TestController. 
    - TestController is initialized once per execution (implemented as Singleton class). It constructs the deck and initializes the FirkabaleController once for each test.
    - Could this be more efficient using threading? Could tests be run across multiple threads and their results then combined.

The deck should be implemented as a java.util.Stack on the Game Controller

