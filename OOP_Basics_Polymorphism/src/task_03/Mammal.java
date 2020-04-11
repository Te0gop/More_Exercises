package task_03;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion, Integer foodEaten) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return animalType + "[" + animalName + ", "
                +  decimalFormat.format(animalWeight)+ ", " + livingRegion + ", "
                + foodEaten + "]" + "\n";
    }
}
