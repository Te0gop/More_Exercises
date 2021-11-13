package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final int INITIAL_CAPACITY = 7;
    private int size;
    private int head;
    private int tail;
    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        int middle = INITIAL_CAPACITY / 2;
        head = tail = middle;
    }


    @Override
    public void add(E element) {
        addLast(element);
     }

    private Object[] grow() {
        int newCapacity = elements.length * 2 + 1;
        Object[] newElements = new Object[newCapacity];

        int middle = newCapacity / 2;
        int begin = middle - size / 2;

        int index = head;

        for (int i = begin; index <= tail; i++) {
            newElements[i] = elements[index++];
        }
        head = begin;
        tail = head + size - 1;

        return newElements;
    }

    @Override
    public void offer(E element) {
        addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if(size == 0) {
            addLast(element);
        } else {
            if(head == 0) {
                elements = grow();
            }
            elements[--head] = element;
            size++;
        }
    }

    @Override
    public void addLast(E element) {
        if(size == 0) {
            elements[tail] = element;
        } else {
            if(tail == elements.length - 1) {
                elements = grow();
            }
            elements[++tail] = element;
        }
        size++;
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = head + index;
        ensureIndex(realIndex);

        if(realIndex - head < tail - realIndex) {
            insertAndShiftLeftSide(realIndex - 1, element);
        } else {
            insertAndShiftRightSide(realIndex, element);
        }

    }

    private void insertAndShiftRightSide(int index, E element) {
        E lastElement = getAt(tail);

        for (int i = tail; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        addLast(lastElement);
    }

    private void insertAndShiftLeftSide(int index, E element) {
        E firstElement = getAt(head);

        for (int i = head; i <= index; i++) {
            elements[i] = elements[i + 1];
        }
        elements[index] = element;
        addFirst(firstElement);
    }

    @Override
    public void set(int index, E element) {
        int realIndex = head + index;
        ensureIndex(realIndex);

        elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if(size != 0) {
           return getAt(head);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) elements[index];
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E get(int index) {
        int realIndex = head + index;
        ensureIndex(realIndex);
        return getAt(realIndex);
    }

    @Override
    public E get(Object object) {
        if(isEmpty()) {
            return null;
        }
        for (int i = head; i <= size; i++) {
            if(elements[i].equals(object)) {
                return getAt(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = head + index;
        ensureIndex(realIndex);

        return getAt(realIndex);
    }

    private void ensureIndex(int realIndex) {
        if(realIndex > tail || realIndex < head) {
            throw new IndexOutOfBoundsException("Index out of bounds for index: " + (realIndex - head));
        }
    }

    @Override
    public E remove(Object object) {
        if(isEmpty()) {
            return null;
        }

        for (int i = head; i <= tail; i++) {
            if(elements[i].equals(object)) {
                E element = getAt(i);
                elements[i] = null;

                for (int j = i; j < tail; j++) {
                    elements[j] = elements[j + 1];
                }                
                removeLast();
                
                return element;
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if(!isEmpty()) {
            E element = getAt(head);
            elements[head] = null;
            head++;
            size--;
            return element;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if(!isEmpty()) {
            E element = getAt(tail);
            elements[tail--] = null;
            size--;
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[size];
        int index = 0;

        for (int i = head; i <= tail; i++) {
            newElements[index++] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return getAt(index++);
            }
        };
    }
}
