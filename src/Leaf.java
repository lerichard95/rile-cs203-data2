/**
 * Leaf represents an empty node
 *
 * @param <T> Generic type for the Leaf
 */
public class Leaf<T extends Comparable<T>> implements FiniteBag<T> {

    /* Iteration abstraction functions */

    /**
     * Returns a sequence of Leaf
     *
     * @return Returns an SequenceEmpty
     */
    public Sequence<T> seq() {
        return new SequenceEmpty<T>();
    }

    /* End iteration abstraction functions */


    /**
     * A Leaf represents an empty node.
     */
    Leaf() {
    }

    /**
     * This function does the same as the constructor
     *
     * @return An empty Leaf
     */
    public Leaf empty() {
        //Note on constructor: It seems OK to use Leaf() for left/right because
        //Leaf implements Tree
        return new Leaf();
    }

    /**
     * Used for debugging purposes— printing to console
     *
     * @return A string representing a leaf
     */

    public String toString() {
        return "Leaf()";
    }

    /**
     * Number of elements in the set
     *
     * @return An int representing the cardinality of the Leaf— should return zero!
     */
    public int size() {
        //Empty finite set
        return 0;
    }

    /**
     * @return Boolean if the Leaf is empty or not
     */
    public boolean isEmptyHuh() {
        //Leaves are always empty
        return true;
    }

    /**
     * Returns true if blt is contained in Leaf
     *
     * @param blt The item that will be checked in Leaf
     * @return false since nothing is inside Leaf
     */
    public boolean member(T blt) {
        return false;
    }

    /**
     * @param elt The item to be inserted
     * @return a new Tree with elt for key, and 1 for count.
     */
    public FiniteBag<T> add(T elt) {
        //Return a new Tree with empty left/rights
        //with the added key elt
        return new Tree<T>(new Leaf<T>(), elt, 1, new Leaf<T>());
    }

    /**
     * @param item The generic item to be placed addCount times into the FiniteBag
     * @param n    The multiplicity of item to be added to the multiset
     * @return a new Tree with elt for key, and n for count
     */
    public FiniteBag<T> addN(T item, int n) {
        return new Tree<T>(new Leaf<T>(), item, n, new Leaf<T>());
    }

    /**
     * Just returns a Leaf since items cannot be removed from the empty set
     *
     * @param elt item— irrelevant and not used
     * @return A new Leaf
     */
    public FiniteBag<T> remove(T elt) {
        return new Leaf<T>();
    }

    /**
     * @param item Item whose multiplicity will be decremented by n
     * @param n    Multiplicity to be decremented by n
     * @return A new Tree with item's count decremented by n
     */
    public FiniteBag<T> removeN(T item, int n) {
        return new Leaf<T>();
    }

    /**
     * Calls .isEmptyHuh() function from u
     *
     * @param u The FiniteBag to be compared
     * @return Returns true if u is empty
     */
    public boolean equals(FiniteBag<T> u) {
        return (u.isEmptyHuh());
    }


    //Thanks to Atticus K for this
    //And Nicholas B for explaining how this works

    /**
     * Returns a new instance of FiniteBag that represents the union of this FiniteBag and u
     *
     * @param u FiniteBag to be unioned with
     * @return FiniteBag representing the union of u and .this
     */
    public FiniteBag<T> union(FiniteBag<T> u) {
        return u;
    }

    /**
     * @param u FiniteBag to be intersected with the current Leaf
     * @return FiniteBag representing the intersection of the current Leaf with the FiniteBag
     */
    public FiniteBag<T> inter(FiniteBag<T> u) {
        return new Leaf<T>();
    }

    /**
     * @param u represents the FiniteBag to be difference'd with current Leaf
     * @return FiniteBag representing the difference of the current Leaf with the FiniteBag
     */
    public FiniteBag<T> diff(FiniteBag<T> u) {
        return u;
    }

    /**
     * @param u FiniteBag to be compared to
     * @return True if leaf is a subset of u
     */
    public boolean isSubset(FiniteBag<T> u) {
        //  leaf.subset(u) means is leaf a subset of u
        //The empty set is a subset of any set so return true
        return true;
    }

    /**
     * @param u FiniteBag to be compared with
     * @return True if FiniteBag is equal to this Leaf
     */
    public boolean isEqual(FiniteBag<T> u) {
        //if u is empty, then it is equal to the empty set
        return u.isEmptyHuh();
    }

    /**
     * @param item The generic item to calculate multiplicity of
     * @return int representing the multiplicity
     */
    public int multiplicity(T item) {
        return 0;
    }


}