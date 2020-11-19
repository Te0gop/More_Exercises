import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        SmartArray smartArray = new SmartArray();
////
////        for (int i = 1; i <= 8; i++) {
////            smartArray.add(i);
////        }
////
////        smartArray.add(0, 13);
////        smartArray.forEach(System.out::println);

        SmartStack stack = new SmartStack();

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}
