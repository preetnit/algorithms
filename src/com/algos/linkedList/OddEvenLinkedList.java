package com.algos.linkedList;


import static com.algos.linkedList.ListNode.printLinkedList;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
        null//        new ListNode(6, null)
        )))));
        OddEvenLinkedList oell = new OddEvenLinkedList();
        ListNode result = oell.oddEvenList(l1);
        printLinkedList(result);
    }

    /*public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode oddHead = head, evenHead = head.next;
        ListNode oddPointer = evenHead.next;
        ListNode evenPointer;

        while(oddPointer!= null) {
            evenPointer = oddPointer.next;
            ListNode oP = evenPointer == null? null : evenPointer.next;
            insertNodeAfter(oddHead, evenHead, oddPointer, evenPointer);
            oddHead = oddHead.next;
            evenHead = evenHead.next;
            oddPointer = oP;
        }
        return head;
    }

    private void insertNodeAfter(ListNode oddHead, ListNode evenHead, ListNode oddPointer, ListNode evenPointer) {
        evenHead.next = evenPointer;
        ListNode temp = oddHead.next;
        oddHead.next = oddPointer;
        oddPointer.next = temp;
    }*/


    /*public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head, even;
        while(odd!= null) {
            even = odd.next;
            odd.next = even != null ? even.next: null;
            even.next = even.next != null ? even.next.next: null;
            if(odd.next!=null)odd.next.next = even;
            odd = odd.next;
            even = even.next;
        }
        return head;
    }*/

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
