package task03_scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(13, 7);
        System.out.println(scale.getHeavier());
    }
}
