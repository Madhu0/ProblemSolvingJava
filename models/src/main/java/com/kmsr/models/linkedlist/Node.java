package com.kmsr.models.linkedlist;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Node<T> {

    private T value;
    private Node<T> next;

    public static <V> Node<V> createNode(V value) {
        Node<V> node = new Node<>();
        node.setValue(value);
        return node;
    }
}
