public class Cat extends Mammal {

    private boolean hasFur;
    private Colors furColor;

    public Cat(String breed, double weight, int id) {
        super(breed, id, weight);
    }

    public Cat(String breed, boolean hasFur, Colors furColor, double weight, int id) {
        super(breed, id, weight);
        this.hasFur = hasFur;
        this.furColor = furColor;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public Colors getFurColor() {
        return furColor;
    }

    public void setFurColor(Colors furColor) {
        this.furColor = furColor;
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 20) {
            throw new IllegalArgumentException("Cat's weight cannot be more than 20 kg.");
        }
        super.setWeight(weight);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", breed: " + getBreed() + ", ID: "
                + getId() + ", weight: " + getWeight() + ", hasFur: " + isHasFur() + ", Fur color: "
                + getFurColor();
    }
}
