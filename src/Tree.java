/**
 * Tree is a concrete implementation of FiniteBag— this will be the AVL tree...
 */

public class Tree<T extends Comparable<T>> implements FiniteBag<T>, Sequence<T> {
    /**
     * Tree state variables are private as to not expose rep
     */
    FiniteBag<T> left;
    T key;
    int count;
    FiniteBag<T> right;
    int height = 1;

    /**
     * Constructor will create a new instance of Tree
     *
     * @param l FiniteBag to be stored on the left side
     * @param k Key: generic item being held
     * @param c Count, represents cardinality of k— number of instances of k that are held
     * @param r FiniteBag to be stored on the right side
     * @param h height of the tree
     */
    Tree(FiniteBag<T> l, T k, int c, FiniteBag<T> r, int h) {
        // assign inputs of a new instance
        // to the instance variables specified above
        this.left = l;
        this.key = k;
        this.count = c;
        this.right = r;
        // "calculate the height"
        Tree<T> castLeft = (Tree<T>) this.left;
        Tree<T> castRight = (Tree<T>) this.left;
        this.height = Math.max(castLeft.height, castRight.height) + this.height;
    }

    /**
     * Get the height of this Tree
     *
     * @return int height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns a sequence of the Tree
     *
     * @return A Sequence of the elements of Tree...
     */
    public Sequence<T> seq() {
        return new Combine<T>(
                // Sequence of this.key, repeated count times
                new Middle<T>(this.key, this.count),
                // Sequence of both the left and right sequences
                new Combine<T>(left.seq(), right.seq())
        );
    }

    /**
     * Return the current item of the sequence.
     *
     * @return key - the key of
     */
    public T here() {
        return this.key;
    }

    /**
     * Determine if there is something inside the sequence. Always true for Tree branches because
     * empty Sequence is represented with SequenceEmpty
     *
     * @return true if the sequence contains something
     */
    public boolean isSomethingThere() {
        return true;
    }

    /**
     * Returns a sequence containing the next element in the sequence
     *
     * @return return the next node (not item) in the sequence
     */
    public Sequence<T> next() {
        return new Combine<T>(this.left.seq(), this.right.seq());
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
        return new Leaf<T>();
    }

    /**
     * Returns the number of elements in the tree
     *
     * @return int representing the number of elements in the tree
     */
    public int size() {
        int mySize = 0;

        if (this.count > 0) {
            mySize = 1;
        }

        return mySize + this.left.size() + this.right.size();
    }

