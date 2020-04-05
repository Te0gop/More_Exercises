package task_3;

public class Worker extends Human{

    private final String INVALID_SALARY = "Expected value mismatch!Argument: weekSalary";

    private double weekSalary;
    private double workHoursPerDay;


    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.weekSalary = weekSalary;
        this.workHoursPerDay = workHoursPerDay;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if(weekSalary < 10) {
            throw new IllegalArgumentException(INVALID_SALARY);
        }
        this.weekSalary = weekSalary;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    public double getSalaryPerHour() {

        return (weekSalary / 7) / workHoursPerDay;
    }
    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\n"
                + "Last Name: " + getLastName() + "\n"
                + "Week Salary: " + getWeekSalary() + "\n"
                + "Hours per day: " + getWorkHoursPerDay() + "\n"
                + "Salary per hour: " + String.format("%.2f", getSalaryPerHour());
    }
}
