package com.kmsr.problems.utils;

import static java.util.Objects.isNull;

import com.kmsr.models.linkedlist.Node;
import com.kmsr.models.misc.Pair;
import java.util.List;

public class LinkedListsTestUtil {
 public static <T> Pair<Node<T>, Node<T>> createLinkedListWithLoop(List<T> values, int loopPos) {
   if (isNull(values) || values.isEmpty()) {
     return new Pair<>(null, null);
   }
   if (loopPos >= values.size()) {
     throw new RuntimeException("Loop pos should be less than length of ");
   }
   Node<T> head = LinkedListUtil.createLinkedList(values);
   Node<T> loopPoint = head;
   Node<T> lastNode = head;
   while(lastNode.getNext() != null) {
     if (loopPos > 0) {
       loopPos--;
       loopPoint = loopPoint.getNext();
     }
     lastNode = lastNode.getNext();
   }
   lastNode.setNext(loopPoint);
   return new Pair<>(head, loopPoint);
 }
}
