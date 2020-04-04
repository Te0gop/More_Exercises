package task_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    /*
    Create a Team class. Add to this team all person you read. All person younger than 40 go in first team,
    others go in reverse team. At the end print first and reserve team sizes.
The class should have private fields for:
•	Name: String
•	First Team Players: List<Person>
•	Reserve Team Players: List<Person>
The class should have constructors:
•	Team(String name)
The class should also have public methods for:
•	addPlayer(Person person): void
•	getFirstTeam():  Collections.unmodifiableList
•	getReserveTeam():  Collections.unmodifiableList
     */
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public void setFirstTeam(List<Person> firstTeam) {
        this.firstTeam = firstTeam;
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void setReserveTeam(List<Person> reserveTeam) {
        this.reserveTeam = reserveTeam;
    }
    public void addPlayer(Person player) {
        if (player.getAge() > 40) {
            reserveTeam.add(player);
        } else {
            firstTeam.add(player);
        }

    }
    @Override
    public String toString() {
        //First team have 4 players
        return "First team have " + firstTeam.size() + " players\n"
                + "Reserve team have " + reserveTeam.size() + " players";
    }


}
