import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BreakCycles {
    //You are given undirected multi-graph. Remove a minimal number of edges to make the graph acyclic
    // (to break all cycles). As a result, print the number of edges removed and the removed edges.
    // If several edges can be removed to break a certain cycle, remove the smallest of them in alphabetical order
    // (smallest start vertex in alphabetical order and smallest end vertex in alphabetical order).
    //Input	            	Output
    //1 -> 2 5 4            Edges to remove: 2
    //2 -> 1 3              1 - 2
    //3 -> 2 5              6 - 7
    //4 -> 1
    //5 -> 1 3
    //6 -> 7 8
    //7 -> 6 8
    //8 -> 6 7

    private static Map<String, Set<String>> graph = new HashMap<>();
    private static List<String> removedEdges = new ArrayList<>();
    private static SortedSet<String> outputCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (line != null && !line.equals("")) {
            String[] node = line.split(" -> ");
            String[] edgeParts = node.length > 1 ? node[1].split(" ") : new String[0];
            Set<String> temp = new HashSet<>();
            for (String edge : edgeParts) {
                boolean success = temp.add(edge.trim());
                if (!success) {
                    if (node[0].compareTo(edge) > 0) {
                        removedEdges.add(String.format("%s - %s", edge, node[0]));
                    }
                }
            }
            graph.put(node[0], temp);
            line = reader.readLine();
        }

        while (true) {
            Set<String> visited = new HashSet<>();
            boolean noCycles = true;
            for (String node : graph.keySet()) {
                SortedSet<String> cycle = new TreeSet<>();
                outputCycle = new TreeSet<>();
                boolean cyclic = searchForCycles(node, visited, cycle, null);
                if (cyclic) {
                    noCycles = false;
                    breakCycle();
                    break;
                }
            }
            if (noCycles) {
                break;
            }
        }

        System.out.println("Edges to remove: " + removedEdges.size());
        removedEdges = removedEdges.stream().sorted().collect(Collectors.toList());
        for (String edge : removedEdges) {
            System.out.println(edge);
        }
    }

    private static void breakCycle() {

        Map<String, Integer> vertexEdges = new HashMap<>();
        for (String node : outputCycle) {
            for (String vertex : outputCycle) {
                if (graph.get(node).contains(vertex)) {
                    vertexEdges.putIfAbsent(node, 0);
                    vertexEdges.put(node, vertexEdges.get(node) + 1);
                }
            }
        }

        while (true) {
            boolean hasChanged = false;
            for (String node : vertexEdges.keySet()) {
                if (vertexEdges.get(node) == 1 && outputCycle.contains(node)) {
                    outputCycle.remove(node);
                    hasChanged = true;
                    break;
                }
            }
            if (!hasChanged) {
                break;
            }
        }

        for (String node : outputCycle) {
            for (String vertex : outputCycle) {
                if (graph.get(node).contains(vertex)) {
                    removedEdges.add(String.format("%s - %s", node, vertex));
                    graph.get(node).remove(vertex);
                    graph.get(vertex).remove(node);
                    return;
                }
            }
        }
    }

    private static boolean searchForCycles(String node, Set<String> visited, SortedSet<String> cycle, String parent) {
        boolean output = false;
        if (cycle.contains(node)) {
            outputCycle.addAll(cycle);
            return true;
        }
        if (!visited.contains(node)) {
            visited.add(node);
            cycle.add(node);
            if (graph.containsKey(node)) {
                for (String child : graph.get(node)) {
                    if (!child.equals(parent)) {
                        output = output || searchForCycles(child, visited, cycle, node);
                    }
                }
                cycle.remove(node);
            }
        }
        return output;
    }
}
