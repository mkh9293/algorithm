package hackerrank.mkh;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CountPerfectSubtree {
	public static void main(String[] args) {
		Tree tree = new Tree(1);
		
		// test case 1
		// left
		Tree tree2 = new Tree(2);
		tree2.rightInsert(new Tree(4));
		tree.leftInsert(tree2);
		
		// right
		Tree tree3 = new Tree(3);
		Tree tree5 = new Tree(5);
		tree5.leftInsert(new Tree(7));
		tree5.rightInsert(new Tree(8));
		tree3.leftInsert(tree5);
		
		Tree tree10 = new Tree(10);
		tree10.leftInsert(new Tree(11));	
		Tree tree6 = new Tree(6);
		tree6.rightInsert(tree10);
		tree6.leftInsert(new Tree(9));
		tree3.rightInsert(tree6);
		
		tree.rightInsert(tree3);
		
		
//		// test case 2
//		tree.rightInsert(new Tree(3));
//		
//		Tree t4 = new Tree(4);
//		t4.leftInsert(new Tree(6));
//		t4.rightInsert(new Tree(7));
//		
//		Tree t5 = new Tree(5);
//		t5.leftInsert(new Tree(8));
//		t5.rightInsert(new Tree(9));
//		
//		Tree t2 = new Tree(2);
//		t2.leftInsert(t4);
//		t2.rightInsert(t5);
//		
//		tree.leftInsert(t2);
////		tree.preorder(tree);
		
		List<Integer> list = new ArrayList<>();
		tree.countTree(1, list, tree);
	
		int max = list.stream().mapToInt(i -> i).max().orElseThrow(NoSuchElementException::new);
		System.out.println(max);
		
	}
	
	
}

class Tree {
	public int x;
	public Tree l;
	public Tree r;
	
	public Tree(int x) {
		this.x = x;
		this.l = null;
		this.r = null;
	}
	
	public Tree leftInsert(Tree t) {
		this.x = x;
		this.l = t;
		
		return this.l;
	}
	
	public Tree rightInsert(Tree t) {
		this.x = x;
		this.r = t;
		
		return this.r;
	}
	
	public void countTree(int count, List<Integer> list, Tree t) {
		if(t!=null) {
			if(t.l != null && t.r != null) {
				count += 2;
			} else if(t.l == null && t.r == null) {
				// nothing
			} else {
				list.add(count);
				count = 1;
			}

			countTree(count, list, t.l);
			countTree(count, list, t.r);
		}
	}
	
	public void preorder(Tree t) {
		if(t!=null) {
			System.out.println(t.x);
			preorder(t.l);
			preorder(t.r);
		}
	}
}
