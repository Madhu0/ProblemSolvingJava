package com.kmsr.problems.linkedlist;

import static com.kmsr.problems.utils.LinkedListsTestUtil.createLinkedListWithLoop;

import com.kmsr.models.linkedlist.Node;
import com.kmsr.models.misc.Pair;
import com.kmsr.problems.utils.LinkedListUtil;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;

public class CycleDetectionTest extends TestCase {
  public void testFindTheCycleStart_happyFlow() {
    Pair<Node<Integer>, Node<Integer>> linkedListWithLoop = createLinkedListWithLoop(
        List.of(1, 2, 3, 4, 5), 4);
    Node<Integer> theCycleStart = CycleDetection.findTheCycleStart(linkedListWithLoop.fst);
    Assert.assertEquals(linkedListWithLoop.snd, theCycleStart);
  }

  public void testFindTheCycleStart_emptyList() {
    Pair<Node<Integer>, Node<Integer>> linkedListWithLoop = createLinkedListWithLoop(
        new ArrayList<>(), 0);
    Node<Integer> theCycleStart = CycleDetection.findTheCycleStart(linkedListWithLoop.fst);
    Assert.assertNull(theCycleStart);
  }

  public void testFindTheCycleStart_selfPointing() {
    Pair<Node<Integer>, Node<Integer>> linkedListWithLoop = createLinkedListWithLoop(
        List.of(1, 2, 3, 4, 5), 4);
    Node<Integer> theCycleStart = CycleDetection.findTheCycleStart(linkedListWithLoop.fst);
    Assert.assertEquals(linkedListWithLoop.snd, theCycleStart);
  }

  public void testFindTheCycleStart_fullCycle() {
    Pair<Node<Integer>, Node<Integer>> linkedListWithLoop = createLinkedListWithLoop(
        List.of(1, 2, 3, 4, 5), 0);
    Node<Integer> theCycleStart = CycleDetection.findTheCycleStart(linkedListWithLoop.fst);
    Assert.assertEquals(linkedListWithLoop.snd, theCycleStart);
  }

  public void testFindTheCycleStart_noCycle() {
    Node<Integer> head = LinkedListUtil.createLinkedList(
        List.of(1, 2, 3, 4, 5));
    Node<Integer> theCycleStart = CycleDetection.findTheCycleStart(head);
    Assert.assertNull(theCycleStart);
  }
}
