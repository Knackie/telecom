package eu.telecomnancy.lab5;

public class Element<E> {

    E value;
    Element<E> nextElement;

    public Element() {}

    public Element(E value) {
        this.value = value;
    }

    public Element(E value, Element<E> nextElement) {
        this.value = value;
        this.nextElement = nextElement;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Element<E> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element<E> nextElement) {
        this.nextElement = nextElement;
    }
}
