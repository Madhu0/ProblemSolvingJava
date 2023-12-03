package com.kmsr.problems.stacksnqueues;

import static java.util.Objects.isNull;

import com.kmsr.models.linkedlist.Node;
import java.util.Comparator;
import java.util.EmptyStackException;

public class MinStack<T> {
  private Node<T> stack;
  private Node<T> minList;
  private int size;

  private final Comparator<T> comparator;

  public MinStack(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  public void push(T val) {
    Node<T> newNode = Node.createNode(val);
    newNode.setNext(stack);
    stack = newNode;
    size++;
    pushIntoMinList(val);
  }

  public T pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Node<T> toBeRemoved = stack;
    stack = stack.getNext();
    removeFromMinList(toBeRemoved.getValue());
    size--;
    return toBeRemoved.getValue();
  }

  public T top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return stack.getValue();
  }

  public T min() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return minList.getValue();
  }

  private void pushIntoMinList(T val) {
    if (isNull(minList) || comparator.compare(minList.getValue(), val) >= 0) {
      Node<T> newNode = Node.createNode(val);
      newNode.setNext(minList);
      minList = newNode;
    }
  }

  private void removeFromMinList(T val) {
    if (comparator.compare(minList.getValue(), val) == 0) {
      minList = minList.getNext();
    }
  }
}
