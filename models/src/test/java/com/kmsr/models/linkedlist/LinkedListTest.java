package com.kmsr.models.linkedlist;

import junit.framework.TestCase;
import org.junit.Assert;

public class LinkedListTest extends TestCase {

  public void testCreateList() {
    LinkedList<Integer> ll = LinkedList.createList(1);
    Assert.assertEquals(Integer.valueOf(1), ll.getHead().getValue());
    Assert.assertEquals(Integer.valueOf(1), ll.getLast().getValue());
    Assert.assertEquals(1, ll.getSize());
    LinkedList<String> llString = LinkedList.createList("abc");
    Assert.assertEquals("abc", llString.getHead().getValue());
    Assert.assertEquals("abc", llString.getLast().getValue());
    Assert.assertEquals(1, ll.getSize());
  }

  public void testAddNode() {
    LinkedList<Integer> ll = LinkedList.createList(1);
    Node<Integer> newNode1 = ll.addNode(2);
    Assert.assertEquals(Integer.valueOf(2), newNode1.getValue());
    Assert.assertEquals(newNode1, ll.getLast());
    Assert.assertEquals(Integer.valueOf(2), ll.getLast().getValue());
    Assert.assertEquals(2, ll.getSize());
    Node<Integer> newNode2 = ll.addNode(3);
    Assert.assertEquals(Integer.valueOf(3), ll.getLast().getValue());
    Assert.assertEquals(3, ll.getSize());
    Assert.assertEquals(newNode2, ll.getLast());
  }

  public void testAddNodeIfNotExists() {
    LinkedList<Integer> ll = LinkedList.createList(1);
    Node<Integer> newNode1 = ll.addNode(2);
    Assert.assertEquals(Integer.valueOf(2), ll.getLast().getValue());
    Assert.assertEquals(2, ll.getSize());
    Assert.assertEquals(newNode1, ll.getLast());
    Node<Integer> newNode2 = ll.addNode(3);
    Assert.assertEquals(Integer.valueOf(3), ll.getLast().getValue());
    Assert.assertEquals(3, ll.getSize());
    Assert.assertEquals(newNode2, ll.getLast());
    Node<Integer> newNode3 = ll.addNodeIfNotExists(3);
    Assert.assertEquals(3, ll.getSize());
    Assert.assertEquals(newNode2, newNode3);
    Node<Integer> newNode4 = ll.addNodeIfNotExists(2);
    Assert.assertEquals(3, ll.getSize());
    Assert.assertEquals(newNode1, newNode4);
  }

  public void testFindNode() {
    LinkedList<Integer> ll = LinkedList.createList(1);
    Node<Integer> newNode2 = ll.addNode(2);
    Node<Integer> newNode3 = ll.addNode(3);
    Node<Integer> newNode4 = ll.addNode(4);
    Node<Integer> newNode5 = ll.addNode(5);
    Assert.assertEquals(ll.getHead(), ll.findNode(1));
    Assert.assertEquals(newNode2, ll.findNode(2));
    Assert.assertEquals(newNode3, ll.findNode(3));
    Assert.assertEquals(newNode4, ll.findNode(4));
    Assert.assertEquals(newNode5, ll.findNode(5));
  }

}
