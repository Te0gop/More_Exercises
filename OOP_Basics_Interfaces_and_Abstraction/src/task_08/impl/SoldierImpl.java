package task_08.impl;

import task_08.contracts.Soldier;

public abstract class SoldierImpl implements Soldier {
    private String id;
    private String firstName;
    private String lastName;

    public SoldierImpl(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s", firstName, lastName, id);
    }
}
