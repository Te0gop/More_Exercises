package task_03_cards_with_power;

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
