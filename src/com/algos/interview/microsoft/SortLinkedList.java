package com.algos.interview.microsoft;

/**
 * Sort a linked list of 0s, 1s and 2s
 * Input: 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL
 * Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL
 *
 * Input: 1 -> 1 -> 2 -> 1 -> 0 -> NULL
 * Output: 0 -> 1 -> 1 -> 1 -> 2 -> NULL
 *
 */

public class SortLinkedList {

    Node head;

    SortLinkedList(){
        this.head = null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data  = data;
            this.next = null;
        }
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortLinkedList ll = new SortLinkedList();
        ll.push(1);
        ll.push(1);
        ll.push(2);
        ll.push(0);
        ll.push(2);
        ll.push(0);
        ll.push(1);

        ll.printList();

        ll.sortList();
    }

    private void sortList() {
    }
}

