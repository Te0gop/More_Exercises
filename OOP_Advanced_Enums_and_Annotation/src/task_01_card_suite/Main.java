package task_01_card_suite;
/*
Create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS, DIAMONDS, HEARTS, SPADES).
Iterate over the values of the enumeration type and print all ordinal values and names.
 */

public class Main {

    public static void main(String[] args) {

        CardSuite[] arr = CardSuite.values();

        System.out.println("Card Suits:");
        for (CardSuite suite : arr) {
            System.out.println("Ordinal value: " + suite.ordinal() + "; Name value: " + suite.name());
        }


    }


}
