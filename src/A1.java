import java.util.Random;

public class A1 {
	public static void main(String[] args) {

		// Tests
		boolean testsEnabled = true;

		if (testsEnabled) {

			// A BST for testing
			FiniteSet leaf = new Leaf();
			FiniteSet t1 = new BST(leaf, 1, leaf);
			FiniteSet t3 = new BST(leaf, 3, leaf);
			FiniteSet t5 = new BST(leaf, 5, leaf);
			FiniteSet t7 = new BST(leaf, 7, leaf);
			FiniteSet t2 = new BST(t1, 2, t3);
			FiniteSet t6 = new BST(t5, 6, t7);
			FiniteSet t4 = new BST(t2, 4, t6);

			// Test: empty()
			System.out.println(leaf.empty());

			System.out.println("-------- Test: cardinality() --------");
			Leaf leafasdf = new Leaf();
			System.out.println("leafasdf.cardinality() -> "
					+ leafasdf.cardinality() + " It should be: " + "0");

			System.out.println("t4.cardinality() -> " + t4.cardinality()
					+ " It should be: " + 7);

			System.out.println("-------- Test: isEmptyHuh() --------");
			System.out.println("t1.isEmptyHuh() -> " + t1.isEmptyHuh()
					+ " It should be: " + "false");

			System.out.println("t4.isEmptyHuh() -> " + t4.isEmptyHuh()
					+ " It should be: " + "false");

			System.out.println("leaf.isEmptyHuh() -> " + leaf.isEmptyHuh()
					+ " It should be: " + "true");

			System.out.println("-------- Test: member() (1) --------");

			// --- Testing for true, left side
			// lowest level
			System.out.println("t1.member(1) -> " + t1.member(1)
					+ " It should be: " + "true");
			// one level up
			System.out.println("t2.member(1) -> " + t2.member(1)
					+ " It should be: " + "true");
			System.out.println("t2.member(8) -> " + t2.member(8)
					+ " It should be: " + "false");
			// two levels up
			System.out.println("t4.member(1) -> " + t4.member(1)
					+ " It should be: " + "true");
			System.out.println("t4.member(8) -> " + t4.member(8)
					+ " It should be: " + "false");
			System.out.println("t4.member(2) -> " + t4.member(2)
					+ " It should be: " + "true");
			System.out.println("t4.member(8) -> " + t4.member(8)
					+ " It should be: " + "false");

			// --- Testing for true, right side
			// Lowest level
			System.out.println("t2.member(3) -> " + t4.member(3)
					+ " It should be: " + "true");
			System.out.println("t2.member(8) -> " + t4.member(8)
					+ " It should be: " + "false");
			// two levels up
			System.out.println("t6.member(5) -> " + t4.member(6)
					+ " It should be: " + "true");
			System.out.println("t6.member(8) -> " + t4.member(8)
					+ " It should be: " + "false");
			System.out.println("t6.member(7) -> " + t4.member(7)
					+ " It should be: " + "true");
			System.out.println("t6.member(8) -> " + t4.member(8)
					+ " It should be: " + "false");

			// highest to lowest
			System.out.println("t4.member(7) -> " + t4.member(7)
					+ " It should be: " + "true");

			System.out.println("t4.member(3) -> " + t4.member(3)
					+ " It should be: " + "true");
			System.out.println("t4.member(8) -> " + t4.member(8)
					+ " It should be: " + "false");

			// Testing add()
			System.out.println("-----------  Testing add()  -----------");

			// Adding existing elements to BST
			// All of these should be identical
			System.out
					.println("-------  Testing add() existing elements -------");
			System.out.println(t4.add(4));
			System.out.println(t4.add(1));
			System.out.println(t4.add(2));
			System.out.println(t4.add(3));
			System.out.println(t4.add(5));
			System.out.println(t4.add(6));
			System.out.println(t4.add(7));

			System.out
					.println("-----  End testing add() existing elements -----");

			// Test: Implementation is pure
			// Second prints should not return a BST with the element
			// added in line above...

			// Adding 0 and 8
			System.out.println(t4.add(0).add(8));
			System.out.println(t4);

			System.out.println(t4.add(9));
			System.out.println(t4.add(0).add(8));

			System.out.println("----- Adding larger numbers Y, "
					+ "then adding numbers in between largest number in "
					+ "initial set X -----");

			System.out.println(t4.add(10).add(8));
			System.out.println(t4.add(15).add(9).add(8));

			// MORE TESTING: remove
			System.out
					.println("----- TEST: remove (1); "
							+ "remove test 1: make an exhaustive tree and remove all -----");
			System.out.println("Should print BST representing 1-10");
			TreeGen treeGen = new TreeGen();
			FiniteSet exhaustTree = treeGen.exhaustTree(1, 10);

			System.out.println("Initial exhaustTree:");
			System.out.println(exhaustTree);

			System.out.println("Begin removing");
			for (int i = 1; i <= 10; i++) {
				exhaustTree = exhaustTree.remove(i);
				System.out.println(exhaustTree);

			}

			System.out
					.println("----- TEST: remove (2); remove items from an empty set -----");
			System.out.println("Should print Leaf multiple times");
			FiniteSet testLeaf = new Leaf();
			System.out.println("Initial Leaf:");
			System.out.println(testLeaf);
			System.out.println("Start testLeaf.remove() calls:");
			for (int i = 1; i <= 10; i++) {
				testLeaf = testLeaf.remove(i);
				System.out.println(testLeaf);
			}
			// reset testleaf for future use
			testLeaf = new Leaf();

			System.out.println("----- TEST: union (1); "
					+ "empty set and non-empty set -----");
			// Union of empty set and non-empty set
			System.out.println("Should return the non-empty set");
			FiniteSet testLeaf2 = new Leaf();
			FiniteSet exhaustTree2 = treeGen.exhaustTree(1, 10);

			System.out.println(testLeaf2.union(exhaustTree2));

			// Union of overlapping elements should not contain duplicates
			// because FiniteSets don't have duplicates?
			System.out.println("----- TEST: union (2); 2 identical sets -----");
			System.out.println("Should print BST representing 1-10");
			FiniteSet exhaustTree3 = treeGen.exhaustTree(1, 10);
			FiniteSet exhaustTree33 = treeGen.exhaustTree(1, 10);
			System.out.println(exhaustTree3.union(exhaustTree33));

			System.out.println("----- TEST: union (3); 2 empty sets -----");
			System.out.println("Should print Leaf()");
			testLeaf = testLeaf.empty();
			System.out.println(testLeaf2.union(testLeaf));

			System.out
					.println("----- TEST: union (4); 2 non-identical sets -----");
			System.out.println("Should print BST representing 1-15");
			FiniteSet exhaustTree4 = treeGen.exhaustTree(1, 10);
			FiniteSet exhaustTree44 = treeGen.exhaustTree(11, 15);
			System.out.println(exhaustTree4.union(exhaustTree44));

			System.out
					.println("----- TEST: inter (1); set 1-10 with 5-10  -----");
			FiniteSet exhaustTree5 = treeGen.exhaustTree(5, 10);
			System.out.println("Should print BST representing 5-10");
			System.out.println(exhaustTree4.inter(exhaustTree5));

			System.out
					.println("----- TEST: inter (2); set 1-10 with 11-15 -----");
			System.out.println("Should print Leaf()");
			System.out.println(exhaustTree4.inter(exhaustTree44));

			System.out.println("----- TEST: inter (3); 2 empty sets -----");
			System.out.println("Should print Leaf()");
			System.out.println(testLeaf.inter(testLeaf2));

			System.out
					.println("----- TEST: inter (3); total overlap of FiniteSets -----");
			System.out.println("Should print either BST");
			System.out.println(exhaustTree3.inter(exhaustTree33));

			System.out.println("----- TEST: inter (3); Random testing -----");
			System.out.println("Should not break???");
			FiniteSet randTree1 = treeGen.randTree(25, 10);
			FiniteSet randTree2 = treeGen.randTree(25, 10);
			for (int i = 0; i <= 100; i++) {
				randTree1 = treeGen.randTree(10, 20);
				randTree2 = treeGen.randTree(10, 20);
				System.out.println(randTree1.inter(randTree2));
			}

			System.out
					.println("----- TEST: diff (1); set 1-10 with 5-15 -----");
			System.out.println("Should have BST containing 11-15");
			FiniteSet exhaustTreeA = treeGen.exhaustTree(1, 10);
			FiniteSet exhaustTreeAA = treeGen.exhaustTree(5, 15);
			System.out.println(exhaustTreeA.diff(exhaustTreeAA));

			System.out.println("----- TEST: diff (2); set 1-5 with 6-10 -----");
			System.out.println("Should return BST 6-10");
			FiniteSet exhaustTreeB = treeGen.exhaustTree(1, 5);
			FiniteSet exhaustTreeBB = treeGen.exhaustTree(6, 10);
			System.out.println(exhaustTreeB.diff(exhaustTreeBB));

			System.out.println("----- TEST: diff (3); 2 empty set -----");
			System.out.println("Should return empty set");
			System.out.println(testLeaf.diff(testLeaf2));

			System.out
					.println("----- TEST: diff (4); empty set and non-empty set  -----");
			System.out.println("Should return non-empty set");
			System.out.println(testLeaf.diff(exhaustTreeB));

			System.out.println("----- TEST: member (property1); -----");
			System.out.println("Nothing should return false below:");
			for (int i = 0; i <= 1000; i++) {
				try {
					testMemberProp1();
				} catch (RuntimeException e) {
					System.out.println("ERROR! Property not satisfied: "
							+ e.getMessage());
				}
			}
			System.out.println("Finished testing.");

			System.out.println("----- TEST: member (property2); -----");
			System.out.println("Nothing should return false below:");
			for (int i = 0; i <= 100; i++) {
				try {
					testMemberProp2();
				} catch (RuntimeException e) {
					System.out.println("ERROR! Property not satisfied: "
							+ e.getMessage());
				}
			}
			System.out.println("Finished testing.");


			System.out.println("----- TEST: equal -----");
			System.out.println("Nothing should return false below:");
			for (int i = 0; i <= 70; i++) {
				try {
					testEqual();
				} catch (RuntimeException e) {
					System.out.println("ERROR! Test failed");
				}
			}
			System.out.println("Finished testing.");


		}

	}

