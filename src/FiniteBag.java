/**
 * FiniteBag is the API that abstracts from the implementations.
 * FiniteBag represents a multiset, a collection of elements that can occur multiple times
 * FiniteBag will be implemented...
 *
 * @param <T> The generic datatype that the FiniteBag will hold.
 */
public interface FiniteBag<T extends Comparable<T>> extends Sequenced<T> {

    /* Iteration abstraction functions */

    /* End iteration abstraction functions */

    /**
     * Increase the multiplicity of item in the FiniteBag by 1
     *
     * @param item Item whose multiplicity will be incremented by 1
     * @param n    Multiplicity to be incremented by 1
     * @return A new instance of FiniteBag with the multiplicity of item incremented by 1
     */
    FiniteBag<T> add(T item);

    /**
     * @param item The generic item to be placed addCount times into the FiniteBag
     * @param n    The multiplicity of item to be added to the multiset
     * @return A new FiniteBag with the elements added
     */
    FiniteBag<T> addN(T item, int n);

    /**
     * Decrease the multiplicity of item in the FiniteBag by 1
     *
     * @param item Item whose multiplicity will be incremented by n
     * @return A new instance of FiniteBag with the multiplicity of item decremented by 1
     */
    FiniteBag<T> remove(T item);

    /**
     * Decrease the multiplicity of item in the FiniteBag by n
     *
     * @param item Item whose multiplicity will be decremented by n
     * @param n    Multiplicity to be decremented by n
     * @return A new instance of FiniteBag with the multiplicity of item decremented by n
     */
    FiniteBag<T> removeN(T item, int n);

    /**
     * @param item The generic item
     * @return A boolean representing if the item is in the FiniteBag
     */
    boolean member(T item);

    /**
     * @param item The generic item to calculate multiplicity of
     * @return An int representing the multiplicity of the element
     */
    int multiplicity(T item);

    /**
     * @return A boolean if the FiniteBag is empty
     */
    boolean isEmptyHuh();

    /**
     * @return An int representing the cardinality of the FiniteBag
     */
    int size();

    // Set property stuff

    // Multiset union- add the multiplicities together
    FiniteBag<T> union(FiniteBag<T> b);

    FiniteBag<T> inter(FiniteBag<T> b);

    boolean isSubset(FiniteBag<T> b);

    public FiniteBag<T> diff(FiniteBag<T> b);

    boolean isEqual(FiniteBag<T> b);

    // TODO: Don't do sum— multiset sum will be done in place of union.
    //FiniteBag<T> sum(FiniteBag<T> b);

}