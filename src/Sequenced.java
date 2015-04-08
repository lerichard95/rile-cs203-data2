/**
 * Sequenced is an "iterator" - returns a generator.
 * Created by richard on 4/3/15.
 */
public interface Sequenced<G> {
    /**
     * seq() is an ITERATOR, a procedure which returns a GENERATOR (a Sequence)
     *
     * @return A generator which produces elements that will be iterated over
     */
    Sequence<G> seq();

}
