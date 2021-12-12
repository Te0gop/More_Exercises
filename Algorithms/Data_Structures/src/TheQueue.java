import java.util.Arrays;

public class TheQueue {

    private String[] queueArray;
    private int queueSize;
    private int front, rear, numberOfItems = 0;

    public TheQueue(int queueSize) {
        this.queueSize = queueSize;
        queueArray = new String[queueSize];
        Arrays.fill(queueArray, "-1");
    }

    public void insert(String input) {
        if(numberOfItems + 1 <= queueSize) {
            queueArray[rear] = input;
            rear++;
            numberOfItems++;
            System.out.println("INSERT " + input + " was added to the Queue.");
        } else {
            System.out.println("Queue is full.");
        }
    }

    public void remove() {
        if(numberOfItems > 0) {
            System.out.println(queueArray[front] + " was removed from the Queue.");
            queueArray[front] = "-1";
            front++;
            numberOfItems--;
        } else {
            System.out.println("The Queue is empty.");
        }
    }

    public void peek() {
        System.out.println("The first element is " + queueArray[front]);
    }

    public void priorityInsert(String input) {
        int i;

        if(numberOfItems == 0){

            insert(input);

        } else {

            for(i = numberOfItems-1; i >= 0; i--){
                if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
                    queueArray[i+1] = queueArray[i];
                } else {
                    break; // Done shifting items in queue
                }
            }
            queueArray[i+1] = input;
            rear++;
            numberOfItems++;
        }
    }

    public static void main(String[] args) {

        TheQueue theQueue = new TheQueue(10);
//        theQueue.insert("10");
//        theQueue.insert("15");
//        theQueue.insert("11");
//        theQueue.remove();
//        theQueue.peek();
        theQueue.priorityInsert("10");
        theQueue.priorityInsert("119");
        theQueue.priorityInsert("11");
    }
}
