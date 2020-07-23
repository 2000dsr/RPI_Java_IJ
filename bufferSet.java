package sample;
/**
 * class written from scratch to hold my circular ring buffer
 * 
 * @author dr
 */
public class bufferSet {

    public bufferSetObject head;
    public bufferSetObject tail;
    public int size;
    public static int maxSize = 10;

    public bufferSet() { // for now this is hard coded for frame class. whoops
        this.head = null;
        this.tail = null;

    }

    public void add(bufferSetObject picture) {
        if (head == null && tail == null) { // brand new set
            this.head = picture;
            this.size++; // always add to the size when one is added without a remove
        } else if (this.size < maxSize) { // if there is room to add without removing
            this.tail = picture;
            this.size++; // increment size by 1 because added without a remove
        }

        else { // max size was reached
            this.head = head.next; // increase the head by 1, effectively deleting the head
            this.tail = picture; // make the tail the new frame

        }

    }

    @SuppressWarnings("finally")
    public String toString() {
        String s = "";
        for (bufferSetObject t = head; t != tail; t = t.next) { // iterate through each object
            s += t.toString() + " ";
            if (t.next == tail) {
                try {
                    s += t.next.toString();
                } finally { // in case of nullPointerException
                    continue;
                }
            }
        }
        return s;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

}
