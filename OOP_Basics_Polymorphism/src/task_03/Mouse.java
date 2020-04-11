package task_03;

public class Mouse extends Mammal{


    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion, Integer foodEaten) {
        super(animalName, animalType, animalWeight, livingRegion, foodEaten);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public void foodCheck(String foodType) {
        if (foodType.equals("Meat")) {
            System.out.printf("Mouses are not eating that type of food!%n");
            setFoodEaten(0);
        }
    }


}
