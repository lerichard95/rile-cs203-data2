import tester.Tester;

import java.util.Random;

/**
 * FiniteBagExamples is the tester class that will be used.
 */
public class FiniteBagExamples {
    public static Random rand = new Random();

    public static boolean memberProp1() {
        FiniteBag<Integer> t = RandTreeGenInt.exhaustTree(1, 100);
        int x = 1 + Math.abs(rand.nextInt(99));
        int y = 1 + Math.abs(rand.nextInt(99));
        if (t.add(x).member(y) && (x == y) || (t.member(y))) {
            return true;
        } else {
            throw new RuntimeException("x: " + x + ", y: " + y + ", t: "
                    + t.toString());
        }
    }

    public static boolean memberProp2() {
        FiniteBag<Integer> s = RandTreeGenInt.randTree(50, 100);
        FiniteBag<Integer> sp = RandTreeGenInt.randTree(50, 100);
        int x = 1 + Math.abs(rand.nextInt(99));
        // Ensure that x is a member of s and sp
        if (!s.member(x) && !sp.member(x)) {
            x = 1 + Math.abs(rand.nextInt(99));
        }

        if (s.union(sp).member(x)) {
            return true;
        } else {
            return false;
        }
    }

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
        int randInt1 = Math.abs(rand.nextInt(200));

        t.checkExpect(
                RandTreeGenInt.randTree(randInt1, Math.abs(rand.nextInt())).size(),
                randInt1, "randTree");

        // isEmptyHuh()
        t.checkExpect(leaf.isEmptyHuh(), true, "leaf.isEmptyHuh()");
        t.checkExpect(
                RandTreeGenInt.randTree(randInt1, Math.abs(rand.nextInt())).isEmptyHuh(),
                false, "isEmptyHuh() random tree");

        // member()
        FiniteBag<Integer> randExhaust1 = RandTreeGenInt.exhaustTree(0, randInt1);
        int randMember = Math.abs(rand.nextInt(randInt1));
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

        FiniteBag<Integer> exhaustTreeRemoveN = RandTreeGenInt.exhaustTreeN(0, randInt1, randInt1);
        for (int i = 0; i <= randInt1; i++) {
            exhaustTreeRemoveN = exhaustTreeRemoveN.removeN(i, randInt1);
        }
        t.checkExpect(exhaustTreeRemoveN.isEmptyHuh(), true, "removeN() all from exhaustTreeRemoveN");

        t.checkExpect(leaf.removeN(randInt1, randInt1).size(), 0, "removeN() from Leaf");

        // union()
        // Union of empty set and non-empty set
        t.checkExpect(leaf.union(randExhaust1), randExhaust1, "leaf.union(randExhaust1)");

        // union()
        System.out.println("Should print Tree representing 1-10");
        FiniteBag<Integer> exhaustBagN = RandTreeGenInt.exhaustTreeN(0, randInt1, randInt1);

        // Generate three bounds
        int randInt2 = Math.abs(rand.nextInt(100));
        int randLowBound = Math.abs(rand.nextInt(randInt1));
        int randMidBound = randLowBound + Math.abs(rand.nextInt(randInt2));
        int randUpBound = randMidBound + Math.abs(rand.nextInt(randInt2));

        FiniteBag<Integer> exhaustTreeN1 = RandTreeGenInt.exhaustTreeN(randLowBound, randMidBound, randInt1);
        FiniteBag<Integer> exhaustTreeN2 = RandTreeGenInt.exhaustTreeN(randMidBound + 1, randUpBound, randInt1);
        FiniteBag<Integer> exhaustTreeN3 = RandTreeGenInt.exhaustTreeN(randLowBound, randUpBound, randInt1);
        FiniteBag<Integer> unionTree1 = exhaustTreeN1.union(exhaustTreeN2);

        // TODO: This union test is broken? Or union itself is broken
        t.checkExpect(unionTree1.isEqual(exhaustTreeN3), true, "union() for exhaust tree");
        t.checkExpect(leaf.union(leaf), leaf, "union() leaf with leaf");

        // FiniteBag equality property 1
        t.checkExpect(finiteBagEquality(), true, "finiteBagEquality()");


        // inter()
        t.checkExpect(exhaustTreeN1.inter(exhaustTreeN2).isEqual(leaf), true, "inter() no intersection - N1 N2");
        t.checkExpect(exhaustTreeN2.inter(leaf).isEqual(leaf), true, "inter() no intersection");

        t.checkExpect(exhaustTreeN3.inter(exhaustTreeN2).isEqual(exhaustTreeN2), true, "inter() exhaustTreeN3 inter exhaustTreeN2");
        t.checkExpect(exhaustTreeN3.inter(exhaustTreeN1).isEqual(exhaustTreeN1), true, "inter() exhaustTreeN3 inter exhaustTreeN3");

        //t.checkExpect(exhaustTreeN1.inter(leaf).isEqual(exhaustTreeN1), true, "inter() ");
        t.checkExpect(leaf.inter(leaf).isEqual(leaf), true, "leaf inter leaf (equals version");
        t.checkExpect(leaf.inter(leaf), leaf, "leaf inter leaf");

        t.checkExpect(exhaustTreeN1.inter(exhaustTreeN1).isEqual(exhaustTreeN1), true, "inter() total overlap");


        // diff()

        t.checkExpect(exhaustTreeN3.inter(exhaustTreeN1).isEqual(exhaustTreeN1), true, "diff() - N3 - N1 = N1");

        t.checkExpect(leaf.diff(exhaustTreeN1).isEqual(exhaustTreeN1), true, "diff(): leaf - N1 = N1");
        t.checkExpect(exhaustTreeN1.diff(exhaustTreeN2).isEqual(exhaustTreeN2), true, "diff(): N1 - N2 = N2");

        // union()
        FiniteBag<Integer> exhaustTreeN1u1 = RandTreeGenInt.exhaustTreeN(randLowBound, randMidBound, randInt1 * 2);
        t.checkExpect(exhaustTreeN1.union(exhaustTreeN2).isEqual(exhaustTreeN3), true, "union(): N1 + N2 = N3");
        t.checkExpect(leaf.union(exhaustTreeN2).isEqual(exhaustTreeN2), true, "union(): leaf + N2 = N2");
        t.checkExpect(exhaustTreeN1.union(exhaustTreeN1).isEqual(exhaustTreeN1u1), true, "union(): N1 + N1 = N1u1");

        // member (property1)
        t.checkExpect(memberProp1(), true, "memberProp1()");
        // member (property2)
        t.checkExpect(memberProp2(), true, "memberProp2()");

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
