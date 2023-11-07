package adt;

/** The List ADT interface. */
public interface List<E> extends Iterable<E> {
    /**
     * Add the element to the end of this list.
     */
    void add(E e);

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    boolean remove(E e);

    /**
     * Return true, if this list contains the element.
     */
    boolean contains(E e);

    /**
     * Remove all elements from this list.
     */
    void clear();

    /**
     * Return the size of this list.
     */
    int size();

    /**
     * Return true, if this list is empty.
     */
    boolean isEmpty();

    // Below: Methods belonging to an indexed list.

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    E get(int index);

    /**
     * Add the element to this list at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index > size().
     * Note: The element can be added at an index equal to size().
     */
    void add(int index, E e);

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    public E remove(int index);

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    public int indexOf(E e);

}
