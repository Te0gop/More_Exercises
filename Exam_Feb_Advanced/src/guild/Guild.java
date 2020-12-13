package guild;

import java.util.*;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public void addPlayer(Player player) {

        if (roster.size() < getCapacity()) {
            roster.add(player);
        }
    }
    public boolean removePlayer(String name) {

        return roster.removeIf(p -> p.getName().equals(name));
//        for (Player player : roster) {
//            if(player.getName().equals(name)) {
//                roster.remove(player);
//                return true;
//            }
//        }
//
//        return false;
    }
    public void promotePlayer(String name) {
        for (Player player : roster) {
                if (player.getName().equals(name)) {
                    player.setRank("Member");
                }
        }
    }
    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }
    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = new ArrayList<>();

        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                list.add(player);
            }
        }
        Player[] kickedPlayers = new Player[list.size()];

        for (int i = 0; i < list.size(); i++) {
            kickedPlayers[i] = list.get(i);
            roster.remove(kickedPlayers[i]);
        }

        return kickedPlayers;

//        Player[] players = roster.stream()
//                .filter(p -> p.getClazz().equals(clazz))
//                .toArray(Player[]::new);
//
//        for(Player player : players) {
//            roster.removeIf(p -> p.getName().equals(player.getName()));
//        }
//        return players;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder out = new StringBuilder();
        System.out.println();

        out.append("Players in the guild: ")
                .append(getName())
                .append(System.lineSeparator());


        for (Player player : roster) {
            out.append(player.toString())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }

}
