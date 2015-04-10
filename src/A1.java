/*
import java.util.Random;

public class A1 {
    public static void main(String[] args) {


        System.out
                .println("----- TEST: inter (1); set 1-10 with 5-10  -----");
        FiniteSet exhaustTree5 = treeGen.exhaustTree(5, 10);
        System.out.println("Should print Tree representing 5-10");
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
        System.out.println("Should print either Tree");
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
        System.out.println("Should have Tree containing 11-15");
        FiniteSet exhaustTreeA = treeGen.exhaustTree(1, 10);
        FiniteSet exhaustTreeAA = treeGen.exhaustTree(5, 15);
        System.out.println(exhaustTreeA.diff(exhaustTreeAA));

        System.out.println("----- TEST: diff (2); set 1-5 with 6-10 -----");
        System.out.println("Should return Tree 6-10");
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


}*/
