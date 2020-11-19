import java.util.function.Consumer;

public class SmartArray {

    private int[] elements;
    private int index;

    public SmartArray() {
        this.elements = new int[10];
        this.index = 0;
    }

    public void add(int element) {
        if(index == this.elements.length) {
            elements = grow();
        }
        elements[index]  = element;
        index++;
    }

    private int[] grow() {
        int[] newElement = new int[this.elements.length * 2];
        System.arraycopy(elements, 0, newElement, 0, elements.length);
        return newElement;
    }

    public int get(int index) {
        ensureIndex(index);
        return this.elements[index];
    }

    public int size() {
        return index;
    }

    public int remove(int index) {
        int element = get(index);

        for (int i = index; i < size() - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size()] = 0;
        this.index--;

        if(size() <= elements.length / 4) {
            elements = shrink();
        }
        return element;
    }

    private int[] shrink() {
        int[] newElements = new int[elements.length / 2];
        if (size() >= 0) {
            System.arraycopy(elements, 0, newElements, 0, size());
        } else if(size() == 0) {
            elements = new int[8];
        }
        return newElements;
    }

    private void ensureIndex(int index) {
        if(index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("SmartArray out of bounds for " + "index "
                    + index + " with size " + size());
        }
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }
    public int indexOf(int element) {
        for (int i = 0; i < size(); i++) {
            if(element == elements[i]) {
                return i;
            }
        }
        return -1;
    }
    public void add(int index, int element) {
        ensureIndex(index);
        int last = get(size() - 1);

        for (int i = size() - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        
        elements[index] = element;
        add(last);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size(); i++) {
            consumer.accept(elements[i]);
        }
    }

}
