package task_02;

/*
Read person with their names, age and salary. Read percent bonus to every person salary.
Persons younger than 30 get half bonus. Expand Person from previous task. Add salary field and property with proper access.
New fields and methods
    •	Salary: Double
    •	IncreaseSalary(Double bonus)
 */

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double increaseSalary(double bonus) {
        if(age < 30) {
            return salary += salary * (bonus / 200);
        } else {
            return salary += salary * (bonus / 100);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " gets " + salary + " leva";
    }
}
