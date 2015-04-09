import java.util.Random;

/**
 * This is a class that tests the Tree class with Integers.
 */
public class RandTreeGenInt {
    static Random rand = new Random();
    static FiniteBag<Integer> tree;

    public RandTreeGenInt() {
    }

    //  Thanks to Nicholas Burka for acknowedging the importance of setting
    //  tree to accomodate for lack of mutation

    /**
     * Generate a tree consisting of elements 0 to num, with numbers ranging from 0 to range
     *
     * @param num   upper bound for number of elements
     * @param range upper bound for int number
     * @return a FiniteBag representing a Finite Set
     */
    public static FiniteBag<Integer> randTree(int num, int range) {
        tree = new Leaf<Integer>();

        for (int i = 0; i < num; i++) {
            Integer randKey = rand.nextInt(range);
            // Ensure that the randomly generated key wasn't already in the tree
            if (tree.member(randKey)) {
                randKey = rand.nextInt(range);
            }
            tree = tree.add(randKey);
        }
        return tree;
    }

    /**
     * Returns a FiniteBag with integers for all values between lower bound and upper bound
     *
     * @param start lower bound of element #
     * @param end   upper bound of element #
     * @return
     */
    public static FiniteBag<Integer> exhaustTree(int start, int end) {
        tree = new Leaf<Integer>();
        for (int i = start; i <= end; i++) {
            tree = tree.add(i);
        }
        return tree;
    }

    /**
     * Returns a FiniteBag with integers for all values between lower bound and upper bound, with multiplicity n
     *
     * @param start lower bound of element #
     * @param end   upper bound of element #
     * @param n multiplicity of all items in set
     * @return FiniteBag
     */
    public static FiniteBag<Integer> exhaustTreeN(int start, int end, int n) {
        tree = new Leaf<Integer>();
        for (int i = start; i <= end; i++) {
            tree = tree.addN(i, n);
        }
        return tree;
    }

}