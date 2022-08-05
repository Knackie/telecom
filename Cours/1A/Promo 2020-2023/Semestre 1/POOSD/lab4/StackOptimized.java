package eu.telecomnancy.lab5;

import java.util.NoSuchElementException;

public class StackOptimized<E> {

    Element<E> head;

    public boolean isEmpty() { return head == null; }

    public E peek() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return this.head.getValue();
    }

    public void push(E elem) {
        this.head = new Element<>(elem, this.head);
    }

    public E pop() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        E elem = this.head.getValue();
        if (this.head != null) this.head = this.head.getNextElement();
        return elem;
    }

    public int size () {
        if (isEmpty()) return 0;
        int nbElem = 1;
        Element<E> elem = this.head;
        while (elem.getNextElement() != null) {
            nbElem++;
            elem = elem.getNextElement();
        }
        return nbElem;
    }

}
