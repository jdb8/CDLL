package uk.ac.cam.jdb75.CDLL;

public class ListNode<T> {
    private ListNode<T> next;
    private ListNode<T> prev;
    private T value;
    
    /**
     * Constructs a new singular ListNode with a value and pointers to itself.
     * @param val the value of the new node
     */
    public ListNode(T val) {
        value = val;
        next = this;
        prev = this;
    }
    
    /**
     * Constructs a new ListNode which has pointers to two pre-existing ListNodes.
     * 
     * @param val the value of the new node
     * @param nextNode the successor of this new node
     * @param prevNode the predecessor of this new node
     */
    public ListNode(T val, ListNode<T> nextNode, ListNode<T> prevNode) {
        value = val;
        next = nextNode;
        prev = prevNode;
    }
    
    /**
     * Set the next node.
     * 
     * Note: this does not change any pointers in any other nodes - to maintain the CDLL each node must be
     * set manually.
     * 
     * @param nextNode the new successor of this node
     */
    protected void setNext(ListNode<T> nextNode) {
       next = nextNode; 
    }
    
    /**
     * Set the previous node.
     * 
     * Note: this does not change any pointers in any other nodes - to maintain the CDLL each node must be
     * set manually.
     * 
     * @param prevNode the new predecessor of this node
     */
    protected void setPrev(ListNode<T> prevNode) {
       prev = prevNode;
    }
    
    /**
     * Gets the value of this node.
     * 
     * @return the value of this node
     */
    public T getValue() {
        return value;
    }

    /**
     * Gets the next node.
     * 
     * @return the successor of this node
     */
    public ListNode<T> getNext() {
        return next;
    }
    
    /**
     * Gets the previous node
     * 
     * @return the predecessor of this node
     */
    public ListNode<T> getPrev() {
        return prev;
    }
}
