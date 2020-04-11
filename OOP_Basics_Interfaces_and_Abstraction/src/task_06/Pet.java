package task_06;

public class Pet implements Identifiable{
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
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
    public String getId() {
        return null;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() +" "
                + this.name + " " + " "
                +  " " + getBirthDate();
    }
}
