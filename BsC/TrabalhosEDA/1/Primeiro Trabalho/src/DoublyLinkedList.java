import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int N;
    private Node pre;
    private Node post;

    public DoublyLinkedList() {
        pre  = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    private class Node {
        private T item;
        private Node next;
        private Node prev;
    }

    public boolean isEmpty()    { return N == 0; }
    public int size()           { return N;      }

    public void add(T item) {
        Node last = post.prev;
        Node x = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        N++;
    }

    public ListIterator<T> iterator()  { return new DoublyLinkedListIterator(); }

    private class DoublyLinkedListIterator implements ListIterator<T> {
        private Node current      = pre.next; 
        private Node lastAccessed = null;
        private int index = 0;

        public boolean hasNext()      { return index < N; }
        public boolean hasPrevious()  { return index > 0; }
        public int previousIndex()    { return index - 1; }
        public int nextIndex()        { return index;     }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            T item = current.item;
            current = current.next; 
            index++;
            return item;
        }

        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.prev;
            index--;
            lastAccessed = current;
            return current.item;
        }

        public void set(T item) {
            if (lastAccessed == null) throw new IllegalStateException();
            lastAccessed.item = item;
        }

        public void remove() { 
            if (lastAccessed == null) throw new IllegalStateException();
            Node x = lastAccessed.prev;
            Node y = lastAccessed.next;
            x.next = y;
            y.prev = x;
            N--;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }
 
        public void add(T item) {
            Node x = current.prev;
            Node y = new Node();
            Node z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            N++;
            index++;
            lastAccessed = null;
        }

    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (T item : this)
            s.append(item + " | ");
        s.reverse();
        s.delete(0,3);
        s.reverse();
        s.append("]");
        return new String(s);
    }
}

/*
Adaptado de:
	Robert Sedgewick and Kevin Wayne. 
*/