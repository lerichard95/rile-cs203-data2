//A FiniteSet IS a node
public class FiniteSet implements BST {
	// Instance variables for a BST
	BST left;
	int key;
	BST right;

	// Constructor gives directions for new instances
	FiniteSet(BST left, int key, BST right) {
		// assign inputs of a new instance
		// to the instance variables specified above
		this.left = left;
		this.key = key;
		this.right = right;
	}

	// toString for testing
	public String toString() {
		return "FiniteSet(" + this.left.toString() + ", " + this.key + ", "
				+ this.right.toString() + ")";
	}

	// FiniteSet should implement all the functions in BST

	public BST empty() {
		return new Leaf();
	}

	// set.cardinality() -> int
	// set : FiniteSet
	public int cardinality() {
		// Count 1 for self,
		// add the cardinality of the left and right BST's
		return 1 + this.left.cardinality() + this.right.cardinality();
	}

	// set.isEmptyHuh() -> boolean
	// set : BST
	public boolean isEmptyHuh() {
		// FiniteSet can never be empty. Leaf is used to represent empty nodes.
		return false;
		// return this.cardinality() == 0;
	}

	// member(t blt) -> boolean
	// t : FiniteSet
	// blt : integer
	// Difficult to match spec because the input should
	// be able to be any subclasses of BST— including Leaf.
	public boolean member(int blt) {
		if (this.key == blt) {
			return true;
		}
		// left and right need to be instance variables
		// of type BST in order for finite set to hold
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

	// t.add(elt) -> FiniteSet
	// t : FiniteSet
	// elt : integer
	//
	// Not really sure how to do this... should I keep a copy of the entire
	// root FiniteSet that holds all the other ones, and then keep copies
	// of the parent FiniteSets in order to

	public FiniteSet add(int elt) {
		// Thanks to Atticus K for a better way to imagine adding "nodes"

		// key == elt
		// Just return the current FiniteSet "node"
		if (this.key == elt) {
			return this;
		}

		// elt < key
		// Returning a new FiniteSet allows a tree to be "rebuilt" upon
		// successive recursive calls
		//
		// The new FiniteSet should hold the current key, preseve the FiniteSet
		// that will not be modified, and call add() on the respective FiniteSet
		// that elt should belong to...
		//
		//
		// When add() reaches a Leaf, the add() implementation for Leaf will
		// create a FiniteSet that holds elt, with Leaf for left and right.
		// Since this is the last return, recursion will stop, and the
		// new instances of FiniteSet built on successive add() calls will
		// return a new root FiniteSet, making add() a pure implementation.
		//

		if (elt < this.key) {
			return new FiniteSet(left.add(elt), key, right);
		}

		// elt > this.key
		else {
			return new FiniteSet(left, key, right.add(elt));
		}
	}

	// TODO: figure out remove
	public BST remove(int elt) {

		// Thanks to Atticus K for this implementation
		if (elt < this.key) {
			// Returning a new FiniteSet allows each recursive call
			// to "rebuild" the FiniteSet tree
			return new FiniteSet(this.left.remove(elt), key, right);
		}

		if (elt > this.key) {
			return new FiniteSet(left, key, this.right.remove(elt));
		}

		else {
			// Combine the left and right trees but ignore the current key
			return this.left.union(this.right);
		}

	}

	public BST union(BST u) {
		// Thanks to Nicholas B for explaining the recursive nature of this
		return u.union(this.left).union(this.right).add(key);
		// What happens:
		// Recursive call union of "this" to u,
		// union will "travel" down the left FiniteSet of the root FiniteSet
		// When each union call reaches the base case (a Leaf), it will return
		// FiniteSet u, and then call union of that onto the right tree,
		// Finally, the key will be added to the FiniteSet containing
		// the left and right trees.
	}

	// TODO finish equal
	/*
	public boolean equal(FiniteSet u) {
		// IDEA:
		// Check cardinality, if they are not same size, they should not be
		// the same set.

		if (this.cardinality() == u.cardinality()) {

			// TODO:
			// Begin recursively going through all elements
			return ((this.left.equal(u))
					&&
					(this.right.equal(u)));

		} else {
			return false;
		}

	}
	*/

	//Thanks to Atticus K for implementation
	public BST inter(BST u) {
		if (u.member(this.key)) {
			//  If the current FiniteSet fulfills being in 
			//  u, return a new FiniteSet that calls the intersection of u
			//  with the intersection of the left child, as well as the inter
			//  -section of the right child and u. 
			//  (Recursively call inter on left and right children)
			//  Preserve current key
			
			return new FiniteSet(this.left.inter(u), this.key,
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
	
	//Thanks to Atticus K for implementation
	public BST diff(BST u) {
		//  start by unioning the left/right children,
		//  then recursive call diff with a new input 
		//  remove the current key from u— if there is not overlap between sets,
		//  remove() will return the same set u
		
		return this.left.union(this.right).diff(u.remove(this.key));
	}
	
	
	//  Thanks to Atticus K for implementation of subset and equal
	public boolean subset(BST u) {
		//  Checks if current key is a member of u,
		//  Then recursively calls subset on left/right branches 
		return u.member(this.key) && this.left.subset(u) && this.right.subset(u);
	}
	
	 public boolean equal(BST u) {
		 //  By definition of subset, 
		 //  sets this and u are equivalent if 
		 //  this and u are subsets of each other. 
		 return this.subset(u) && u.subset(this);
	 }
	

}