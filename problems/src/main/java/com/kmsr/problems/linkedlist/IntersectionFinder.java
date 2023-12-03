package com.kmsr.problems.linkedlist;

import com.kmsr.models.linkedlist.Node;
import com.kmsr.problems.utils.LinkedListUtil;

import static com.kmsr.problems.utils.LinkedListUtil.findLength;

/**
 * Let's say if two linked lists meet at some point, find the intersection point.
 * 1->2->3->4->null
 * 10->9->8->3->4->null
 * return 3
 */
public class IntersectionFinder {
    public static Node<Integer> findTheIntersection(Node<Integer> list1, Node<Integer> list2) {
        int len1 = LinkedListUtil.findLength(list1);
        int len2 = LinkedListUtil.findLength(list2);
        if (len1 > len2) {
            list1 = LinkedListUtil.moveAhead(list1, len1 - len2);
        } else {
            list2 = LinkedListUtil.moveAhead(list2, len2 - len1);
        }
        while(list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.getNext();
            list2 = list2.getNext();
        }
        return null;
    }

}
