package hackerrank.mkh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckBst {
	class Node {
		int data;
		Node left;
		Node right;
	}
	 // 전위순회 순서로 list에 데이터 저장
    List<Integer> insertList(Queue<Node> queue) {
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
                list.add(node.data);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        return list;
    }

    // 이진트리 생성
    Node makeBst(Node root, int i) {
        Node temp = root;
        Node newNode = new Node();
        newNode.data = i;
        newNode.left = null;
        newNode.right = null;
        
        if(temp == null) {
            return newNode;
        } else if (temp.data < i){
            temp.right = makeBst(temp.right, i);
            return temp;
        } else {
            temp.left = makeBst(temp.left, i);
            return temp;
        }
    }

    // 중복 값 체크
    boolean checkContains(Node root, int i) {
        if(root==null) return false;
        
        if(root.data < i) {
            return checkContains(root.right, i);
        } else if (root.data > i) {
            return checkContains(root.left, i);
        } else {
            return true;
        }
    }

    boolean checkBST(Node root) {
       Queue<Node> queue = new LinkedList<Node>();
       queue.offer(root);
       List<Integer> list = insertList(queue);
    
        Node temp = null;
    
        for(int i=0; i<list.size(); i++) {
            // 중복 값 체크
            if(checkContains(temp, list.get(i))) {
                return false;
            }
            
            // 트리 구성
            temp = makeBst(temp, list.get(i));
        }
        
        queue.offer(temp);
        List<Integer> list2 = insertList(queue);
 
        for(int i=0; i<list2.size(); i++) {
            if(!list.get(i).equals(list2.get(i))){
                return false;
            }
        }
        
        return true;
    }
}
