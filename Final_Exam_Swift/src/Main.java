import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Animal cat = new Cat("Persian", true, Colors.orange, 4.3, 1);
        Animal baldCat = new Cat("Egyptian", 10, 2);
        Animal bigDog = new Dog("Kangal", 66.5, 3, Colors.black);
        Animal fish = new Fish("Cat fish", 5, "everything", false, 8);

        List<Animal> list = new ArrayList<>();
        list.add(cat);
        list.add(baldCat);
        list.add(bigDog);
	list.add(fish);

        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getClass().getSimpleName().equals("Cat") && list.get(i).getWeight() < 5) {
                System.out.println(list.get(i));
            }
        }
    }
}
