package hackerrank.joeunho.leetcode;

// https://leetcode.com/problems/add-two-numbers/


import java.math.BigInteger;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {



        StringBuilder sb1 =new StringBuilder();
        StringBuilder sb2 =new StringBuilder();
        BigInteger sum = new BigInteger("0");

        sb1.append(l1.val);
        while (l1.next != null) {
            l1 = l1.next;
            sb1.append(l1.val);

        }
        sb2.append(l2.val);
        while (l2.next != null) {
            l2 = l2.next;
            sb2.append(l2.val);
        }

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        sb1.reverse();
        sb2.reverse();
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

        BigInteger a = new BigInteger(sb1.toString());
        BigInteger b = new BigInteger(sb2.toString());


        sum = a.add(b);

        System.out.println(sum);//807

        char[] arr = String.valueOf(sum).toCharArray();
        for(char c:arr){
            System.out.println(c);
        }
        ListNode pre = new ListNode(0);
        for(int i=0;i<arr.length;i++){
            int value = arr[i] - '0';
            System.out.println(value);
            if(i==0) {
                ListNode n = new ListNode(arr[i] - '0');
                pre.next = n;
            }else{
                ListNode n = new ListNode(arr[i] - '0');
                n.next=pre.next;
                pre.next = n;
            }

        }

        return pre.next;
    }

}