    /**
     * Always returns true because there is always something in a Tree
     *
     * @return Boolean if the Tree is empty or not
     */
    public boolean isEmptyHuh() {
        boolean amIEmpty = false;
        if (this.count <= 0) {
            amIEmpty = true;
        }
        return amIEmpty && this.left.isEmptyHuh() && this.right.isEmptyHuh();
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
        if (this.key.equals(blt) && (this.count > 0)) {
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
     * @param item The generic item to be placed addCount times into the FiniteBag
     * @return a new FiniteBag with item added, and appropriate value changed
     */
    public FiniteBag<T> add(T item) {
        return this.addN(item, 1);
    }


    /**
     * @param elt The item to be inserted
     * @return A new FiniteSet containing elt
     */
    //TODO: AVL Tree version of add function
    public FiniteBag<T> addN(T elt, int n) {
        // Thanks to Atticus K for a better way to imagine adding "nodes"

        // key == elt
        // Just return the Tree
        if ((this.key.compareTo(elt) == 0)) {
            return new Tree<T>(this.left, this.key, this.count + n, this.right, this.height);
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

        // Comparison less than
        if (elt.compareTo(this.key) < 0) {
            return new Tree<T>(left.addN(elt, n), key, this.count, right, this.height);
        }

        // Comparison greater than
        // elt > this.key
        else {
            return new Tree<T>(left, key, this.count, right.addN(elt, n), this.height);
        }
    }


    // TODO: AVL version of add

    /**
     * Removes an element from the Tree— by setting the multiplicity of an element to to 0
     *
     * @param elt T to be removed from the tree— node will stay but multiplicity is reset.
     * @return FiniteBag where the element elt was changed
     */
    public FiniteBag<T> remove(T elt) {
        // Thanks to Atticus K for this implementation

        // Enter the left tree
        if (elt.compareTo(this.key) < 0) {
            // Returning a new Tree allows each recursive call
            // to "rebuild" the tree
            return new Tree<T>(this.left.remove(elt), this.key, this.count, this.right, this.height);
        }
        // Enter the right tree
        if (elt.compareTo(this.key) > 0) {
            return new Tree<T>(this.left, this.key, this.count, this.right.remove(elt), this.height);
        } else {
            return new Tree<T>(this.left, this.key,
                    // Reset the multiplicity to 0
                    0,
                    this.right, this.height - 1);
            // Combine the left and right trees but ignore the current key
            //return this.left.union(this.right);
        }

    }

    /**
     * @param item Item whose multiplicity will be decremented by n
     * @param n    Multiplicity to be decremented by n
     * @return FiniteBag where the multiplicity of item was decreased by n
     */
    public FiniteBag<T> removeN(T item, int n) {

        // Thanks to Atticus K for this implementation

        // Enter the left tree
        if (item.compareTo(this.key) < 0) {
            // Returning a new Tree allows each recursive call
            // to "rebuild" the tree
            return new Tree<T>(this.left.remove(item), this.key, this.count, this.right, 1);
        }
        // Enter the right tree
        if (item.compareTo(this.key) > 0) {
            return new Tree<T>(this.left, this.key, this.count, this.right.remove(item), 1);
        }
        // Assuming that compareTo will be equal - optimization: don't have to run Compare
        // Only do this if count - n is non-negative
        if ((this.count - n) >= 0) {
            return new Tree<T>(this.left, this.key,
                    // Subtract n from count
                    this.count - n,
                    this.right, 1);
        }
        // Return the node with multiplicity of 0 if n is bigger than countv
        else {
            return new Tree<T>(this.left, this.key,
                    // Reset the multiplicity to 0
                    0,
                    this.right, 1);
            // Combine the left and right trees but ignore the current key
            //return this.left.union(this.right);
        }
    }


    /**
     * Returns a new instance of FiniteSet that represents the union of this FiniteBag and u
     *
     * @param u FiniteBag to be unioned with
     * @return FiniteBag representing the union of u and .this
     */
    public FiniteBag<T> union(FiniteBag<T> u) {
        // Thanks to Nicholas B for explaining the recursive nature of this

        return u.union(this.left).union(this.right).addN(this.key, this.count);
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
    //Thanks to Atticus K for implementation
    public FiniteBag<T> inter(FiniteBag<T> u) {
        if (u.member(this.key)) {
            //  If the current Tree fulfills being in
            //  u, return a new Tree that calls the intersection of u
            //  with the intersection of the left child, as well as the inter
            //  -section of the right child and u.
            //  (Recursively call inter on left and right children)
            //  Preserve current key

            return new Tree<T>(
                    this.left.inter(u),
                    this.key,
                    Math.min(this.count, u.multiplicity(this.key)),
                    this.right.inter(u), 1);
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
    //Thanks to Atticus K for implementation
    public FiniteBag<T> diff(FiniteBag<T> u) {
        //  start by unioning the left/right children,
        //  then recursive call diff with a new input
        //  remove the current key from u— if there is not overlap between sets,
        //  remove() will return the same set u

        return this.left.union(this.right).diff(u.removeN(this.key, this.count));
    }

    /**
     * @param u FiniteBag to be compared to
     * @return True if this Tree is a subset of u
     */
    //  Thanks to Atticus K for implementation of subset and equal
    public boolean isSubset(FiniteBag<T> u) {
        //  Checks if current key is a member of u,
        //  Then recursively calls subset on left/right branches
        return u.member(this.key) && this.left.isSubset(u) && this.right.isSubset(u);
    }

    /**
     * Checks if Trees are the same elements
     *
     * @param u Tree to be compared with
     * @return True if u has same elements as this Tree
     */
    public boolean isEqual(FiniteBag<T> u) {
        //  By definition of subset,
        //  sets this and u are equivalent if
        //  this and u are subsets of each other.
        return this.isSubset(u) && u.isSubset(this);
    }

    /**
     * Determines if current Tree node is AVL balanced
     *
     * @return True is it is balanced
     */
    public boolean amIAVLBalanced() {
        Tree<T> castLeft = (Tree<T>) this.left;
        Tree<T> castRight = (Tree<T>) this.left;

        int min = Math.min(castLeft.height, castRight.height);
        int max = Math.max(castLeft.height, castRight.height);
        return (min <= max) && (max <= min);
    }

    /**
     * Perform a right rotation on this tree branch
     *
     * @return a new FiniteBag, rotated right
     */

    public FiniteBag<T> rotateRight() {
        Tree<T> castLeft = (Tree<T>) this.left;
        Tree<T> castRight = (Tree<T>) this.left;
        FiniteBag<T> bottomRight =
                new Tree<T>(castLeft.getRight(), this.key, this.count, this.right, this.height);
        // TODO: What if the right node is a Leaf?
        if (this.right.equals(new Leaf<T>())) {
            bottomRight = new Leaf<T>();
        }

        return new Tree<T>(castLeft.getLeft(), castLeft.getKey(), castLeft.getCount(), bottomRight, this.height);
    }


    /**
     * Perform a left rotation on this tree branch
     *
     * @return a new FiniteBag, rotated left
     */
    public FiniteBag<T> rotateLeft() {

        Tree<T> castLeft = (Tree<T>) this.left;
        Tree<T> castRight = (Tree<T>) this.left;

        FiniteBag<T> newLeft =
                new Tree<T>(this.left, this.key, this.count, castRight.getLeft(), this.height);
        return new Tree<T>(newLeft, castRight.getKey(), castRight.getCount(), castRight.getRight(), this.height);
    }

    /**
     * Get the left-
     *
     * @return FiniteBag left
     */
    public FiniteBag<T> getLeft() {
        return this.left;
    }

    /**
     * Get the right tree
     *
     * @return FiniteBag right
     */
    public FiniteBag<T> getRight() {
        return this.right;
    }

    /**
     * Get the key
     *
     * @return key
     */
    public T getKey() {
        return this.key;
    }

    /**
     * Get the count— returns 0 because there is no key inside leaf
     *
     * @return key
     */
    public int getCount() {
        return this.count;
    }


}