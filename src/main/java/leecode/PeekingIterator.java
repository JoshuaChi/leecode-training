package leecode;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> i = null;
    private Integer peeked = null;
    private boolean hasPeeked = false;

    public PeekingIterator(Iterator<Integer> iterator) {
        if (iterator != null) {
            // initialize any member here.
            i = iterator;
        }
    }

    // Returns the peeked element in the iteration without advancing the iterator.
    public Integer peek() {
        if (i == null) {
            return null;
        }
        if (!hasPeeked) {
            peeked = i.next();
            hasPeeked = true;
        }
        return peeked;
    }

    // hasNext() and peeked() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (i == null) {
            return null;
        }
        if (!hasPeeked) {
            peeked = i.next();
            hasPeeked =  true;
        }
        return peeked;
    }

    @Override
    public void remove() {
        if (i == null) {
            return;
        }
        if (hasPeeked) {
            i.remove();
        }
    }

    @Override
    public boolean hasNext() {
        if (i == null) {
            return false;
        }
        return hasPeeked || i.hasNext();
    }
}
