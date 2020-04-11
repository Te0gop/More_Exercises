package task_02;

public class Bus extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 1.4;
    private boolean isEmpty;


    protected Bus(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        if(!isEmpty) {
            super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + SUMMER_MODE_PERMANENT_ON);
        } else {
            super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
        }
    }

}
