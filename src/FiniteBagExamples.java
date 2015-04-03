import tester.*;

/**
 * FiniteBagExamples is the tester class that will be used.
 */
public class FiniteBagExamples {
    public void testSomething(Tester t) {
        System.out.println("Tester is correctly setup— ready to test!");
    }

    public void testLeaf(Tester t) {
        Leaf<Integer> emptLeaf = new Leaf<Integer>();
        t.checkExpect(emptLeaf.empty(), emptLeaf, "testLeaf: empty()");

        t.checkExpect(emptLeaf.size(), 0, "testLeaf: size()");

        t.checkExpect(emptLeaf.isEmptyHuh(), true, "testLeaf: isEmptyHuh()");



    }


    public void testTreeInt(Tester t) {
        TreeGenInt treeGeneratorIntegers = new TreeGenInt();

    }


}
