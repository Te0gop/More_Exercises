import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoadReconstruction {
    //You have to rebuild some roads in your city. Write a program that finds all the roads without which
    // buildings in the city will become unreachable. You will receive how many buildings the town has on the
    // first line, then you will receive the amount of streets and finally for each street you will receive
    // which buildings it connects. Find all the streets that are important and cannot be removed and print
    // them as shown in the examples.
    //Input
    //•	On the first line you will receive the amount of the buildings
    //•	On the second line you will receive the amount of the streets (n)
    //•	On the next "n" lines you will receive which buildings each street connects
    //Output
    //•	On the first line print: "Important streets:"
    //•	On the next lines (if any) print the street in the format: "{firstBuilding} {secondBuilding}"
    //•	The order of the output does not matter as long as you print all of the important streets
    //Examples
    //Input	            Output
    //5                 Important streets:
    //5                 3 4
    //1 - 0             0 3
    //0 - 2
    //2 - 1
    //0 - 3
    //3 - 4

    private static int[][] graph;
    private static StringBuilder output = new StringBuilder();
    private static int time = 0;
    private static boolean[] visited;
    private static int[] disc;
    private static int[] low;
    private static int[] parent;


    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        graph = new int[nodes][nodes];
        visited = new boolean[graph.length];
        disc = new int[graph.length];
        low = new int[graph.length];
        parent = new int[graph.length];

        for (int i = 0; i < edges; i++) {
            String[] tokens = reader.readLine().split(" - ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        bridges();

        System.out.println("Important streets:");
        System.out.print(output.toString());
    }

    private static void findBridge(int start) {
        visited[start] = true;
        disc[start] = low[start] = ++time;

        for (int v = 0; v < graph.length; v++) {
            if (graph[start][v] != 0) {
                if (!visited[v]) {
                    parent[v] = start;
                    findBridge(v);

                    low[start] = Math.min(low[start], low[v]);
                    if (low[v] > disc[start]) {
                        output.append(String.format("%d %d", start, v)).append(System.lineSeparator());
                    }
                } else if (v != parent[start]) {
                    low[start] = Math.min(low[start], disc[v]);
                }
            }
        }
    }

    private static void bridges() {

        for (int i = 0; i < graph.length; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                findBridge(i);
            }
        }
    }

}
