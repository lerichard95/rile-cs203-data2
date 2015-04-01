//BST will implement BST, and all its functions
public interface FiniteSet {

    /*
    * t.remove(elt) -> Leaf
    * t: BST
    * elt: int
    * DESCRIPTION
    * Returns a Leaf, which represents an empty BST
    */
    public FiniteSet empty();

    /*
    * t.remove(elt) -> BST
    * t: BST
    * elt: int
    * DESCRIPTION
    * Returns set containing everything in t except elt
    */
    public int cardinality();

    public boolean isEmptyHuh();

    public boolean member(int blt);


    //t.add(elt) -> BST
    // t : BST
    // elt : integer
    public BST add(int elt);

    /*
    * t.remove(elt) -> BST
    * t: BST
    * elt: int
    * DESCRIPTION
    * Returns set containing everything in t except elt
    */
    public FiniteSet remove(int elt);


    /*
    * t.union(u) -> BST
    * t: BST
    * u: BST
    * DESCRIPTION
    * Returns a set containing everything in t and u
    */
    public FiniteSet union(FiniteSet u);

	/*
	* t.inter(u) -> BST
	* t: BST
	* u: BST
	* DESCRIPTION
	* Returns a set containing everything that is both in t and u
	* 
	*/

    public FiniteSet inter(FiniteSet u);
	
	/*
	* t.diff(u) -> BST
	* t: BST
	* u: BST
	* DESCRIPTION
	* Returns a set containing everything in u EXCEPT items in t
	* 
	*/

    public FiniteSet diff(FiniteSet u);

    /*
    * t.equal(u) -> boolean
    * t: BST
    * u: BST
    * DESCRIPTION
    * Returns true if t and u contains the same elements
    *
    */
    public boolean equal(FiniteSet u);


	/*
	* t.subset(u) -> boolean
	* t: BST
	* u: BST
	* DESCRIPTION
	* Returns true if t is a subset of u
	* 
	*/

    public boolean subset(FiniteSet u);

}