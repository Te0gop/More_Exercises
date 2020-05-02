package task_02_generic_box_integer;
/*
Use the description of the previous problem but now, test your generic box with Integers.
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
