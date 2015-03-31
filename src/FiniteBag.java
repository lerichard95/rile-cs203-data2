import java.util.Collection;

/**
 * FiniteBag is the API that abstracts from the implementations.
 * FiniteBag represents a multiset, a collection of elements that can occur multiple times
 * FiniteBag will be implemented...
 *
 * @param <T> The generic datatype that the FiniteBag will hold.
 */
public interface FiniteBag<T extends Comparable<T>> extends Iterable<T> {

    /**
     * @param item The generic item to be placed into the FiniteBag
     * @return A new instance of FiniteBag with the item added
     */
    public FiniteBag add(T item);

    /**
     * @param item The generic item
     * @return A boolean representing the
     */
    public boolean member(T item);

    public int multiplicity(T item);

    public boolean isEmpty();

    public int size();


}

