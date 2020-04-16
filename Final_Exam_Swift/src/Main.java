import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Mammal cat = new Cat("Persian", true, Colors.orange, 4.3, 1);
        Mammal baldCat = new Cat("Egyptian", 10, 2);
        Mammal bigDog = new Dog("Kangal", 66.5, 3, Colors.black);
        Fish fish = new Fish("Cat fish", 5, "everything", false, 8);

        List<Mammal> list = new ArrayList<>();
        list.add(cat);
        list.add(baldCat);
        list.add(bigDog);

        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getClass().getSimpleName().equals("Cat") && list.get(i).getWeight() < 5) {
                System.out.println(list.get(i));
            }
        }
    }
}
