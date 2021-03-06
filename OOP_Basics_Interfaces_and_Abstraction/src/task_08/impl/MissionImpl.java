package task_08.impl;

import task_08.contracts.Mission;

public class MissionImpl implements Mission {
    private static final String IN_PROGRESS_MISSION_STATE = "inProgress";
    private static final String FINISHED_MISSION_STATE = "Finished";


    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    public void setState(String state) {
        if(!IN_PROGRESS_MISSION_STATE.equals(state) && !FINISHED_MISSION_STATE.equals(state)) {
            throw new IllegalArgumentException();
        }
        this.state = state;
    }
    @Override
    public void completeMission() {
        this.state = FINISHED_MISSION_STATE;
    }


    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state);
    }
}
