package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int INITIAL_SIZE = 4;

    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayList() {

        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = INITIAL_SIZE;
    }

    @Override
    public boolean add(E element) {
        if(size == capacity) {
            grow();

        }
        this.elements[this.size++] = element;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if(!validIndex(index)) {
            return false;
        }
        shiftRight(index);
        this.elements[index] = element;
        size++;

        return true;
    }

    @Override
    public E get(int index) {
        ensureIndex(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        ensureIndex(index);

        Object existing = this.elements[index];

        this.elements[index] = element;

        return (E) existing;
    }

    @Override
    public E remove(int index) {
        ensureIndex(index);
        Object existing = this.elements[index];

        shiftLeft(index);
        this.size--;

        shrinkIfNeeded();
        return (E) existing;
    }

    private void shrinkIfNeeded() {
        if(this.size > this.capacity / 3) {
            return;
        }
        this.capacity /= 2;
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        capacity *= 2;
        Object[] tmp = new Object[capacity];

        for (int i = 0; i < elements.length; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
    }

    private void shiftRight(int index) {
        for (int i = size - 1; i >= index - 1; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < size;
    }

    private void ensureIndex(int index) {
        if(!validIndex(index)) {
            throw new IndexOutOfBoundsException(
                    "Cannot use index " + index + "on ArrayList with " + size + " elements.");
        }
    }
}
