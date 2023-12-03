package com.kmsr.problems.utils;

import com.kmsr.models.linkedlist.Node;

import java.util.List;

public class LinkedListUtil {
    public static <T> Node<T> createLinkedList(List<T> list) {
        Node<T> head = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            Node<T> temp = new Node<>();
            temp.setValue(list.get(i));
            temp.setNext(head);
            head = temp;
        }
        return head;
    }

    public static <T> int findLength(Node<T> head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.getNext();
        }
        return len;
    }

    public static <T> Node<T> moveAhead(Node<T> head, int bySteps) {
        while(bySteps != 0 && head != null) {
            head = head.getNext();
            bySteps--;
        }
        return head;
    }
}
