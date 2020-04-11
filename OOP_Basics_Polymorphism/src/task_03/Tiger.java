package task_03;

public class Tiger extends Felime {


    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion, Integer foodEaten) {
        super(animalName, animalType, animalWeight, livingRegion, foodEaten);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public void foodCheck(String foodType) {
        if (!foodType.equals("Meat")) {
            System.out.printf("Tigers are not eating that type of food!%n");
            setFoodEaten(0);
        }
    }
}
