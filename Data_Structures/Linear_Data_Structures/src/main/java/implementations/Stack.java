package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {

    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
        }
    }

    private Node<E> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> toInsert = new Node<>(element);
        toInsert.next = top;
        top = toInsert;

        this.size++;
    }

    @Override
    public E pop() {
        ensureNotEmpty();

        Node<E> tmp = top;
        top = tmp.next;
        size--;
        return tmp.value;
    }

    @Override
    public E peek() {
        ensureNotEmpty();

        return top.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private void ensureNotEmpty() {
        if(this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
