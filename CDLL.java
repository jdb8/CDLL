package uk.ac.cam.jdb75.CDLL;

import java.util.LinkedList;

public class CDLL<T> {
    // Not a real head and tail, only helpers for internal methods
    private ListNode<T> head;
    private ListNode<T> tail;
    
    private int size;
    
    /**
     * Constructs an empty Circular Doubly Linked List, with both the head and tail
     * set to null, and a size of 0.
     */
    public CDLL(){
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Method to find the current size of the list.
     * 
     * @return an integer value for the current size of the list
     */
    public int size() {
        return size;
    }
    
    /** 
     * Deletes an item from the list.
     * 
     * The item specified must be an element of the list.
     * 
     * @param node the node to be deleted
     */
    public void delete(ListNode<T> node) {
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            if (head == node) {
                head = node.getNext();
            }
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
        size--;
    }
    
    /**
     * Adds an item to the 'end' of the list, between the tail and head.
     * 
     * @param value the value of the new item to be added
     */
    public void add(T value) {
        if (isEmpty()) {
            // List is currently empty, set head and tail to a new node pointing to itself
            ListNode<T> newNode = new ListNode<T>(value);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            insertAfter(tail, value);
        }        
    }
    
    /**
     * Adds an item after a specified node.
     * 
     * @param beforeNode the node which will come before the new item
     * @param val the value of the new item to be inserted
     * @see #insertBefore
     */
    public void insertAfter(ListNode<T> beforeNode, T val) {
        // Create a new node which points to beforeNode and beforeNode's successor
        ListNode<T> newNode = new ListNode<T>(val, beforeNode.getNext(), beforeNode);
        beforeNode.getNext().setPrev(newNode);
        beforeNode.setNext(newNode);
        size++;
    }
    
    /**
     * Adds an item before a specified node.
     * 
     * @param afterNode the node which will come after the new item
     * @param val the value of the new item to be inserted
     * @see #insertAfter
     */
    public void insertBefore(ListNode<T> afterNode, T val) {
        // Inserting before is equal to inserting after the previous node
        insertAfter(afterNode.getPrev(), val);
    }
    
    /**
     * Searches the list linearly for the first occurrence of the specified value.
     * 
     * @param val the value to search for
     * @return null if the value does not occur in the list, the node which contains the value otherwise
     */
    public ListNode<T> find(T val){
        ListNode<T> current = head;
        for (int i = 0; i < size(); i++) {
            if (current.getValue().equals(val)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    /**
     * Check if the list is empty.
     * 
     * @return true if the list is empty, otherwise false
     */
    public boolean isEmpty() {
        return (size() == 0);
    }
}
