package sample;
public class bufferSetObject {


    public bufferSetObject next;
    public bufferSetObject prev;
    public static bufferSetObject mostRecent = null; // the most recently created bufferSetObject
    public frame photo;

    /**
     * Creates a bufferSetObject for a specific set 
     * @param photo the picture
     * @param setToAdd the set to put it into
     */
    public bufferSetObject(bufferSet setToAdd, frame photo) {
        this.photo = photo;
        if (mostRecent != null) {
            mostRecent.next = this;// mostRecent links to new one
            this.prev = mostRecent; // new one backLinks to mostRecent
        }

        mostRecent = this; // advance mostRecent to newest one
        setToAdd.add(this);

    }

    public String toString() {
        return this.photo.toString();
    }

}


