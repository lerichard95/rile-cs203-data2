//Sorta like leaf— an "empty type??" that is only at the bottom of the BST
public class Leaf implements FiniteSet {

	Leaf() {}

	//---FUNCTION CONTRACT-----------------------------------------------------
	// empty() -> BST
	// empty() should return a BST with "empty" for left, right
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
	
	public BST add(int elt) {
		//Return a new BST with empty left/rights
		//with the added key elt
		return new BST(new Leaf(), elt ,new Leaf());
	}
	
	/*
	* t.equal(u) -> boolean
	* t: BST
	* u: BST
	* DESCRIPTION
	* Returns true if t and u contains the same elements
	* 
	*/
	public boolean equal(BST u) {
		//since all Leafs are empty, if u is empty also, then they are equal 
		return (u.isEmptyHuh());
	}
	
	// What do you remove from a Leaf? Just return Leaf because you can't 
	// remove elements from empty set
	public FiniteSet remove(int elt) {
		return new Leaf();
	}
	
	//Thanks to Atticus K for this
	//And Nicholas B for explaining how this works
	public FiniteSet union(FiniteSet u) {
		return u;
	}
	
	public FiniteSet inter(FiniteSet u) {
		return new Leaf();
	}
	
	public FiniteSet diff(FiniteSet u) {
		return u;
	}
	
	public boolean subset(FiniteSet u) {
		//  leaf.subset(u) means is leaf a subset of u
		//The empty set is a subset of any set so return true
		return true;
	}
	
	public boolean equal(FiniteSet u) {
		//if u is empty, then it is equal to the empty set
		return u.isEmptyHuh();
	}
	 
}