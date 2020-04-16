import java.awt.*;

public class Dog extends Mammal {

    private Colors furColor;

    public Dog(String breed, double weight, int id, Colors furColor) {
        super(breed, id, weight);
        this.furColor = furColor;
    }

    public Colors getFurColor() {
        return furColor;
    }

    public void setFurColor(Colors furColor) {
        this.furColor = furColor;
    }

    @Override
    public void setWeight(double weight) {
        if(weight > 100) {
            throw new IllegalArgumentException("Dog's weight cannot be more than 100 kg.");
        }
        super.setWeight(weight);
    }
}
