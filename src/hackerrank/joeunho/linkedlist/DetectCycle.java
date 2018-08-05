package hackerrank.joeunho.linkedlist;

/*
@Author eunho
@out https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
 */

class Node {
    int data;
    Node next;
}

public class DetectCycle {
    public static void main(String[] args) {

    }

    boolean hasCycle(Node head) {
        Node rabbit=head;//fast
        Node turtle=head;//slow
        while(rabbit!=null&&rabbit.next!=null){
            rabbit=rabbit.next.next;
            turtle=turtle.next;
            if(rabbit==turtle){
                return true;
            }
        }
        return false;
    }


}
