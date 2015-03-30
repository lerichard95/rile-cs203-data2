//Sorta like leaf— an "empty type??" that is only at the bottom of the BST
public class Leaf implements BST {

	Leaf() {}

	//---FUNCTION CONTRACT-----------------------------------------------------
	// empty() -> FiniteSet
	// empty() should return a FiniteSet with "empty" for left, right
	public Leaf empty() {
	//Note on constructor: It seems OK to use Leaf() for left/right because 
	//Leaf implements BST
			return new Leaf();
	}
	
	public String toString(){
		return "Leaf()";
	}
	
	//cardinality() -> int
	//no inputs— if a Leaf foo,
	// foo.cardinality() -> int
	public int cardinality() {
		//Empty finite set 
		return 0;
	}
	
	public boolean isEmptyHuh() {
		//Leaves are always empty
		return true;
	}
	
	public boolean member(int blt) {
		return false;
	}
	
	public FiniteSet add(int elt) {
		//Return a new FiniteSet with empty left/rights
		//with the added key elt
		return new FiniteSet(new Leaf(), elt ,new Leaf());
	}
	
	/*
	* t.equal(u) -> boolean
	* t: FiniteSet
	* u: FiniteSet
	* DESCRIPTION
	* Returns true if t and u contains the same elements
	* 
	*/
	public boolean equal(FiniteSet u) {
		//since all Leafs are empty, if u is empty also, then they are equal 
		return (u.isEmptyHuh());
	}
	
	// What do you remove from a Leaf? Just return Leaf because you can't 
	// remove elements from empty set
	public BST remove(int elt) {
		return new Leaf();
	}
	
	//Thanks to Atticus K for this
	//And Nicholas B for explaining how this works
	public BST union(BST u) {
		return u;
	}
	
	public BST inter(BST u) {
		return new Leaf();
	}
	
	public BST diff(BST u) {
		return u;
	}
	
	public boolean subset(BST u) {
		//  leaf.subset(u) means is leaf a subset of u
		//The empty set is a subset of any set so return true
		return true;
	}
	
	public boolean equal(BST u) {
		//if u is empty, then it is equal to the empty set
		return u.isEmptyHuh();
	}
	 
}