package eu.telecomnancy.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Stack<E> {

	private List<E> values = new ArrayList<>();

	public boolean isEmpty() {
		return this.values.isEmpty();
	}

	public void push(E elem) {
		this.values.add(elem);
	}

	public E pop() throws NoSuchElementException {
		if (!isEmpty()) return this.values.remove(this.values.size()-1);
		return null;
	}

	public int size() { return this.values.size(); }

	public E peek() {
		if (!isEmpty()) return this.values.get(this.values.size()-1);
		return null;
	}

}
