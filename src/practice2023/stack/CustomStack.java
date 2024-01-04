package practice2023.stack;

/**
 * LinkedIn phone screen.
 * @param <T>
 */
public interface CustomStack<T extends Comparable<T>> {
    public void push(T x);
    public T pop();
    public T top();
    public T peekMax();
    public T popMax();
}