package task_06;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return null;
    }

    @Override
    public void setBirthDate(String birthDate) {

    }
    public String toString() {
        return getClass().getSimpleName() +" "
                + this.model + " " + " "
                +  " " + getId();
    }
}
