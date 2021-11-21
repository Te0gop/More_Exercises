package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    
    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }


    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while(index > 0 && isLess(getParentIndex(index), index)) {
            Collections.swap(elements, getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private boolean isLess(int firstIndex, int secondIndex) {
        return getAt(firstIndex).compareTo(getAt(secondIndex)) > 0;
    }

    private E getAt(int index) {
        return elements.get(index);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return this.elements.get(0);
    }

    private void ensureNotEmpty() {
        if(this.size() == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
    }

    @Override
    public E poll() {
        ensureNotEmpty();
        E returnedValue = getAt(0);
        Collections.swap(elements, 0, size() - 1);
        elements.remove(size() - 1);
        heapifyDown(0);
        return returnedValue;
    }

    private E getLeftChild(int index) {
        return elements.get(getLeftChildIndex(index));
    }
    private E getRightChild(int index) {
        return elements.get(getRightChildIndex(index));
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void heapifyDown(int index) {
        while (getLeftChildIndex(index) < size() && isLess(index, getLeftChildIndex(index))) {
            int child = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if(rightChildIndex < size() && isLess(child, rightChildIndex)) {
                child = rightChildIndex;
            }
            Collections.swap(elements, child, index);
            index = child;
        }
    }
}
