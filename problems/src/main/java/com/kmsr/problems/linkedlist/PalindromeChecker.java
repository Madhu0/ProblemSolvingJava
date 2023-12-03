package com.kmsr.problems.linkedlist;

import com.kmsr.models.linkedlist.Node;

public class PalindromeChecker {
    private static class PalindromeResult {
        public Node<Character> mirrorNode;
        public boolean isPalindrome;

        public PalindromeResult(Node<Character> node, boolean isPalindrome) {
            this.mirrorNode = node;
            this.isPalindrome = isPalindrome;
        }
    }
    public static boolean isPalindrome(Node<Character> head) {
        if (head == null) return true;

        PalindromeResult result = checkIfPalindromeRecursively(head, head);
        return result.isPalindrome;
    }

    private static PalindromeResult checkIfPalindromeRecursively(Node<Character> slow, Node<Character> fast) {
        if (fast.getNext() == null) {
            return new PalindromeResult(slow.getNext(), true);
        }
        if (fast.getNext().getNext() == null) {
            return new PalindromeResult(slow.getNext().getNext(),slow.getValue() == slow.getNext().getValue());
        }
        PalindromeResult result = checkIfPalindromeRecursively(slow.getNext(), fast.getNext().getNext());
        if (!result.isPalindrome) {
            return new PalindromeResult(result.mirrorNode.getNext(), result.isPalindrome);
        }
        boolean isPalindrome = result.mirrorNode.getValue() == slow.getValue();
        return new PalindromeResult(slow.getNext(), isPalindrome);
    }
}
