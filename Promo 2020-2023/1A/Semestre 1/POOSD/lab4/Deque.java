package eu.telecomnancy.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Deque<E> {

    private List<E> values = new ArrayList<>();

    public int size() { return this.values.size(); }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public void pushFront (E elem) {
        ArrayList<E> temp = new ArrayList<>();
        temp.add(elem);
        temp.addAll(values);
        this.values = temp;
    }

    public void pushBack(E elem) {
        this.values.add(elem);
    }

    public E popFront() throws NoSuchElementException {
        if (!isEmpty()) return this.values.remove(0);
        throw new NoSuchElementException();
    }

    public E popBack() throws NoSuchElementException {
        if (!isEmpty()) return this.values.remove(this.values.size()-1);
        throw new NoSuchElementException();
    }

    public E peekFront() throws NoSuchElementException {
        if (!isEmpty()) return this.values.get(0);
        throw new NoSuchElementException();
    }

    public E peekBack() throws NoSuchElementException{
        if (!isEmpty()) return this.values.get(this.values.size()-1);
        throw new NoSuchElementException();
    }

}
