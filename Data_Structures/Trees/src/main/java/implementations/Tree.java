package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
// 1.Create Tree
//Implement the Tree class's constructor to set the correct key and to be able to build full
// tree by accepting all the children for each node. Also make sure to create the proper fields.
// 2. BFS Traversal
// 3. DFS Traversal
public class Tree<E> implements AbstractTree<E> {

    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;


    public Tree(E key, Tree<E>... subtrees) {
        this.key = key;
        this.children = new ArrayList<>();

        for (Tree<E> subtree : subtrees) {
            children.add(subtree);
            subtree.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while(!queue.isEmpty()) {
            Tree<E> current = queue.poll();
            result.add(current.key);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }



        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.doDfs(this, result);

        return result;
    }

    private void doDfs(Tree<E> node, List<E> result) {
        for (Tree<E> child : node.children) {
            doDfs(child, result);
        }
        result.add(node.key);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> search = find(this, parentKey);

        if(search == null) {
            throw new IllegalArgumentException();
        }
        search.children.add(child);
        child.parent = search;

    }

    private Tree<E> find(Tree<E> current, E parentKey) {
        if(current.key.equals(parentKey)) {
            return current;
        }
        for (Tree<E> child : current.children) {
            Tree<E> found = this.find(child, parentKey);
            if(found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> toRemove = find(this, nodeKey);
        if(toRemove == null) {
            throw new IllegalArgumentException();
        }
        for (Tree<E> child : toRemove.children) {
            child.parent = null;

        }
        toRemove.children.clear();
        Tree<E> parent = toRemove.parent;
        if (parent != null) {
            parent.children.remove(toRemove);
        }
        toRemove.key = null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = find(this, firstKey);
        Tree<E> secondNode = find(this, secondKey);

        if(firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }
        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);
    }
}



