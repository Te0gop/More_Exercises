package task_03_generic_swap_strings;
/*
Create a generic method that receives a list containing any type of data and swaps the elements at two given
indexes.
As in the previous problems, read n number of boxes of type String and add them to the list. On the next line,
however, you will receive a swap command consisting of two indexes. Use the method you've created to swap the
elements that correspond to the given indexes and print each element in the list.
Examples:

Input                                   Output
3
Pesho                           java.lang.String: Swap me with Pesho
Gosho                           java.lang.String: Gosho
Swap me with Pesho              java.lang.String: Pesho
0 2

 */

public class Box<T> {

    private T value;

    public Box() {

    }
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", value.getClass().getName(), value);
    }
}
