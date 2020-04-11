package task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] delimiter = bufferedReader.readLine().split(" ");

        while(!delimiter[0].equals("End")) {
            String[] foodDelimiter = bufferedReader.readLine().split(" ");
            if (delimiter[0].equals("Mouse")) {
                Animal mouse = new Mouse(delimiter[0], delimiter[1], Double.parseDouble(delimiter[2]),
                        delimiter[3], Integer.parseInt(foodDelimiter[1]));

                mouse.makeSound();
                mouse.foodCheck(foodDelimiter[0]);
                Food food = new Vegetable(Integer.parseInt(foodDelimiter[1]));
                mouse.eat(food);
                System.out.println(mouse);

            } else if (delimiter[0].equals("Zebra")) {
                Animal zebra = new Zebra(delimiter[0], delimiter[1], Double.parseDouble(delimiter[2]),
                        delimiter[3], Integer.parseInt(foodDelimiter[1]));

                zebra.makeSound();
                zebra.foodCheck(foodDelimiter[0]);
                Food food = new Vegetable(Integer.parseInt(foodDelimiter[1]));
                zebra.eat(food);
                System.out.println(zebra);
            } else if (delimiter[0].equals("Tiger")) {
                Animal tiger = new Tiger(delimiter[0], delimiter[1], Double.parseDouble(delimiter[2]),
                        delimiter[3], Integer.parseInt(foodDelimiter[1]));

                tiger.makeSound();
                tiger.foodCheck(foodDelimiter[0]);
                Food food = new Meat(Integer.parseInt(foodDelimiter[1]));
                tiger.eat(food);
                System.out.println(tiger);
            } else if (delimiter[0].equals("Cat")) {
                Animal cat = new Cat(delimiter[0], delimiter[1], Double.parseDouble(delimiter[2]),
                        delimiter[3], Integer.parseInt(foodDelimiter[1]), delimiter[4]);
                if (foodDelimiter[0].equals("Meat")) {
                    Food food = new Meat(Integer.parseInt(foodDelimiter[1]));
                    cat.makeSound();
                    cat.eat(food);
                    System.out.println(cat);
                } else {
                    Food food = new Vegetable(Integer.parseInt(foodDelimiter[1]));
                    cat.makeSound();
                    cat.eat(food);
                    System.out.println(cat);
                }
            }
            delimiter = bufferedReader.readLine().split("\\s+");
        }



    }

}
