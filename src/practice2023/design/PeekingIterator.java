package practice2023.design;

import java.util.Iterator;

public interface PeekingIterator<E> extends Iterator<E> {
    public E peek();

    public E next();

    public boolean hasNext();
}
