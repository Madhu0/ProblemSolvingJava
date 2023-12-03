package com.kmsr.models.linkedlist;

import junit.framework.TestCase;
import org.junit.Assert;

public class NodeTest extends TestCase {
  public void testCreateNode() {
    Node<Integer> integerNode = Node.createNode(1);
    Assert.assertEquals(Integer.valueOf(1), integerNode.getValue());
    Assert.assertNull(integerNode.getNext());
  }
}
