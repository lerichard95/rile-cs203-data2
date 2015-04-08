/**
 * Created by richard on 4/8/15.
 */
public class AS_Union<T extends Comparable> implements Sequence<T> {
    Sequence<T> left;
    Sequence<T> right;

    AS_Union(Sequence<T> l, Sequence<T> r) {
        this.left = l;
        this.right = r;
    }

    @Override
    public T here() {
        if (left.notEmpty()) {
            return this.left.here();
        } else {
            return this.right.here();
        }
    }

    @Override
    public boolean notEmpty() {
        return left.notEmpty() && right.notEmpty();
    }

    @Override
    public Sequence<T> next() {
        return null;
    }
}
