import java.util.function.Consumer;

public class SmartStack {
    private Node top;
    private int size;

    public SmartStack() {

    }

    public static class Node {
        private int element;
        private Node previous;

        Node(int element) {
            this.element = element;
            this.previous = null;
        }
    }

    public void push(int element) {
        Node newNode = new Node(element);

        if (top != null) {
            newNode.previous = top;
        }
        top = newNode;
        size++;
    }
    public int size() {
        return size;
    }
    public int peek() {
        ensureNotEmpty();
        return top.element;
    }

    private void ensureNotEmpty() {
        if(top == null) {
            throw new IllegalStateException("Stack is empty.");
        }
    }

    public int pop() {
        ensureNotEmpty();
        int result = top.element;

        top = top.previous;
        this.size--;
        return result;
    }
    public void forEach(Consumer<Integer> consumer) {
        Node current = top;
        while (current != null) {
            consumer.accept(current.element);
            current = current.previous;
        }
    }

}
