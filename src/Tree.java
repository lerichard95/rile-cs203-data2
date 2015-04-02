/**
 * Tree is a concrete implementation of FiniteBag— this will be the AVL tree...
 *
 * @param <T> A generic type that must extend Comparable<T>
 */

public class Tree<T extends Comparable<T>> implements FiniteBag<T> {
    // Instance variables for a Tree
    FiniteBag<T> left;
    T key;
    int count;
    FiniteBag<T> right;

    /**
     * Constructor will create a new instance of Tree
     *
     * @param l FiniteBag to be stored on the left side
     * @param k Key: generic item being held
     * @param c Count, represents cardinality of k— number of instances of k that are held
     * @param r FiniteBag to be stored on the right side
     */
    Tree(FiniteBag<T> l, T k, int c, FiniteBag<T> r) {
        // assign inputs of a new instance
        // to the instance variables specified above
        this.left = l;
        this.key = k;
        this.count = c;
        this.right = r;
    }

    /**
     * String representation used for console printing
     *
     * @return String representation of Tree
     */
    public String toString() {
        return "Tree(" + this.left.toString() + ", "
                + this.key + ", "
                + this.count + ", "
                + this.right.toString() + ")";
    }

    /**
     * Creates a new empty Tree
     *
     * @return Returns a new FiniteBag— a leaf representing empty
     */
    public FiniteBag<T> empty() {
        return new Leaf();
    }

    /**
     * Returns the number of elements in the tree
     *
     * @return int representing the number of elements in the tree
     */
    public int size() {
        // Count 1 for self,
        // add the cardinality of the left and right Tree's
        return 1 + this.left.size() + this.right.size();
    }

    /**
     * @return Boolean if the Tree is empty or not
     */
    public boolean isEmptyHuh() {
        // Tree can never be empty. Leaf is used to represent empty nodes.
        return false;
        // return this.cardinality() == 0;
    }

    /**
     * Returns the multiplicity of the item
     *
     * @param item the item whose multiplicity will be given
     * @return int representing multiplicity of the item of key
     */
    public int multiplicity(T item) {
        if (item.compareTo(this.key) == 0) {
            return this.count;
        } else if (item.compareTo(this.key) <= 0) {
            return this.left.multiplicity(item);
        } else {
            return this.right.multiplicity(item);
        }
    }

    /**
     * Returns true if blt is contained in Tree
     *
     * @param blt The item that will be checked in Tree
     * @return true is blt is contained in Tree
     */
    public boolean member(T blt) {
        if (this.key.equals(blt)) {
            return true;
        }
        // left and right need to be instance variables
        // of type Tree in order for finite set to hold
        // a Leaf at the bottom...
        // What if this.left/right is a Leaf???
        // Implement member for Leaf also?
        else if (this.left.member(blt)) {
            return true;
        }
        // If the current key ever matches,
        // control will flow only to return true
        return this.right.member(blt);
    }

    /**
     * @param elt The item to be inserted
     * @return A new FiniteSet containing elt
     */
    //TODO: AVL Tree version of add function
    public FiniteBag<T> add(T elt) {
        // Thanks to Atticus K for a better way to imagine adding "nodes"

        // key == elt
        // Just return the Tree
        if ((this.key.compareTo(elt) == 0)) {
            return this;
        }

        // elt < key
        // Returning a new Tree allows a tree to be "rebuilt" upon
        // successive recursive calls
        //
        // The new Tree should hold the current key, preseve the Tree
        // that will not be modified, and call add() on the respective Tree
        // that elt should belong to...
        //
        //
        // When add() reaches a Leaf, the add() implementation for Leaf will
        // create a Tree that holds elt, with Leaf for left and right.
        // Since this is the last return, recursion will stop, and the
        // new instances of Tree built on successive add() calls will
        // return a new root Tree, making add() a pure implementation.
        //

        //TODO: Comparison less than
        if (elt.compareTo(this.key) < 0) {
            return new Tree(left.add(elt), key, right);
        }

        //TODO: Comparison greater than
        // elt > this.key
        else {
            return new Tree(left, key, right.add(elt));
        }
    }

    /**
     * Removes elt from the Tree
     *
     * @param elt item— irrelevant and not used
     * @return A new Leaf
     */

    // TODO: AVL version of remove, remember to use Comparable functions
    public FiniteBag<T> remove(T elt) {

        // Thanks to Atticus K for this implementation
        if (elt < this.key) {
            // Returning a new Tree allows each recursive call
            // to "rebuild" the Tree tree
            return new Tree(this.left.remove(elt), key, right);
        }

        if (elt > this.key) {
            return new Tree(left, key, this.right.remove(elt));
        } else {
            // Combine the left and right trees but ignore the current key
            return this.left.union(this.right);
        }

    }

    /**
     * Returns a new instance of FiniteSet that represents the union of this FiniteBag and u
     *
     * @param u FiniteBag to be unioned with
     * @return FiniteBag representing the union of u and .this
     */
    // TODO: Implement AVL version of union
    public FiniteBag<T> union(FiniteBag<T> u) {
        // Thanks to Nicholas B for explaining the recursive nature of this
        return u.union(this.left).union(this.right).add(this.key);
        // What happens:
        // Recursive call union of "this" to u,
        // union will "travel" down the left Tree of the root Tree
        // When each union call reaches the base case (a Leaf), it will return
        // Tree u, and then call union of that onto the right tree,
        // Finally, the key will be added to the Tree containing
        // the left and right trees.
    }

    /**
     * @param u FiniteBag to be intersected with
     * @return A new FiniteBag representing the intersection of u and this Tree
     */
    //TODO: Implement AVL intersection
    //Thanks to Atticus K for implementation
    public FiniteBag<T> inter(FiniteBag<T> u) {
        if (u.member(this.key)) {
            //  If the current Tree fulfills being in
            //  u, return a new Tree that calls the intersection of u
            //  with the intersection of the left child, as well as the inter
            //  -section of the right child and u.
            //  (Recursively call inter on left and right children)
            //  Preserve current key

            return new Tree(this.left.inter(u), this.key, this.count + 1,
                    this.right.inter(u));
        }
        //  else case: current key is not a member of u,
        //  return the union of the left child with right child,
        //  and intersect that with u—
        //  Union the left and right children,
        //  Use that set to compare with u again
        else {
            return this.left.union(this.right).inter(u);
        }
    }

    /**
     * @param u represents the FiniteBag to be difference'd with current Tree
     * @return FiniteBag representing the difference of the current Tree with u
     */
    // TODO: Implement AVL difference
    //Thanks to Atticus K for implementation
    public FiniteBag<T> diff(FiniteBag<T> u) {
        //  start by unioning the left/right children,
        //  then recursive call diff with a new input
        //  remove the current key from u— if there is not overlap between sets,
        //  remove() will return the same set u

        return this.left.union(this.right).diff(u.remove(this.key));
    }

    /**
     * @param u FiniteBag to be compared to
     * @return True if this Tree is a subset of u
     */
    //  Thanks to Atticus K for implementation of subset and equal
    public boolean subset(FiniteBag<T> u) {
        //  Checks if current key is a member of u,
        //  Then recursively calls subset on left/right branches
        return u.member(this.key) && this.left.subset(u) && this.right.subset(u);
    }

    /**
     * Checks if Trees are the same elements
     *
     * @param u Tree to be compared with
     * @return True if u has same elements as this Tree
     */
    public boolean equal(FiniteBag<T> u) {
        //  By definition of subset,
        //  sets this and u are equivalent if
        //  this and u are subsets of each other.
        return this.subset(u) && u.subset(this);
    }


}