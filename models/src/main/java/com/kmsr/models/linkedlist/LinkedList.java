package com.kmsr.models.linkedlist;

import lombok.Data;
import lombok.NonNull;

import static java.util.Objects.nonNull;

@Data
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private long size;

    private LinkedList() {
    }

    /**
     * Creates a new linked list with given value as head node
     * @param value value of the head node
     * @return Created linked list
     * @param <V> Type of the value
     */
    public static <V> LinkedList<V> createList(@NonNull V value) {
        LinkedList<V> list = new LinkedList<>();
        list.setHead(Node.createNode(value));
        list.setLast(list.getHead());
        list.setSize(1);
        return list;
    }

    /**
     * Adds a node to the list.
     * @param value of the node to be added.
     * @return Returns the added node.
     */
    public Node<T> addNode(@NonNull T value) {
        Node<T> node = Node.createNode(value);
        last.setNext(node);

        size += 1;
        last = node;

        return node;
    }

    /**
     * Adds the node if it is not present in the list already.
     * @param value value of the node to be added.
     * @return Returns the existing node if it is already present, else returns the newly added node.
     */
    public Node<T> addNodeIfNotExists(@NonNull T value) {
        Node<T> existingNode = findNode(value);
        if (nonNull(existingNode)) {
            return existingNode;
        }
        return addNode(value);
    }

    /**
     * Finds the node with give value
     * @param value to be searched
     * @return Node if found, else null
     */
    public Node<T> findNode(@NonNull T value) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getValue().equals(value)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
}
