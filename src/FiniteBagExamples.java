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

        int randInt1 = Math.abs(rand.nextInt(1000));
        t.checkExpect(
                RandTreeGenInt.randTree(randInt1, Math.abs(rand.nextInt())).size(),
                randInt1, "randTree");

        // isEmptyHuh()
        t.checkExpect(leaf.isEmptyHuh(), true, "leaf.isEmptyHuh()");
        t.checkExpect(RandTreeGenInt.randTree(randInt1, Math.abs(rand.nextInt())).isEmptyHuh(), false, "random tree");

        // member()
        FiniteBag<Integer> randExhaust1 = RandTreeGenInt.exhaustTree(0,randInt1);
        int randMember = rand.nextInt(randInt1);
        t.checkExpect(randExhaust1.member(randMember), true, "randMember");
        t.checkExpect(leaf.member(randMember), false, "randMember");

        // add()

        // Adding existing elements to Tree
        // All of these should be identical
        System.out.println("-------  Testing add() existing elements -------");
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
        // Second prints should not return a Tree with the element
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

    }


    public void testLeaf(Tester t) {
        Leaf<Integer> emptLeaf = new Leaf<Integer>();
        t.checkExpect(emptLeaf.empty(), emptLeaf, "testLeaf: empty()");

        t.checkExpect(emptLeaf.size(), 0, "testLeaf: size()");

        t.checkExpect(emptLeaf.isEmptyHuh(), true, "testLeaf: isEmptyHuh()");


    }

    public void testTreeInt(Tester t) {
        RandTreeGenInt treeGeneratorIntegers = new RandTreeGenInt();

    }


}
