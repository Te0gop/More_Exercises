package task_01_generic_box;

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
