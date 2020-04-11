package task_01;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;


    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public boolean drive(double distance) {
        double neededFuel = distance * fuelConsumptionPerKilometer;
        if(neededFuel > fuelQuantity) {
            return false;
        }
        fuelQuantity -= neededFuel;
        return true;
    }

    public void refuel(double refuel) {
        fuelQuantity += refuel;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + String.format(": %.2f", fuelQuantity);
    }
}