	public static boolean testMemberProp1() {
		Random rand = new Random();

		TreeGen treeGen = new TreeGen();
		FiniteSet t = treeGen.exhaustTree(1, 100);
		int x = 1 + rand.nextInt(99);
		int y = 1 + rand.nextInt(99);

		if (t.add(x).member(y) && (x == y) || (t.member(y))) {
			return true;
		} else {
			throw new RuntimeException("x: " + x + ", y: " + y + ", t: "
					+ t.toString());
		}
	}

	public static boolean testMemberProp2() {
		Random rand = new Random();

		TreeGen treeGen = new TreeGen();
		FiniteSet s = treeGen.randTree(50, 100);
		FiniteSet sp = treeGen.randTree(50, 100);
		int x = 1 + rand.nextInt(99);
		// Ensure that x is a member of s and sp
		while (!s.member(x) && !sp.member(x)) {
			x = 1 + rand.nextInt(99);
			// System.out.println(x);
		}

		if (s.union(sp).member(x)) {
			return true;
		} else {
			throw new RuntimeException("x: " + x + ", s: " + s.toString()
					+ ", sp: " + sp.toString());
		}
	}

	// Tests by subset rule
	public static boolean testEqual() {
		TreeGen treeGen = new TreeGen();
		FiniteSet a = treeGen.randTree(100, 100);
		FiniteSet b = a;

		if (a.subset(b) && b.subset(a)) {
			return true;
		} else {
			throw new RuntimeException("ERROR!");
		}

	}
	
	// end of main
}
