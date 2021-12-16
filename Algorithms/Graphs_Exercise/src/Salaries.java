import java.util.*;

public class Salaries {
    //We have a hierarchy between the employees in a company. Employees can have one or several direct managers. People who manage nobody are called regular employees and their salaries are 1. People who manage at least one employee are called managers. Each manager takes a salary which is equal to the sum of the salaries of their directly managed employees. Managers cannot manage directly or indirectly (transitively) themselves. Some employees might have no manager (like the big boss). See a sample hierarchy in a company along with the salaries computed following the above described rule:
    //
    //In the above example the employees 0 and 3 are regular employees and take salary 1. All others are managers and take the sum of the salaries of their directly managed employees. For example, manager 1 takes salary 3 + 2 + 1 = 6 (sum of the salaries of employees 2, 5 and 0). In the above example employees 4 and 1 have no manager.
    //If we have N employees, they will be indexed from 0 to N – 1. For each employee, you’ll be given a string with N symbols. The symbol at a given index i, either 'Y' or 'N', shows whether the current employee is a direct manager of employee i.
    //Hint: find the node with no parent and start a DFS traversal from it to calculate the salaries on the tree recursively.
    //Input
    //•	The input data should be read from the console.
    //•	On the first line you’ll be given an integer N.
    //•	On the next N lines you’ll be given strings with N symbols (either 'Y' or 'N').
    //•	The input data will always be valid and in the format described. There is no need to check it explicitly.
    //Output
    //•	The output should be printed on the console. It should consist of one line.
    //•	On the only output line print the sum of the salaries of all employees.
    //Constraints
    //•	N will be an integer in the range [1 … 50].
    //•	For each i-th line, the i-th symbol will be 'N'.
    //•	If employee A is the manager of employee B, B will not be a manager of A.
    //•	Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.

    //Input	            Output	            Comments
    //1                 1                   Only 1 employee with salary 1.
    //N

    //4                 5                   We have 4 employees. 0, 1, and 3 are managers of 2. 3 is also a manager of 1. Therefore:
    //NNYN                                  salary(2) = 1
    //NNYN                                  salary(0) = salary(2) = 1
    //NNNN                                  salary(1) = salary(2) = 1
    //NYYN                                  salary(3) = salary(2) + salary(1) = 2

    public static List<List<Integer>> graph = new ArrayList<>();

    public static int[] salaries;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employees = Integer.parseInt(scanner.nextLine());
        salaries = new int[employees];
        visited = new boolean[employees];

        int[] managersCount = new int[employees];

        for (int i = 0; i < employees; i++) {
            graph.add(new ArrayList<>());
            String line = scanner.nextLine();

            for (int emp = 0; emp < line.length(); emp++) {
                char letter = line.charAt(emp);
                if(letter == 'Y') {
                    managersCount[emp]++;
                    graph.get(i).add(emp);
                }
            }
        }

        List<Integer> sources = new ArrayList<>();

        for (int i = 0; i < managersCount.length; i++) {
            if(managersCount[i] == 0) {
                sources.add(i);
            }
        }

        for (Integer source : sources) {
            dfs(source);
        }
        int sum = Arrays.stream(salaries).sum();
        System.out.println(sum);
    }

    private static void dfs(int node) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;

        for (Integer child : graph.get(node)) {
            if(!visited[child]) {
                dfs(child);

                int sum = graph.get(child).stream()
                        .mapToInt(c -> salaries[c])
                        .sum();

                salaries[child] = sum == 0 ? 1 : sum;
            }
        }
        int sum = graph.get(node).stream()
                .mapToInt(c -> salaries[c])
                .sum();

        salaries[node] = sum == 0 ? 1 : sum;
    }
}
