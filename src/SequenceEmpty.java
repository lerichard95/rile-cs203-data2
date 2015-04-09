/**
 * Represents an empty sequence
 */
public class SequenceEmpty<T> implements Sequence<T> {

    /**
     * Constructor is not needed
     */
    public SequenceEmpty() {
    }

    /**
     * Since an empty sequence doesn't have any more elements, represent this by returning an empty
     *
     * @return Returns a leaf from the empty sequence
     */
    public T here() {
        //TODO: Can throw an exception also-- see Sequence.java
        throw new RuntimeException("Cannot get the here() of a SequenceEmpty!");
    }

    /**
     * An empty sequence is empty so return false
     *
     * @return Always false
     */
    public boolean isSomethingThere() {
        return false;
    }

    /**
     * Since there is nothing in an empty sequence, keep returning empty sequences nothing
     *
     * @return Return an empty sequence
     */
    public Sequence<T> next() {
        return this;
    }


}
