package task_08.impl;

import task_08.contracts.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d ", partName, hoursWorked);
    }
}
