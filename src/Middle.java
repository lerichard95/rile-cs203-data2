/**
 * Middle is a special type of Sequence that represents the sequence of a key, with multiplicity count.
 * Created by richard on 4/8/15.
 */
public class Middle<T> implements Sequence<T>, Sequenced<T> {
    T item;
    int count;

    public Middle(T im, int ct) {
        this.item = im;
        this.count = ct;
    }

    /**
     * Returns a sequence of the item, repeated ct times
     *
     * @return Sequence representing sequence of the item many times
     */
    public Sequence<T> seq() {
        Sequence<T> midSeq = this;
        for (int i = count - 1; i >= 0; i--) {
            midSeq = new Combine<T>(
                    midSeq,
                    new Middle<T>(this.item, i));
        }
        return midSeq;
    }

    /**
     * Return the current item of the sequence.
     *
     * @return Type t, current item of the sequence
     */
    public T here() {
        return this.item;

    }

    /**
     * Determine if the sequence is empty
     *
     * @return true is the sequence is empty
     */
    public boolean isSomethingThere() {
        // Should return true only if the item's count > 0
        return this.count > 0;
    }

    /**
     * Returns a sequence representing the next element of a sequence
     *
     * @return return this
     */
    public Sequence<T> next() {
        return this;
        // Doesn't matter what this returns— should never be used anyway?
        // Semantically meaningless to return the next item?
        // throw new RuntimeException( "Cannot return next() of a Middle()" );
    }

    /**
     * toString for println's
     *
     * @return String representing a Middle seq
     */
    public String toString() {
        return "Middle{" +
                "item=" + item +
                ", count=" + count +
                '}';
    }
}

