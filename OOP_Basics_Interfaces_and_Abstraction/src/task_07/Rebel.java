package task_07;

public class Rebel implements Buyer{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }
    public Rebel() {

    }

    public String getGroup() {
        return group;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

}
