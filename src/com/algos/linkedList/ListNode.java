package com.algos.linkedList;

public class ListNode implements Comparable<ListNode>{
        public int val;
        ListNode next;
        public ListNode prev;
        ListNode() {}
        public ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; this.prev = null; }
        ListNode(ListNode prev, int val) { this.val = val; this.next = null; this.prev = prev; }
        static void printLinkedList(ListNode result) {
                while(result != null) {
                        System.out.print(result.val+" -> ");
                        result = result.next;
                }
        }

        @Override
        public int compareTo(ListNode that) {
                return Integer.compare(this.val, that.val);
        }
}