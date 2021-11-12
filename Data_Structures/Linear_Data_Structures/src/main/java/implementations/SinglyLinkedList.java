package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
         private E value;
         private Node<E> next;

         public Node(E element) {
             this.value = element;
             this.next = null;
         }
    }

    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> nextElement = new Node<>(element);

        nextElement.next = head;
        head = nextElement;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> lastElement = new Node<>(element);


        if(isEmpty()) {
            head = lastElement;
        } else {

            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = lastElement;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        ensureNotEmpty();

        E value = head.value;
        head = head.next;
        size--;
        return value;
    }



    @Override
    public E removeLast() {
        ensureNotEmpty();

        if(size == 1) {
            E value = head.value;
            head = null;
            size--;
            return value;
        }

        Node<E> preLast = head;
        Node<E> toRemove = head.next;

        while (toRemove.next != null) {
            preLast = toRemove;
            toRemove = toRemove.next;
        }

        preLast.next = null;
        size--;
        return toRemove.value;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return head.value;
    }

    @Override
    public E getLast() {
        ensureNotEmpty();

        Node<E> current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current.value;
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
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
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
        if(isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
