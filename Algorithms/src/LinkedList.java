public class LinkedList {

    public String bookName;
    public int millionsSold;
    public LinkedList next;

    public LinkedList(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        System.out.println(bookName + ": " + millionsSold + ",000,000");
    }

    @Override
    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {

        LinkList linkedList = new LinkList();

        linkedList.insertFirstLink("Don Quixote", 500);
        linkedList.insertFirstLink("A Tale of Two Cities", 200);
        linkedList.insertFirstLink("The Lord Of The Rings", 150);
        linkedList.insertFirstLink("Harry Potter", 250);

        linkedList.display();
        linkedList.removeFirst();
        linkedList.display();

    }


}

class LinkList {
    public LinkedList firstLink;

    public LinkList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return (firstLink == null);
    }
    public void insertFirstLink(String bookname, int millionsSold) {
        LinkedList newLink = new LinkedList(bookname, millionsSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public LinkedList removeFirst() {
        LinkedList linkReference = firstLink;

        if(!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty LinkedList.");
        }
        return linkReference;
    }
    public void display() {
        LinkedList theLink = firstLink;

        while (theLink != null) {
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }
    public LinkedList find(String bookName) {
        LinkedList theLink = firstLink;

        if(!isEmpty()) {
            while(theLink.bookName != bookName) {
                if(theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList.");
        }
        return theLink;
    }

    public LinkedList removeLink(String bookName) {
        LinkedList currentLink = firstLink;
        LinkedList previousLink = firstLink;

        while (currentLink.bookName != bookName) {
            if(currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if(currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

}


