/**
 * Created by richard on 4/8/15.
 */
public class Middle<T> implements Sequence<T>, Sequenced<T> {
    Sequenced<T> item;
    int count;

    public Middle(Sequenced<T> im, int ct) {
        this.item = im;
        this.count = ct;
    }

    /**
     * seq() is an ITERATOR, a procedure which returns a GENERATOR (a Sequence)
     *
     * @return A generator which produces elements that will be iterated over
     */
    @Override
    public Sequence<T> seq() {
        Sequence<T> midSeq = item.seq();
        //Combine<T>(this.item.seq(), this.item.seq());
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
        return item.seq().here();
    }

    /**
     * Determine if the sequence is empty
     *
     * @return true is the sequence is empty
     */
    public boolean isSomethingThere() {
        return false;
    }

    /**
     * Returns a sequence containing the next element in the sequence
     *
     * @return return the next node (not item) in the sequence
     */
    public Sequence<T> next() {
        return null;
    }

}

