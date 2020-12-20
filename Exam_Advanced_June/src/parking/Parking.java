package parking;
import java.util.Comparator;
import java.util.LinkedList;


public class Parking {
    LinkedList<Car> data;
    String type;
    int capacity;

    public Parking(String type, int capacity) {
        this.data = new LinkedList<>();
        this.type = type;
        setCapacity(capacity);
    }

    public LinkedList<Car> getData() {
        return data;
    }

    public void setData(LinkedList<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Car car) {
        if(data.size() < getCapacity()) {
            data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model) {

        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getManufacturer().equals(manufacturer) && data.get(i).getModel().equals(model)) {
                data.remove(data.get(i));
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar() {

        if(data.isEmpty()) {
            return null;
        }

        return data.stream()
                .max(Comparator.comparing(Car::getYear))
                .get();
    }
    public Car getCar(String manufacturer, String model) {
        if(data.isEmpty()) {
            return null;
        }
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in Underground parking garage:")
                .append(System.lineSeparator());

        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
