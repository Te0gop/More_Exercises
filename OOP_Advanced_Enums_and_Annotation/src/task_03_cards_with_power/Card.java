package task_03_cards_with_power;

public class Card {

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
}
