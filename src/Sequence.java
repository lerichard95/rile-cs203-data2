/**
 * Sequence is a generator- produces the elements used in the iteration
 * Created by richard on 4/3/15.
 */
public interface Sequence<T extends Comparable<T>> {
    /**
     *  Return the current item of the sequence.
     * @return Type t, current item of the sequence
     */
    public T here();

    /**
     * Determine if the sequence is empty
     * @return true is the sequence is empty
     */
    public boolean notEmpty();

    /**
     * Returns a sequence containing the next element in the sequence
     * @return return the next node (not item) in the sequence
     */
    public Sequence<T> next();
    // If notEmpty returns false, then next() can return anything and
    // here() can return anything

}
