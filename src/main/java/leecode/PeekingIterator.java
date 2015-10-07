package leecode;

import java.util.Iterator;

/**
 * @author Joshua
 *
 * 12 / 12 test cases passed.
 * Status: Accepted
 * Runtime: 37 ms
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> i;
    private Integer peeked = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.i = iterator;
    }

    // Returns the peeked element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peeked == null) {
            peeked = i.next();
        }
        return peeked;
    }

    // hasNext() and peeked() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peeked != null) {
            Integer tmp = peeked;
            peeked = null;
            return tmp;
        }
        return i.next();
    }

    @Override
    public void remove() {
        if (peeked != null) {
            i.remove();
        }
    }

    @Override
    public boolean hasNext() {
        return (peeked != null) || i.hasNext();
    }
}
