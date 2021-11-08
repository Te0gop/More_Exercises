import java.util.Arrays;

public class TheStack {
    private String[] stackArray;

    private int stackSize;
    private int topOfStack = -1;

    public TheStack(int size) {
        this.stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {

        if(topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        } else {
            System.out.println("The Stack is full");
        }
        System.out.println("PUSH " + input + " was added to the Stack.");
    }

    public String pop() {
        if(topOfStack >= 0) {
            System.out.println("POP " + stackArray[topOfStack] + " was removed from the Stack.");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        } else {
            System.out.println("The Stack is empty.");
            return "-1";
        }
    }

    public String peek() {
        System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the Stack.");
        return stackArray[topOfStack];
    }

    public void pushMany(String multipleValues) {
        String[] tempString = multipleValues.split(" ");
        for (int i = 0; i < tempString.length; i++) {
            push(tempString[i]);
        }
    }

    public void popAll() {
        for (int i = topOfStack; i >= 0 ; i--) {
                pop();
        }
    }

    public static void main(String[] args) {

        TheStack stack = new TheStack(10);

        stack.push("10");
        stack.push("15");
        stack.peek();
        stack.pop();
        stack.pushMany("12 13 15 17");
        stack.popAll();

    }
}
