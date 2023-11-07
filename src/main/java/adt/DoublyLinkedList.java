package adt;

import java.util.Iterator;

    public class DoublyLinkedList<E> implements List<E> {
        private final Node<E> header = new Node<>(null);
        private final Node<E> trailer = new Node<>(null);
        private int size = 0;

        public DoublyLinkedList() {
            header.next = trailer;
            trailer.prev = header;
        }

        /**
         * Add the element to the end of this list.
         */
        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);
            // insert newNode between trailer.prev and trailer
            newNode.prev = trailer.prev;
            newNode.next = trailer;
            trailer.prev.next = newNode;
            trailer.prev = newNode;
            size++;
        }

        /**
         * Remove the element from this list.
         * Return true, if this list is modified.
         */
        @Override
        public boolean remove(E e) {
            Node<E> firstNode = header.next;

            boolean foundObject = false;

            int i = 0;
            // Kører til vi rammer noden vi vil fjerne
            while (i < size && !foundObject) {
                if (firstNode.element.equals(e)) {
                    foundObject = true;
                } else {
                    firstNode = firstNode.next;
                    i++;
                }
            }
            if (!foundObject) {
                return false;
            } else {
                Node<E> previous = firstNode.prev;
                previous.next = firstNode.next;
                if (previous.next.element != null) {
                    firstNode.next.prev = previous;
                }
                size--;
                return true;
            }
        }

        /**
         * Return true, if this list contains the element.
         */
        @Override
        public boolean contains(E e) {
            Node<E> head = header;
            while (head.next != null) {
                if (head.next.element.equals(e)) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }

        /**
         * Remove all elements from this list.
         */
        @Override
        public void clear() {
            header.next = trailer;
            trailer.prev = header;
            size = 0;
        }

        /**
         * Return the size of this list.
         */
        public int size() {
            return size;
        }

        /**
         * Return true, if this list is empty.
         */
        @Override
        public boolean isEmpty() {
            return header.next == trailer;
        }

        /**
         * Return the element at the index.
         * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
         */
        @Override
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("index is out of bounds!");
            }
            Node<E> node = header.next;
            int i = 0;
            while (i < index) {
                node = node.next;
                i++;
            }
            return node.element;
        }

        /**
         * Add the element to this list at the index.
         * Throw IndexOutOfBoundsException, if index < 0 or index > size().
         * Note: The element can be added at an index equal to size().
         */
        @Override
        public void add(int index, E e) {
            Node<E> nodeToAdd = new Node<>(e);
            Node<E> currentNode = header.next;
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("index is out of bounds!");
            }
            if (index == 0) {
                nodeToAdd.prev = header;
                nodeToAdd.next = currentNode;
                header.next = nodeToAdd;
                currentNode.prev = nodeToAdd;
                size++;
                return;

            } else {
                int i = 0;
                while (i < index) {
                    currentNode = currentNode.next;
                    i++;
                }
                nodeToAdd.prev = currentNode.prev;
                nodeToAdd.next = currentNode;
                currentNode.prev.next = nodeToAdd;
                currentNode.prev = nodeToAdd;

            }
            size++;
        }

        /**
         * Remove and return the element at the index.
         * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
         */
        @Override
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("index is out of bounds!");
            }
            Node<E> node = header.next;

            int i = 0;
            while (i < index) {
                node = node.next;
                i++;
            }
            Node<E> previous = node.prev;
            previous.next = node.next;
            if (previous.next.element != null) {
                node.next.prev = previous;
            }
            size--;
            return node.element;
        }

        /**
         * Return the index of the element in this list.
         * Return -1, if this list does not contain the element.
         */
        @Override
        public int indexOf(E e) {
            Node<E> head = header.next;
            int i = 0;
            while (head.element != null) {
                if (head.element.equals(e)) {
                    return i;
                }
                head = head.next;
                i++;
            }
            return -1;
        }

        /**
         * Return an iterator over this list.
         * Note: While the list is traversed by this iterator,
         * adding or removing an element is not allowed.
         */
        @Override
        public Iterator<E> iterator() {
            return new doubleLinkedListIterator();
        }

        private class doubleLinkedListIterator implements Iterator<E> {
            private Node<E> nuværende = header.next;
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public E next() {
                current++;
                E temp = nuværende.element;
                nuværende = nuværende.next;
                return temp;
            }
        }
        //-------------------------------------------

        private static class Node<T> {
            private final T element;
            private Node<T> next;
            private Node<T> prev;

            public Node(T t) {
                this.element = t;
                this.next = null;
                this.prev = null;
            }
        }

        //-------------------------------------------

        @Override
        public String toString() {
            Node<E> head = header.next;
            StringBuilder sb = new StringBuilder();
            while (head.element != null) {
                sb.append(head.element + ", ");
                head = head.next;
            }
            return sb.toString();
        }
    }

