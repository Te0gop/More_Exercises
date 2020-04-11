package task_03;

public class Cat extends Felime {

    String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, Integer foodEaten, String breed) {
        super(animalName, animalType, animalWeight, livingRegion, foodEaten);
        setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }


    @Override
    public String toString() {
        return animalType + "[" + animalName + ", "
                + breed + ", "
                + animalWeight + ", " + livingRegion + ", "
                + foodEaten + "]" + "\n";
    }
}
