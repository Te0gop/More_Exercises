package task_01;

public class Truck extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + SUMMER_MODE_PERMANENT_ON);
    }

    @Override
    public void refuel(double refuel) {
        super.refuel(refuel * 0.95);
    }
}
