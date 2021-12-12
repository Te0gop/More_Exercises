public class ArrayStructures {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    // Fills the Array with random values
    public void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {

            // Random number 10 through 19
            theArray[i] = (int)(Math.random() * 10) + 10;
        }
    }

    // Prints the Array on the screen in a grid
    public void printArray() {
        System.out.println("---------");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("| " + i + " |");
            System.out.println(theArray[i] + " |");
            System.out.println("---------");
        }
    }

    // Gets value at provided index
    public int getValueAtIndex(int index) {
        if(index < arraySize) return theArray[index];
        return 0;
    }

    // Returns true or false if a value is in the Array
    public boolean doesArrayContainThisValue(int searchValue) {
        boolean valueInArray = false;
        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == searchValue) {
                valueInArray = true;
                break;
            }
        }
        return valueInArray;
    }

    // Delete Array row for the index and move elements up
    public void deleteIndex(int index) {
        if(index < arraySize) {

            // Overwrite the value for the supplied index
            // and then keep overwriting every index that follows
            // until you get to the last index in the array

            for (int i = index; i < arraySize - 1; i++) {
                theArray[i] = theArray[i+1];
            }
            arraySize--;
        }
    }

    // Insert value in the last index
    public void insertValue(int value) {
        if(arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    // Linear Search : Every index must be looked at
    public void linearSearchForValue(int value) {
        boolean valueInArray = false;

        String indexWithValue = "";
        System.out.print("The value is found in the following indexes: ");

        for (int i = 0; i < arraySize; i++) {
            if(theArray[i] == value) {
                valueInArray = true;
                System.out.print(i + " ");
                indexWithValue += i + " ";
            }
        }
        if(!valueInArray) {
            indexWithValue = "None";
            System.out.println(indexWithValue);
        }
        System.out.println();
    }

    // This bubble sort will sort everything from
    // smallest to largest
    public void bubbleSort() {

        // i starts at the end of the Array
        // As it is decremented all indexes greater
        // then it are sorted

        for (int i = arraySize - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(theArray[j] > theArray[j + 1]) {
                    swapValues(j, j + 1);
                    //printHorzArray(i, j);
                }
            }
        }
    }

    private void swapValues(int indexOne, int indexTwo) {
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

        // The Binary Search is quicker than the linear search
        // because all the values are sorted. Because everything
        // is sorted once you get to a number larger than what
        // you are looking for you can stop the search. Also
        // you be able to start searching from the middle
        // which speeds the search. It also works best when
        // there are no duplicates
    public void binarySearchForValue(int value) {
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = (highIndex + lowIndex) / 2;

            if(theArray[middleIndex] < value) {
                lowIndex = middleIndex + 1;
            } else if(theArray[middleIndex] > value) {
                highIndex = middleIndex - 1;
            } else {
                System.out.println("\nFound a Match for " + value + " at index " + middleIndex);
                lowIndex = highIndex + 1;
            }
        }
    }
    public void selectionSort() {
        for (int x = 0; x < arraySize; x++) {
            int minimum = x;

            for (int y = x; y < arraySize; y++) {
                if(theArray[minimum] > theArray[y]) {
                    minimum = y;
                }
            }
            swapValues(x, minimum);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < arraySize; i++) {
            int j = i;
            int toInsert = theArray[i];
            while ((j > 0) && (theArray[j-1] > toInsert)) {
                theArray[j] = theArray[j-1];
                j--;
            }
            theArray[j] = toInsert;
        }
    }


    public static void main(String[] args) {
        ArrayStructures newArray = new ArrayStructures();

        newArray.generateRandomArray();
        newArray.printArray();
//        System.out.println(newArray.getValueAtIndex(3));
//        System.out.println(newArray.doesArrayContainThisValue(13));
//        newArray.deleteIndex(4);
//        newArray.printArray();
//        newArray.insertValue(55);
//        newArray.printArray();
//        newArray.linearSearchForValue(14);
//        newArray.bubbleSort();
//        newArray.printArray();
//        newArray.binarySearchForValue(11);
//        newArray.selectionSort();
        newArray.insertionSort();
    }

}
