/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class FindLinkedListNElement {

    private Node head;

    public static void main(String[] args) {

        FindLinkedListNElement ll = new FindLinkedListNElement();


        ll.addRear(new Node(23));

        ll.addRear(new Node(32));

        ll.addRear(new Node(13));

        ll.addRear(new Node(53));

        ll.addRear(new Node(3));

        ll.addRear(new Node(321));

        ll.print();

        int k = 5;
        System.out.println(ll.printKth(k));

    }

    public Node addRear(Node n) {

        n.setNext(null);
        if (head == null) {
            head = n;

            return n;

        }

        Node headTmp = head;
        while (headTmp.getNext() != null) {
            headTmp = headTmp.getNext();
        }

        headTmp.setNext(n);

        return head;

    }

    public void print() {


        Node headTmp = head;
        while (headTmp.getNext() != null) {
            System.out.println("Data - >" + headTmp.getValue());
            headTmp = headTmp.getNext();
        }

        System.out.println("Data - >" + headTmp.getValue());
    }

    public int printKth(int k) {

        Node headTmp = head;
        Node slow = head;

        int counter = 1;
        while (headTmp.getNext() != null) {

            ++counter;

            if (counter % k == 0) {
                ///System.out.println("c->"+counter);
                slow = slow.getNext();
            }

            headTmp = headTmp.getNext();
        }

        return k > 1 ? slow.getNext().getValue() : headTmp.getValue();


    }
}

class Node {

    private Node next;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
