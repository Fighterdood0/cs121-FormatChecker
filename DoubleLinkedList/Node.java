/**
 * Node for semi-organized elements
 * 
 */
public class Node<T> {
    private T element;
    private Node<T> nextNode;
    private Node<T> prevNode;

    /**Make an element
     * 
     * @param element
     */
    public Node(T element){
        this.element = element;
        this.nextNode = null;
        this.prevNode = null;
        //this(element, null)
    }
    /**
     * Crete new node with given element and "index"
     * @param element
     * @param nextNode
     */
    public Node(T element, Node<T> nextNode, Node<T> prevNode){
        this.element = element;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
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

    public Node<T> getPrevNode(){
        return prevNode;
    }

    public void setPrevNode(Node<T> prevNode){
        this.prevNode = prevNode;
    }
    //TODO: debugging is easier
    public String toString(){
        return element.toString();
    }
}
