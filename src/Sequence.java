/**
 * A sequence is similar to a list, but has pay-as-you-go performance
 *
 *
 */
public interface Sequence<E> {
    /**
     *  Return the current item of the sequence.
     * @return Type t, current item of the sequence
     */
    public E here();

    /**
     * Determine if the sequence is empty
     * @return true is the sequence is empty
     */
    public boolean isSomethingThere();

    /**
     * Returns a sequence containing the next element in the sequence
     * @return return the next node (not item) in the sequence
     */
    public Sequence<E> next();
    // If isSomethingThere returns false, then next() can return anything and
    // here() can return anything

}
