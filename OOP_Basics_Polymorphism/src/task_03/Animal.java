package task_03;

public abstract class Animal{
    String animalName;
    String animalType;
    Double animalWeight;
    Integer foodEaten;

    public Animal(String animalType,String animalName, Double animalWeight, Integer foodEaten) {
        setAnimalName(animalName);
        setAnimalType(animalType);
        setAnimalWeight(animalWeight);
        setFoodEaten(foodEaten);
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);
    public abstract void foodCheck(String foodType);


}
