/**
 * Created by richard on 4/8/15.
 */
public class AS_Union<T extends Comparable> implements Sequence<T> {
    Sequence<T> left;
    Sequence<T> right;

    AS_Union(Sequence<T> le, Sequence<T> ri) {
        this.left = le;
        this.right = ri;
    }

    @Override
    public T here() {
        if (left.isSomethingThere()) {
            return this.left.here();
        } else {
            return this.right.here();
        }
    }

    @Override
    public boolean isSomethingThere() {
        return left.isSomethingThere() && right.isSomethingThere();
    }

    @Override
    public Sequence<T> next() {
        return null;
    }
}
