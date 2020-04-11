package task_02;

public class Car extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 0.9;

    protected Car(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + SUMMER_MODE_PERMANENT_ON);
    }
}
