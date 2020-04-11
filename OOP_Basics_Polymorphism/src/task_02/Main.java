package task_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carDelimiter = reader.readLine().split(" ");
        String[] truckDelimiter = reader.readLine().split(" ");
        String[] busDelimiter = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carDelimiter[1]), Double.parseDouble(carDelimiter[2]),
                Double.parseDouble(carDelimiter[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckDelimiter[1]), Double.parseDouble(truckDelimiter[2]),
                Double.parseDouble(truckDelimiter[3]));
        Vehicle bus = new Bus(Double.parseDouble(busDelimiter[1]), Double.parseDouble(busDelimiter[2]),
                Double.parseDouble(busDelimiter[3]));

        int countOfCommands = Integer.parseInt(reader.readLine());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        for (int i = 0; i < countOfCommands; i++) {
            String[] commandLine = reader.readLine().split(" ");

            String command = commandLine[0];
            String vehicleType = commandLine[1];
            double parameter = Double.parseDouble(commandLine[2]);

                switch (command) {
                    case "Drive":
                        switch (vehicleType) {
                            case "Car":
                                boolean isTravelled = car.drive(parameter);
                                if (isTravelled) {
                                    System.out.printf("Car travelled %s km\n", decimalFormat.format(parameter));
                                } else {
                                    System.out.println("Car needs refueling");
                                }
                                break;
                            case "Truck":
                                boolean isTruckTravelled = truck.drive(parameter);
                                if (isTruckTravelled) {
                                    System.out.printf("Truck travelled %s km\n", decimalFormat.format(parameter));
                                } else {
                                    System.out.println("Truck needs refueling");
                                }
                                break;
                            case "Bus":
                                boolean isBusTravelled = bus.drive(parameter);
                                if (isBusTravelled) {
                                    System.out.printf("Bus travelled %s km\n", decimalFormat.format(parameter));
                                } else {
                                    System.out.println("Bus needs refueling");
                                }
                                break;
                        }
                        break;
                    case "Refuel":
                        try {
                            switch (vehicleType) {
                                case "Car":
                                    car.refuel(parameter);
                                    break;
                                case "Truck":
                                    truck.refuel(parameter);
                                    break;
                                case "Bus":
                                    bus.refuel(parameter);
                                    break;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "DriveEmpty":
                        bus.emptyBus();
                        if (!bus.emptyBus()) {
                            System.out.printf("Bus travelled %s km\n", decimalFormat.format(parameter));
                        } else {
                            System.out.println("Bus needs refueling");
                        }
                }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
