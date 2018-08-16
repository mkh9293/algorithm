package hackerrank.mkh;

import java.util.Scanner;
import java.util.Stack;

public class TaleOfTwoStack {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
	}
}

class MyQueue<Integer>{
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> temp = new Stack<>();
	
	public Integer peek() {
	    if(temp.isEmpty()) swapStack();
	    return temp.peek();
	}
	
	public Integer dequeue() {
	    if(temp.isEmpty()) swapStack();
	    return temp.pop();
	}    
	
	public void enqueue(Integer item) {
	    stack.push(item);
	}
	
	public void swapStack(){
	    int size = stack.size();
	    for(int i=0; i<size; i++) {
	        temp.push(stack.pop());
	    }
	}
}
