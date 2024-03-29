import java.util.*;

public class DistanceBetweenVertices {
    //We are given a directed graph. We are given also a set of pairs of vertices. Find the shortest distance
    // between each pair of vertices or -1 if there is no path connecting them.
    //On the first line, you will get N, the number of vertices in the graph. On the second line, you will get P,
    // the number of pairs between which to find the shortest distance.
    //On the next N lines will be the edges of the graph and on the next P lines, the pairs.

    //Examples
    //Input	        	Output
    //2                 {1, 2} -> 1
    //2                 {2, 1} -> -1
    //1:2
    //2:
    //1-2
    //2-1

    public static int[][] graph;
    public static Map<Integer, Integer> indexMapper = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int pairs = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][];

        for (int i = 1; i <= nodes; i++) {
            String[] edges = scanner.nextLine()
                    .split(":");

            indexMapper.put(Integer.parseInt(edges[0]), i);

            if(edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1]
                                .split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

        }



        while (pairs-- > 0) {
            int[] relations = Arrays.stream(scanner.nextLine().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = relations[0];
            int destination = relations[1];

            System.out.printf("{%d, %d} -> ", source, destination);

            int[] prev = new int[graph.length];

            Arrays.fill(prev, -1);

            bfs(graph, indexMapper.get(source), indexMapper.get(destination), prev);

            List<Integer> path = new ArrayList<>();

            int parent = prev[indexMapper.get(destination)];

            while (parent != -1) {
                path.add(parent);
                parent = prev[parent];
            }

            int size = path.isEmpty() ? -1 : path.size();

            System.out.println(size);
        }

    }

    private static void bfs(int[][] graph, int source, int destination, int[] prev) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);

        boolean[] visited = new boolean[graph.length + 1];
        visited[source] = true;

        while(!queue.isEmpty()) {
            Integer node = queue.poll();

            if(node == destination) {
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                int child = indexMapper.get(graph[node][i]);

                if(!visited[child]) {
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
        prev[source] = -1;
    }
}
