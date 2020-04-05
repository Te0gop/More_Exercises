package task_3;

public class Student extends Human {
    private final String INVALID_FACULTY_NUMBER = "Invalid faculty number!";
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        if(facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER);
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\n"
                + "Last Name: " + getLastName() + "\n"
                + "Faculty number: " + getFacultyNumber();
    }
}
