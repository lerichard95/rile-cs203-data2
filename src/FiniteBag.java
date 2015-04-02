import java.util.Collection;

/**
 * FiniteBag is the API that abstracts from the implementations.
 * FiniteBag represents a multiset, a collection of elements that can occur multiple times
 * FiniteBag will be implemented...
 *
 * @param <T> The generic datatype that the FiniteBag will hold.
 */
public interface FiniteBag<T extends Comparable<T>> {

    /**
     * @param item The generic item to be placed into the FiniteBag
     * @return A new instance of FiniteBag with item added
     */
    public FiniteBag<T> add(T item);

    /**
     * @param item The generic item to be removed from the FiniteBag
     * @return A new instance of FiniteBag with item removed
     */
    public FiniteBag<T> remove(T item);

    /**
     * @param item The generic item
     * @return A boolean representing the
     */
    public boolean member(T item);

    /**
     * @param item The generic item to calculate multiplicity of
     * @return An int representing the multiplicity of the element
     */
    public int multiplicity(T item);

    /**
     * @return A boolean if the FiniteBag is empty
     */
    public boolean isEmptyHuh();

    /**
     * @return An int representing the cardinality of the FiniteBag
     */
    public int size();

    // Set property stuff
    public FiniteBag<T> union(FiniteBag<T> b);

    public FiniteBag<T> inter(FiniteBag<T> b);

    //TODO: Don't do sum— multiset sum will be done in place of union.
//    public FiniteBag<T> sum(FiniteBag<T> b);

    public FiniteBag<T> diff(FiniteBag<T> b);


}

