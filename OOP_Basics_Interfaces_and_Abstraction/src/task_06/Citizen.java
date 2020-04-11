package task_06;

public class Citizen implements Identifiable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +" "
                + this.name + " " + age + " "
                + getId() + " " + getBirthDate();
    }
}
