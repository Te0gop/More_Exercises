package implementations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public Tree<Integer> createTreeFromStrings(String[] input) {
        for (String params : input) {
            int[] keys = Arrays.stream(params.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int parentsKey = keys[0];
            int childKey = keys[1];

            addEdge(parentsKey, childKey);

        }
        return null;
    }

    private Tree<Integer> getRoot() {
        return null;
    }

    public Tree<Integer> createNodeByKey(int key) {
        nodesByKeys.putIfAbsent(key, new Tree<>(key));
        return nodesByKeys.get(key);

    }

    public void addEdge(int parent, int child) {
        Tree<Integer> parentByKey = this.createNodeByKey(parent);
        Tree<Integer> childByKey = this.createNodeByKey(child);

        childByKey.setParent(parentByKey);
        parentByKey.addChild(childByKey);
    }
}



