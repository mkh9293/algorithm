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

class MyQueue<T> {
	Stack<T> main = new Stack<>();
	Stack<T> sub = new Stack<>();
	
	void enqueue(T num) {
		main.push(num);
	}
	T dequeue() {
		if(sub.isEmpty()) moveStack(main, sub);
		return sub.pop();
	}
	T peek() {
		if(sub.isEmpty()) moveStack(main, sub);
		return sub.peek();
	}
	void moveStack(Stack<T> main, Stack<T> sub) {
		while(!main.isEmpty()) {
			sub.push(main.pop());
		}
	}
}
