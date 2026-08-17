package com.cajoalbuquerque;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Solution with extra mem
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode result = new ListNode();

        ListNode currentNode = result;
        while (true) {
            int l1Val = currentL1 != null ? currentL1.val : 0;
            int l2Val = currentL2 != null ? currentL2.val : 0;

            int sum = l1Val + l2Val + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            currentNode.val = sum;

            if (currentL1 != null) {
                currentL1 = currentL1.next;
            }
            if (currentL2 != null) {
                currentL2 = currentL2.next;
            }

            if (currentL1 == null && currentL2 == null) {
                if (carry != 0) {
                    ListNode nextNode = new ListNode(carry);
                    currentNode.next = nextNode;
                    currentNode = nextNode;
                }

                break;
            }

            ListNode nextNode = new ListNode();
            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return result;
    }
}