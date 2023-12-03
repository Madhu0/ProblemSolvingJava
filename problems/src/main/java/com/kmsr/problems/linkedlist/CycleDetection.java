package com.kmsr.problems.linkedlist;

import com.kmsr.models.linkedlist.Node;

/**
 * 1->2->3->4->5->2 slow and pointer will meet at LoopSize - SizeBeforeLoop, so one pointer starts
 * from start and another at meeting point they should meet at loop start as both of them will cover
 * SizeBeforeLoop to meet.
 */
public class CycleDetection {
  public static <T> Node<T> findTheCycleStart(Node<T> head) {
    if (head == null) {
      return null;
    }

    Node<T> slow = head;
    Node<T> fast = head;
    while(fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.getNext() == null) {
      return null;
    }
    while(slow != head) {
      slow = slow.getNext();
      head = head.getNext();
    }
    return head;
  }
}
