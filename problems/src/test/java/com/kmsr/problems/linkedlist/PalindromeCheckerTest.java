package com.kmsr.problems.linkedlist;

import com.kmsr.models.linkedlist.Node;
import com.kmsr.problems.utils.LinkedListUtil;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;

public class PalindromeCheckerTest extends TestCase {
    public void testIsPalindrome_happyFlowEvenLength() {
        Node<Character> head = LinkedListUtil.createLinkedList(Arrays.asList('m', 'a', 'a', 'm'));
        Assert.assertTrue(PalindromeChecker.isPalindrome(head));
    }

    public void testIsPalindrome_happyFlowOddLength() {
        Node<Character> head = LinkedListUtil.createLinkedList(Arrays.asList('m', 'a', 'm'));
        Assert.assertTrue(PalindromeChecker.isPalindrome(head));
    }

    public void testIsPalindrome_NoPalindromeEvenLength() {
        Node<Character> head = LinkedListUtil.createLinkedList(Arrays.asList('m', 'a', 'b', 'm'));
        Assert.assertFalse(PalindromeChecker.isPalindrome(head));
    }

    public void testIsPalindrome_NoPalindromeOddLength() {
        Node<Character> head = LinkedListUtil.createLinkedList(Arrays.asList('b', 'm', 'm'));
        Assert.assertFalse(PalindromeChecker.isPalindrome(head));
    }

    public void testIsPalindrome_emptyList() {
        Assert.assertTrue(PalindromeChecker.isPalindrome(null));
    }

    public void testIsPalindrome_oneNode() {
        Node<Character> head = new Node<>();
        head.setValue('c');
        Assert.assertTrue(PalindromeChecker.isPalindrome(head));
    }
}
