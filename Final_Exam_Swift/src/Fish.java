public class Fish extends Animal {

    private String foodType;
    private boolean airPump;

    public Fish(String breed, int id, String foodType, boolean airPump, double weight) {
        super(breed, id, weight);
        this.foodType = foodType;
        this.airPump = airPump;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean isAirPump() {
        return airPump;
    }

    public void setAirPump(boolean airPump) {
        this.airPump = airPump;
    }

    @Override
    public void setWeight(double weight) {
        if(weight > 10) {
            throw new IllegalArgumentException("Fishes weight cannot be more than 10 kg.");
        }
        super.setWeight(weight);
    }
}
