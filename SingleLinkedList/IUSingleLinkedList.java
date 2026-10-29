import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
Create a list that does not use indexes, instead using linked nodes.

@author Zach Jessup
@date 10/30/26
*/

public class IUSingleLinkedList<T> implements IndexedUnsortedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private int modCount;

    public IUSingleLinkedList(){
        head = tail = null;
        size = 0;
        modCount = 0;
    }

    @Override
    public void addToFront(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.setNextNode(head);
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        Node<T> newNode = new Node<T>(element);
        if(!isEmpty()){
        tail.setNextNode(newNode);
        }else{
            head = newNode;
        }
        tail = newNode;
        size++;
        modCount++;
    }

    @Override
    public void add(T element) {
        addToRear(element);
    }

    @Override
    public void addAfter(T element, T target) {
        Node<T> newNode = new Node<T>(element);//create New Node
        Node<T> targetNode = head;
        //find the correct node
        while(targetNode != null && !targetNode.getElement().equals(target)){
            targetNode = targetNode.getNextNode();
        }
        if(targetNode == null){
            throw new NoSuchElementException();
        }
        //tail edgecase
        if(tail == targetNode){
            tail = newNode;
        }
        //finalize
        newNode.setNextNode(targetNode.getNextNode());
        targetNode.setNextNode(newNode);
        size++;
        modCount++;
    }

    @Override
    public void add(int index, T element) {//TODO
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<T>(element);//create New Node
        Node<T> searchNode = head;
        if(index == 0){
            head = newNode;
            if(tail == null){
                tail = newNode;
            }
        }else{
        for(int i = 0; i<index-1; i++){
            searchNode = searchNode.getNextNode();
        }
        newNode.setNextNode(searchNode.getNextNode());
        searchNode.setNextNode(newNode);
        if(newNode.getNextNode() == null){
            tail = newNode;
        }
        }
        size++;
        modCount++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T removedElement = head.getElement();
        head = head.getNextNode();
        size--;
        modCount++;
        return removedElement;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T removedElement = tail.getElement();
        Node<T> searchNode = head;
        while(!searchNode.getNextNode().equals(tail)){
            searchNode = searchNode.getNextNode();
        }
        tail = searchNode;
        size--;
        modCount++;
        return removedElement;
    }

    @Override
    public T remove(T element) {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T removedElement = null;
        Node<T> searchNode = head;
        if(head.getElement().equals(element)){
            removedElement = head.getElement();
            head = head.getNextNode();
            if(head == null){
                tail = null;
            }
        }else{
        while(searchNode.getNextNode() != null && !searchNode.getNextNode().getElement().equals(element)){
            searchNode = searchNode.getNextNode();
        }
        if(searchNode.getNextNode() == null){//not found
            throw new NoSuchElementException();
        }
        removedElement = searchNode.getNextNode().getElement();
        searchNode.setNextNode(searchNode.getNextNode().getNextNode());
        if(searchNode.getNextNode() == null){
            tail = searchNode;
        }
        }
        size--;
        modCount++;
        return removedElement;
    }

    @Override
    public T remove(int index) {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T removedElement = null;
        if(index == 0){
            removedElement = head.getElement();
            head = head.getNextNode();
            if(head == null){
                tail = null;
            }
        }else{
        Node<T> node = head;
        for(int i = 0; i<index; i++){
            node = node.getNextNode();
        }
        removedElement = node.getNextNode().getElement();
        node.setNextNode(node.getNextNode().getNextNode());
        if(node.getNextNode() == null){
            tail = node;
        }
        }
        size--;
        modCount++;
        return removedElement;
    }

    @Override
    public void set(int index, T element) {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        for(int i = 0; i<index; i++){
            node = node.getNextNode();
        }
        modCount++;
        node.setElement(element);
    }

    @Override
    public T get(int index) {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T returnElement = null;
        Node<T> node = head;
        for(int i = 0; i<index; i++){
            node = node.getNextNode();
        }
        returnElement = node.getElement();
        return returnElement;
    }

    @Override
    public int indexOf(T element) {
        int currentIndex = 0;
        int returnIndex = -1;
        Node<T> currentNode = head;
        while(currentNode != null && returnIndex < 0){
            if(!currentNode.getElement().equals(element)){
            returnIndex = currentIndex;
            }else{
            currentNode = currentNode.getNextNode();
            currentIndex++;
            }
        }
        return returnIndex;
    }

    @Override
    public T first() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.getElement();
    }

    @Override
    public T last() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target)>-1;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        // TODO toString method
        StringBuilder str = new StringBuilder();
		str.append("[");
		for (T element : this){
			str.append(element);
			str.append(", ");
		}
		if(!isEmpty()){
			str.delete(str.length()-2,str.length());
		}
		str.append("]");
		return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new SllIterator();
    }

    //ListIterator not yet
    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int startingIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    /** Basic Iterator for SLL */
    private class SllIterator implements Iterator<T> {
        private Node<T> nextNode;
        private int iterModCount;
        private boolean canRemove;

        public SllIterator(){
            nextNode = head;
            iterModCount = modCount;
            canRemove = false;
        }

        @Override
        public boolean hasNext(){
            if (iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            return nextNode != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T retVal = nextNode.getElement();
            nextNode = nextNode.getNextNode();
            canRemove = true;
            return retVal;
        }
    
        @Override
        public void remove(){
            if (iterModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if (!canRemove){
                throw new IllegalStateException();
            }
            canRemove = false;
            if(head.getNextNode() == nextNode){//is it fist element?
                head = head.getNextNode();
                if(head == null){//was it one element?
                    tail = null;
                }
            }else{
            Node<T> searchNode = head;
            while((searchNode.getNextNode().getNextNode() != nextNode)){
                searchNode = searchNode.getNextNode();
            }
            searchNode.setNextNode(nextNode);
            if(nextNode == null){//is it the last element?
                tail = searchNode;
            }
            }
            //every situation requires these
            modCount++;
            iterModCount++;
            size--;
        }
    }//end of Iterator class
}//end of entire class