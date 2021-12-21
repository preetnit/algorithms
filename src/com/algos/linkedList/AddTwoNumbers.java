package com.algos.linkedList;

import static com.algos.linkedList.ListNode.printLinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode())));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode())));

        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode result = atn.addTwoNumbers(l1, l2);
        printLinkedList(result);
        System.out.println(atn.addTwoNumbersII(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), node = head;
        int c =0;
        while(l1!= null && l2 != null) {
            int a=0, b=0;
            if(l1!= null) {
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!= null) {
                b = l2.val;
                l2 = l2.next;
            }
            int data = a+b+c;
            c = data/10;
            node.next = new ListNode(data%10);
            node = node.next;
        }
        if(c == 1) {
            node.next = new ListNode(1);
        }
        return head.next;
    }

    public int addTwoNumbersII(ListNode l1, ListNode l2) {
        int a = getNumber(l1);
        int b = getNumber(l2);

        return a+b;
    }

    private int getNumber(ListNode node) {
        int result = 0;
        int multiplier = 1;
        while(node != null) {
            result += multiplier * node.val;
            multiplier *= 10;
            node = node.next;
        }
        return result;
    }
}
