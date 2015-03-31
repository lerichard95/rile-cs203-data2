//FiniteSet will implement BST, and all its functions
public interface BST {

    /*
    * t.remove(elt) -> Leaf
    * t: FiniteSet
    * elt: int
    * DESCRIPTION
    * Returns a Leaf, which represents an empty FiniteSet
    */
    public BST empty();

    /*
    * t.remove(elt) -> FiniteSet
    * t: FiniteSet
    * elt: int
    * DESCRIPTION
    * Returns set containing everything in t except elt
    */
    public int cardinality();

    public boolean isEmptyHuh();

    public boolean member(int blt);


    //t.add(elt) -> FiniteSet
    // t : FiniteSet
    // elt : integer
    public FiniteSet add(int elt);

    /*
    * t.remove(elt) -> BST
    * t: FiniteSet
    * elt: int
    * DESCRIPTION
    * Returns set containing everything in t except elt
    */
    public BST remove(int elt);


    /*
    * t.union(u) -> FiniteSet
    * t: FiniteSet
    * u: FiniteSet
    * DESCRIPTION
    * Returns a set containing everything in t and u
    */
    public BST union(BST u);

	/*
	* t.inter(u) -> FiniteSet
	* t: FiniteSet
	* u: FiniteSet
	* DESCRIPTION
	* Returns a set containing everything that is both in t and u
	* 
	*/

    public BST inter(BST u);
	
	/*
	* t.diff(u) -> FiniteSet
	* t: FiniteSet
	* u: FiniteSet
	* DESCRIPTION
	* Returns a set containing everything in u EXCEPT items in t
	* 
	*/

    public BST diff(BST u);

    /*
    * t.equal(u) -> boolean
    * t: FiniteSet
    * u: FiniteSet
    * DESCRIPTION
    * Returns true if t and u contains the same elements
    *
    */
    public boolean equal(BST u);


	/*
	* t.subset(u) -> boolean
	* t: FiniteSet
	* u: FiniteSet
	* DESCRIPTION
	* Returns true if t is a subset of u
	* 
	*/

    public boolean subset(BST u);

}