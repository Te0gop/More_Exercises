package task_3;

public class Human {
    private final String INVALID_FIRST_NAME_MESSAGE = "Expected upper case letter!Argument: firstName";
    private final String INVALID_NAME_LENGTH_MESSAGE = "Expected length at least 4 symbols!Argument: firstName";

    private final String INVALID_LAST_NAME_MESSAGE = "Expected upper case letter!Argument: lastName";
    private final String INVALID_LAST_NAME_LENGTH_MESSAGE = "Expected length at least 3 symbols!Argument: lastName";
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_FIRST_NAME_MESSAGE);
        } else if(firstName.length() < 4) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_MESSAGE);
        } else if(lastName.length() < 3) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_LENGTH_MESSAGE);
        }
        this.lastName = lastName;
    }


}
