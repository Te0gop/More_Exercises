package task_03;

public class Zebra extends Mammal {


    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion, Integer foodEaten) {
        super(animalName, animalType, animalWeight, livingRegion, foodEaten);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public void foodCheck(String foodType) {
        if (foodType.equals("Meat")) {
            System.out.printf("Zebras are not eating that type of food!%n");
            setFoodEaten(0);
        }
    }

}
