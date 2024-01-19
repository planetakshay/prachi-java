package practice2023.design;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Google onsite had asked to implement UnionIterator.
 * And has suggested to take a look at peeking iterator.
 * Zigzag iterator is more close to the UnionIterator
 * implementation.
 */
public class PeekingIteratorImpl implements PeekingIterator<Integer> {
    private Iterator<Integer> iter;
    private Integer next;
    public PeekingIteratorImpl(Iterator<Integer> iterator) {
        iter = iterator;
        next = iterator.hasNext() ? iterator.next() : null;
    }
    public Integer peek() {
        return next;
    }
    public Integer next() {
        if(next == null) {
            throw new NoSuchElementException();
        }
        Integer ret = next;
        next = null;
        if(iter.hasNext()) {
            next = iter.next();
        }
        return ret;
    }
    public boolean hasNext() {
        return next != null;
    }
}