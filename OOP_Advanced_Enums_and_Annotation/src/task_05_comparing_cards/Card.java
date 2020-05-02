package task_05_comparing_cards;

public class Card implements Comparable<Card>{

    /*
    As your cards have power you can safely add a functionality for comparing them. Try using the ready available
    interface and the built-in annotations to override the compareTo().
    Read two cards from the console and print the greater of the two. In the given format:
    "Card name: {Rank} of {Suit}; Card power: {Card power}"
    Note
    Pay attention to the actual overriding of the method.
Examples:
Input:	                     Output:
TWO                     Card name: ACE of SPADES; Card power: 53
CLUBS
ACE
SPADES
     */

    private Rank rank;
    private Suite suite;

    public Card(String rankType, String suiteType) {
        this.rank = Rank.valueOf(rankType.toUpperCase());
        this.suite = Suite.valueOf(suiteType.toUpperCase());
    }

    public int getPower() {
        return rank.getValue() + suite.getValue();
    }

    @Override
    public String toString() {
        return "Card name: " + rank.name() + " of " + suite.name() + "; Card power: " +getPower();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(), o.getPower());
    }
}
