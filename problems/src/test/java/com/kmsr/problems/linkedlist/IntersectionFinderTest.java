package com.kmsr.problems.linkedlist;

import com.kmsr.models.linkedlist.Node;
import com.kmsr.models.misc.Pair;
import junit.framework.TestCase;

import java.util.Arrays;

import static com.kmsr.problems.utils.LinkedListUtil.createLinkedList;
import static com.kmsr.problems.utils.LinkedListUtil.moveAhead;

public class IntersectionFinderTest extends TestCase {
    public void testFindTheIntersection_sameLength() {
        Node<Integer> head1 = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node<Integer> head2 = createLinkedList(Arrays.asList(10, 20, 30, 40, 50));
        Node<Integer> expected = linkLists(new Pair<>(head1, head2), new Pair<>(2, 2));
        Node<Integer> actual = IntersectionFinder.findTheIntersection(head1, head2);
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected, actual);
        assertEquals(expected.getValue(), actual.getValue());
    }

    public void testFindTheIntersection_firstLonger() {
        Node<Integer> head1 = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node<Integer> head2 = createLinkedList(Arrays.asList(10, 20, 30, 40, 50));
        Node<Integer> expected = linkLists(new Pair<>(head1, head2), new Pair<>(2, 3));
        Node<Integer> actual = IntersectionFinder.findTheIntersection(head1, head2);
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected, actual);
        assertEquals(expected.getValue(), actual.getValue());
    }

    public void testFindTheIntersection_secondLonger() {
        Node<Integer> head1 = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node<Integer> head2 = createLinkedList(Arrays.asList(10, 20, 30, 40, 50));
        Node<Integer> expected = linkLists(new Pair<>(head1, head2), new Pair<>(3, 2));
        Node<Integer> actual = IntersectionFinder.findTheIntersection(head1, head2);
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected, actual);
        assertEquals(expected.getValue(), actual.getValue());
    }

    public void testFindTheIntersection_noIntersection() {
        Node<Integer> head1 = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Node<Integer> head2 = createLinkedList(Arrays.asList(10, 20, 30, 40, 50));
        linkLists(new Pair<>(head1, head2), new Pair<>(20, 20));
        Node<Integer> actual = IntersectionFinder.findTheIntersection(head1, head2);
        assertNull(actual);
    }

    public void testFindTheIntersection_nullLists() {
        Node<Integer> actual = IntersectionFinder.findTheIntersection(null, null);
        assertNull(actual);
    }

    private static Node<Integer> linkLists(Pair<Node<Integer>, Node<Integer>> heads, Pair<Integer, Integer> linkAt) {
        Node<Integer> head1 = moveAhead(heads.fst, linkAt.fst);
        Node<Integer> head2 = moveAhead(heads.snd, linkAt.snd);
        if (head1 == null || head2 == null) return null;

        head1.setNext(head2.getNext());
        return head1.getNext();
    }
}
