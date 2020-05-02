package task_07_deck_of_cards;

@CustomEnumAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suite {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);



    private int value;

    Suite(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
