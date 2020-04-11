package task_08.impl;

import task_08.contracts.LeutenantGeneral;
import task_08.contracts.Private;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {

    private Set<Private> privates;

    public LeutenantGeneralImpl(String id, String firstName, String lastName, double salary,
                                Set<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }
    @Override
    public String toString() {
        StringBuilder leutenantGeneral = new StringBuilder(super.toString()).append(System.lineSeparator());
        leutenantGeneral.append("Privates:");

        Set<Private> sorted = this.privates
                .stream()
                .sorted((p1, p2) -> p2.getId().compareTo(p1.getId()))
                .collect(Collectors.toSet());

        for(Private privateSoldier : sorted) {
            leutenantGeneral.append(System.lineSeparator()).append("  "+privateSoldier);
        }
        return leutenantGeneral.toString();
    }
}
