import java.util.*;

public class Pirates {

    static class Cities implements Comparable<Cities>{
        String name;
        int population;
        int gold;

        public Cities(String name, int citizens, int gold) {
            this.name = name;
            this.population = citizens;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        @Override
        public int compareTo(Cities o) {
            int compareGold = o.getGold();
            return compareGold - gold != 0 ? compareGold - gold : name.compareTo(o.getName());
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cities> cities = new LinkedList<>();

        String line;
        boolean isExisting = false;

        while (!(line = scanner.nextLine()).equals("Sail")) {
            String[] delimiter = line.split("\\|\\|") ;
            String city = delimiter[0];
            int population = Integer.parseInt(delimiter[1]);
            int gold = Integer.parseInt(delimiter[2]);

            if (cities.isEmpty()) {
                cities.add(new Cities(city, population, gold));
                continue;
            }
            for (Cities value : cities) {
                if (value.getName().equals(city)) {
                    value.setGold(value.getGold() + gold);
                    value.setPopulation(value.getPopulation() + population);
                    isExisting = true;
                }
            }
            if(!isExisting) {
                cities.add(new Cities(city, population, gold));
            }
            isExisting = false;
        }
        while (!(line = scanner.nextLine()).equals("End")) {
            String[] delimiter = line.split("=>");
            String command = delimiter[0];
            String  city = delimiter[1];
            int population = Integer.parseInt(delimiter[2]);

            switch (command) {
                case "Plunder":
                    int gold = Integer.parseInt(delimiter[3]);
                    Cities cityToPlunderOrProsper = new Cities(city, population, gold);

                        for (Cities c : cities) {
                            if (c.getName().equals(cityToPlunderOrProsper.getName())) {
                                if(c.getGold() - gold >= 0 && c.getPopulation() - population >= 0) {

                                    c.setGold(c.getGold() - gold);
                                    c.setPopulation(c.getPopulation() - population);
                                    System.out.printf("%s plundered! %s gold stolen, %s citizens killed.%n", c.getName(),
                                            gold, population);
                                }
                                if (c.getGold() <= 0 || c.getPopulation() <= 0) {
                                    System.out.printf("%s has been wiped off the map!%n", c.getName());
                                    cities.remove(c);
                                }
                                break;
                            }
                        }

                    break;
                case "Prosper":
                    int goldForProsper = Integer.parseInt(delimiter[2]);
                    Cities cityToProsper = new Cities(city, population, goldForProsper);

                    for (Cities c : cities) {
                        if (c.getName().equals(cityToProsper.getName())) {
                            if(goldForProsper > 0) {
                                c.setGold(c.getGold() + goldForProsper);
                                System.out.printf("%s gold added to the city treasury. " +
                                        "%s now has %s gold.%n", goldForProsper, c.getName(), c.getGold());
                            } else {
                                System.out.println("Gold added cannot be a negative number!");
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        System.out.printf("Ahoy, Captain! There are %s wealthy settlements to go to:%n", cities.size());

        Collections.sort(cities);

        for (Cities city : cities) {
            System.out.printf("%s -> Population: %s citizens, Gold: %s kg%n",
                    city.getName(), city.getPopulation(), city.getGold());
        }
    }
}
