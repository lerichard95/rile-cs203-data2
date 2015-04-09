/**
 * Created by richard on 4/8/15.
 */
public class Combine<T> implements Sequence<T>, Sequenced<T> {
    Sequence<T> one;
    Sequence<T> two;

    public Combine(Sequence<T> ll, Sequence<T> rr) {
        this.one = ll;
        this.two = rr;
    }

    /**
     * seq() is an ITERATOR, a procedure which returns a GENERATOR (a Sequence)
     *
     * @return A Sequence
     */
    @Override
    public Sequence<T> seq() {
        return this;
    }

    /**
     * Return the current item of the sequence.
     *
     * @return Type t, current item of the sequence
     */
    public T here() {
        if (one.isSomethingThere()) {
            return this.one.here();
        } else {
            return this.two.here();
        }

    }

    /**
     * Determine if the sequence is empty
     *
     * @return true is the sequence is empty
     */
    public boolean isSomethingThere() {
        return one.isSomethingThere() || two.isSomethingThere();
    }

    /**
     * Returns a sequence containing the next element in the sequence
     *
     * @return return the next node (not item) in the sequence
     */
    public Sequence<T> next() {
        if (one.isSomethingThere()) {
            return new Combine<T>(this.one.next(), this.two);
        } else {
            return this.two.next();
        }
    }

}
