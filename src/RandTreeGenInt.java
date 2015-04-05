/**
 * This is a class that tests the Tree class with Integers.
 */
public class RandTreeGenInt {
    FiniteBag<Integer> tree;

    public RandTreeGenInt() {
    }

    //  Thanks to Nicholas Burka for acknowedging the importance of setting
    //  tree to accomodate for lack of mutation
    public FiniteBag<Integer> randTree(int num, int range) {
        tree = new Leaf<Integer>();

        for (int i = 0; i <= num; i++) {
            Integer randKey = 1 + Data2.rand.nextInt(range);
            tree = tree.add(randKey);
        }
        return tree;
    }

    public FiniteBag<Integer> exhaustTree(int start, int end) {
        tree = new Leaf<Integer>();
        for (int i = start; i <= end; i++) {
            tree = tree.add(i);
        }
        return tree;
    }

}