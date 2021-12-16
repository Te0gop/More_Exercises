import java.util.*;

public class CyclesInGraph {
    //Write a program to check whether an undirected graph is acyclic or holds any cycles.The input ends with "End" line.
    //Examples
    //Input	        	Output
    //C-G               Acyclic: Yes
    //End

    //A-F               Acyclic: No
    //F-D
    //D-A
    //End

    //Hint
    //Modify the Topological Sorting algorithm (source removal or DFS-based).

    public static Map<String, List<String>> graph = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        String source = null;

        while (!(line = scanner.nextLine()).equals("End")) {
            String[] tokens = line.split("-");

            if(source == null) {
                source = tokens[0];
            }
            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.get(tokens[0]).add(tokens[1]);
        }

        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();
        try {
            dfs(source, visited, cycles);
            System.out.println("Acyclic: Yes");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void dfs(String source, Set<String> visited, Set<String> cycles) {
        if(cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }
        if(visited.contains(source)) {
            return;
        }
        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);

        if(children == null) {
            return;
        }

        for (String child : children) {
            dfs(child, visited, cycles);
        }

        cycles.remove(source);

    }
}
