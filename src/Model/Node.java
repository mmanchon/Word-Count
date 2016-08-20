package Model;

/**
 * Implementa el node duna llista dinamica.
 */
public class Node {
	private Paraula element;
	private Node next;

	public Node() {}

	/**
	 * Inicialitza un node a patir dun element i un seguent.
	 */
	public Node(Paraula element, Node next) {
		this.element = element;
		this.next = next;
	}

	public Paraula getElement() {
		return element;
	}

	public void setElement(Paraula element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
