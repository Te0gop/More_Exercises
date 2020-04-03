import java.util.*;

public class CompanyUsers {
    /*
    Write a program which keeps information about companies and their employees.
You will receive company name and employee's id, until you receive the command "End".
Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.
When you finish reading data, order the companies by the name in ascending order.
Print the company name and each employee's id in the following format:
    {companyName}
    -- {id1}
    -- {id2}
    -- {idN}
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> companies = new TreeMap<>();

        String line = scan.nextLine();

        while(!line.equals("End")) {
            String[] tokens = line.split(" -> ");

            String companyName = tokens[0];
            String id = tokens[1];
            if(!companies.containsKey(companyName)) {
                companies.put(companyName, new LinkedList<>());
                companies.get(companyName).add(id);
            } else {
                if(!companies.get(companyName).contains(id)) {
                    companies.get(companyName).add(id);
                }
            }
            line = scan.nextLine();
        }

        companies
                .entrySet()
                .stream()
                //.sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                // in case we have a HashMap instead TreeMap sorting keys is necessary
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(id -> System.out.println("-- " + id));
                });


    }
}
