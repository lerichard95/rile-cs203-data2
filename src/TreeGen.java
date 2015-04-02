/*
import java.util.Random;

public class TreeGen {
	FiniteBag<T> tree;
	public TreeGen() {
	}

	//  Thanks to Nicholas Burka for acknowedging the importance of setting
	//  tree to accomodate for lack of mutation
	public FiniteSet randTree(int num, int range) {
		tree = new Leaf();

		for (int i = 0; i <= num; i++) {
			T randKey = 1 + Data2.rand.nextInt(range);
			tree = tree.add(randKey);
		}
		return tree;
	}

	public FiniteSet exhaustTree(int start, int end) {
		tree = new Leaf();

		for (int i = start; i <= end; i++) {
			tree = tree.add(i);
		}
		return tree;
	}

}
*/
