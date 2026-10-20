/**
 * Node for semi-organized elements
 * 
 */
public class Node<T> {
    private T element;
    private Node<T> nextNode;

    /**Make an element
     * 
     * @param element
     */
    public Node(T element){
        this.element = element;
        this.nextNode = null;
        //this(element, null)
    }
    /**
     * Crete new node with given element and "index"
     * @param element
     * @param nextNode
     */
    public Node(T element, Node<T> nextNode){
        this.element = element;
        this.nextNode = nextNode;
    }
    /**
     * Getters and Setters
     */
    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public Node<T> getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
    //TODO: debugging is easier
    public String toString(){
        return element.toString();
    }
}
