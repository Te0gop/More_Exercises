package task_02;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;
    private double tankCapacity;

    protected Vehicle() {

    }

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
        setTankCapacity(tankCapacity);
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
    public void setTankCapacity(double tankCapacity) {
        if(tankCapacity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    public void refuel(double refuel) {
        if(fuelQuantity + refuel > tankCapacity) {
        throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else if (refuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        fuelQuantity += refuel;
    }
    public boolean emptyBus() {
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + String.format(": %.2f", fuelQuantity);
    }
}
