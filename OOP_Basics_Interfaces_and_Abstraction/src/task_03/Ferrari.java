package task_03;

public class Ferrari implements Car{
    String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Gas!";
    }

    @Override
    public String toString() {
        return getModel() +  "/" + brakes() + "/" + gas() + "/"+ driver;
    }
}
