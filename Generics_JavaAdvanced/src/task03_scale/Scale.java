package task03_scale;

public class Scale<T extends Comparable<T>> {
    T left;
    T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int result = left.compareTo(right);

        if(result == 0) {
            return null;
        } else if (result > 0) {
            return left;
        }
        return right;
    }
}
