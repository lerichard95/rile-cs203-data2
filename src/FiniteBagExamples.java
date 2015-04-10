import tester.Tester;

import java.util.Random;

/**
 * FiniteBagExamples is the tester class that will be used.
 */
public class FiniteBagExamples {
    public static Random rand = new Random();

    public void testBasic1(Tester t) {
        // A Tree for testing
        FiniteBag<Integer> leaf = new Leaf<Integer>();
        FiniteBag<Integer> t1 = new Tree<Integer>(leaf, 1, 1, leaf);
        FiniteBag<Integer> t3 = new Tree<Integer>(leaf, 3, 1, leaf);
        FiniteBag<Integer> t5 = new Tree<Integer>(leaf, 5, 1, leaf);
        FiniteBag<Integer> t7 = new Tree<Integer>(leaf, 7, 1, leaf);
        FiniteBag<Integer> t2 = new Tree<Integer>(t1, 2, 1, t3);
        FiniteBag<Integer> t6 = new Tree<Integer>(t5, 6, 1, t7);
        FiniteBag<Integer> t4 = new Tree<Integer>(t2, 4, 1, t6);

        // Test: empty()
        t.checkExpect(leaf.isEmptyHuh(), true, "empty()");

        // size()
        t.checkExpect(leaf.size(), 0, "size() - leaf");
        t.checkExpect(t4.size(), 7, "size() - t4");

        // To be used for plenty other random stuff
        int randInt1 = Math.abs(rand.nextInt(1000));

        t.checkExpect(
                RandTreeGenInt.randTree(randInt1, Math.abs(rand.nextInt())).size(),
                randInt1, "randTree");

        // isEmptyHuh()
        t.checkExpect(leaf.isEmptyHuh(), true, "leaf.isEmptyHuh()");
        t.checkExpect(RandTreeGenInt.randTree(randInt1, Math.abs(rand.nextInt())).isEmptyHuh(),
                false, "random tree");

        // member()
        FiniteBag<Integer> randExhaust1 = RandTreeGenInt.exhaustTree(0, randInt1);
        int randMember = rand.nextInt(randInt1);
        t.checkExpect(randExhaust1.member(randMember), true, "randMember");
        t.checkExpect(leaf.member(randMember), false, "randMember");

        // add()
        // Adding existing elements to Tree
        int randIntWithinRI1 = rand.nextInt(randInt1);
        t.checkExpect(randExhaust1.add(randIntWithinRI1).multiplicity(randIntWithinRI1),
                2, "randExhaust1.add(1)");

        // addN()
        t.checkExpect(leaf.addN(randIntWithinRI1, randInt1).multiplicity(randIntWithinRI1),
                randInt1, "addN to leaf()");

        // remove()
        FiniteBag<Integer> exhaustTree2 = RandTreeGenInt.exhaustTree(0, randInt1);
        for (int i = 0; i <= randInt1; i++) {
            exhaustTree2 = exhaustTree2.remove(i);
        }
        t.checkExpect(exhaustTree2.size(), leaf.size(), "remove() all from exhaustTree2");

        t.checkExpect(leaf.removeN(randInt1, randInt1).size(), 0, "removeN() from Leaf");

        // union()
        // Union of empty set and non-empty set
        t.checkExpect(leaf.union(randExhaust1), randExhaust1, "leaf.union(randExhaust1)");

        // union()
        System.out.println("Should print Tree representing 1-10");
        FiniteBag<Integer> exhaustBagN = RandTreeGenInt.exhaustTreeN(0, randInt1, randInt1);

        // Generate three bounds
        int randInt2 = rand.nextInt(8);
        int randLowBound = rand.nextInt(randInt2);
        int randMidBound = randLowBound + rand.nextInt(randInt2);
        int randUpBound = randMidBound + rand.nextInt(randInt2);

        FiniteBag<Integer> exhaustTreeN1 = RandTreeGenInt.exhaustTreeN(randLowBound, randMidBound, 0);
        FiniteBag<Integer> exhaustTreeN2 = RandTreeGenInt.exhaustTreeN(randMidBound + 1, randUpBound, 0);
        FiniteBag<Integer> exhaustTreeN3 = RandTreeGenInt.exhaustTreeN(randLowBound, randUpBound, 0);
        FiniteBag<Integer> unionTree1 = exhaustTreeN1.union(exhaustTreeN2);

        t.checkExpect(unionTree1.isEqual(exhaustTreeN3), true, "union() for exhaust tree");

        t.checkExpect(leaf.union(leaf), leaf, "union() leaf with leaf");

        t.checkExpect(finiteBagEquality(), true, "finiteBagEquality()");
    }


    public void testLeaf(Tester t) {
        Leaf<Integer> emptLeaf = new Leaf<Integer>();
        t.checkExpect(emptLeaf.empty(), emptLeaf, "testLeaf: empty()");

        t.checkExpect(emptLeaf.size(), 0, "testLeaf: size()");

        t.checkExpect(emptLeaf.isEmptyHuh(), true, "testLeaf: isEmptyHuh()");


    }

    public boolean finiteBagEquality() {
        int randInty = rand.nextInt();
        FiniteBag<Integer> a = RandTreeGenInt.randTreeN(0, 100, randInty);
        FiniteBag<Integer> b = a;
        return (a.isSubset(b) && b.isSubset(a));
    }


}
