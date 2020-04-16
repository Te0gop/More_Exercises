public abstract class Animal {

    private String breed;
    private int id;
    private double weight;

    public Animal(String breed, int id, double weight) {
        this.breed = breed;
        this.id = id;
        setWeight(weight);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "breed='" + breed + '\'' +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
