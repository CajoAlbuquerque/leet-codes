package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        var l1 = new int[] { 2, 4, 3 };
        var l2 = new int[] { 5, 6, 4 };
        var expectedResult = new int[] { 7, 0, 8 };

        ListNode result = sut.addTwoNumbers(toLinkedList(l1), toLinkedList(l2));

        for (int i : expectedResult) {
            assertEquals(i, result.val);
            result = result.next;
        }
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        var l1 = new int[] { 0 };
        var l2 = new int[] { 0 };
        var expectedResult = new int[] { 0 };

        ListNode result = sut.addTwoNumbers(toLinkedList(l1), toLinkedList(l2));

        for (int i : expectedResult) {
            assertEquals(i, result.val);
            result = result.next;
        }
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        var l1 = new int[] { 9, 9, 9, 9, 9, 9, 9 };
        var l2 = new int[] { 9, 9, 9, 9 };
        var expectedResult = new int[] { 8, 9, 9, 9, 0, 0, 0, 1 };

        ListNode result = sut.addTwoNumbers(toLinkedList(l1), toLinkedList(l2));

        for (int i : expectedResult) {
            assertEquals(i, result.val);
            result = result.next;
        }
    }
    
    @Test
    public void Test4() {
        Solution sut = new Solution();

        var l1 = new int[] { 9, 9, 9, 9 };
        var l2 = new int[] { 9, 9, 9, 9 };
        var expectedResult = new int[] { 8, 9, 9, 9, 1 };

        ListNode result = sut.addTwoNumbers(toLinkedList(l1), toLinkedList(l2));

        for (int i : expectedResult) {
            assertEquals(i, result.val);
            result = result.next;
        }
    }

    private ListNode toLinkedList(int[] input) {
        ListNode head = null;
        for (int i = input.length - 1; i >= 0; i--) {
            if (head != null)
                head = new ListNode(input[i], head);
            else
                head = new ListNode(input[i]);
        }

        return head;
    }
}
