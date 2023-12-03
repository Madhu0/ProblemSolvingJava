package com.kmsr.problems.stacksnqueues;

import java.util.Comparator;
import java.util.EmptyStackException;
import junit.framework.TestCase;
import org.junit.Assert;

public class MinStackTest extends TestCase {
  public void testSinglePushPop() {
    MinStack<Integer> minStack = new MinStack<>(Comparator.comparingInt(t -> t));
    minStack.push(1);
    Assert.assertEquals(Integer.valueOf(1), minStack.top());
    Assert.assertEquals(Integer.valueOf(1), minStack.min());
    Assert.assertEquals(Integer.valueOf(1), minStack.pop());
  }

  public void testMultiPushPop() {
    MinStack<Integer> minStack = new MinStack<>(Comparator.comparingInt(t -> t));
    minStack.push(10);
    Assert.assertEquals(Integer.valueOf(10), minStack.min());
    minStack.push(5);
    Assert.assertEquals(Integer.valueOf(5), minStack.min());
    minStack.push(8);
    Assert.assertEquals(Integer.valueOf(5), minStack.min());
    minStack.push(4);
    Assert.assertEquals(Integer.valueOf(4), minStack.min());
    Assert.assertEquals(Integer.valueOf(4), minStack.pop());
    Assert.assertEquals(Integer.valueOf(5), minStack.min());
    Assert.assertEquals(Integer.valueOf(8), minStack.pop());
    Assert.assertEquals(Integer.valueOf(5), minStack.min());
    Assert.assertEquals(Integer.valueOf(5), minStack.pop());
    Assert.assertEquals(Integer.valueOf(10), minStack.min());
    Assert.assertEquals(Integer.valueOf(10), minStack.pop());
  }

  public void testEmptyStack() {
    MinStack<Integer> minStack = new MinStack<>(Comparator.comparingInt(t -> t));
    try {
      minStack.min();
      Assert.fail("Expected exception");
    } catch (EmptyStackException ignored) {
    }

    try {
      minStack.pop();
      Assert.fail("Expected exception");
    } catch (EmptyStackException ignored) {
    }

    try {
      minStack.top();
      Assert.fail("Expected exception");
    } catch (EmptyStackException ignored) {
    }
  }
}
