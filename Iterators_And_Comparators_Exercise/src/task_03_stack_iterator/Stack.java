package task_03_stack_iterator;

import java.util.Iterator;

public class Stack implements Iterable<Integer>{

    private Integer[] elements;
    private int currentIndex;

    public Stack() {
        this.elements = new Integer[16];
        this.currentIndex = 0;
    }

    public void push(Integer... elements) {
        for (Integer element : elements) {
            this.elements[currentIndex++] = element;
        }
    }

    public void pop() {
        if (elements[0] == null) {
            System.out.println("No elements");
        } else {
            elements[--currentIndex] = null;
        }
    }



    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return currentIndex > 0;
            }

            @Override
            public Integer next() {
                return elements[--currentIndex];
            }
        };
    }

}
