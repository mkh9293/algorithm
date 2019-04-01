package hackerrank.mkh;

import java.util.Scanner;
import java.util.Stack;

public class OneDArray2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        int j=1;
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
            
                game[i] = scan.nextInt();
            }
            System.out.println(j);
            String str = (canWin(leap, game)) ? "YES" : "NO" ;
            System.out.println((j++) + str);
        }
        scan.close();
	}
	
	public static boolean canWin(int leap, int[] game) {
		if(leap > game.length) return true;
		return canWin(leap, game, 0);
	}
	
	public static boolean canWin(int leap, int[] game, int index) {
		if(index >= game.length) return true;
		if(index < 0 || game[index] == 1) return false;
		
		game[index] = 1;
		return canWin(leap, game, index+leap) 
				|| canWin(leap, game, index+1) 
				|| canWin(leap, game, index-1);
	}
//	public static boolean canWin(int leap, int[] game) {
//		
//		for(int i=0; i<game.length; i++) {
//			System.out.print("["+i+" : "+game[i]+"]");
////			System.out.print(game[i]+" ");
//		}
//		
//		int len = game.length;
//		if(leap > len) return true;
//		
//		Queue<Integer> q = new ArrayDeque<>();	
//		List<Integer> list = new ArrayList<>();
//		for(int i=0; i<len; i++) {
//			if(game[i] == 0) list.add(i);
//		}
//		
//		q.add(game[0]);
//		while(!q.isEmpty()) {
//			int temp = q.poll();
//			int one = temp + 1;
//			int back = temp - 1;
//			int jump = temp + leap;
//		
//			int oneVal = list.contains(one) ? one : 0;
//			int jumpVal = list.contains(jump) ? jump : 0;
//			int backVal = list.contains(back) ? back : 0;
//			
//			if(oneVal >= len || jumpVal >= len || jump >= len) return true;
//			
//			if(oneVal != 0 || jumpVal != 0 || backVal != 0) list.remove(list.indexOf(temp));
//			if(oneVal != 0) q.add(one);
//			if(oneVal != jumpVal && jumpVal != 0) q.add(jump);
//			if(backVal != 0) q.add(back);
//			
//		}
//		
//		return false;
//	}


//	public static boolean canWin(int leap, int[] game) {
//		int i = 0;
//		int len = game.length;
//		int[] temp = new int[len];
//		
//		if(leap > len) return true;
//		Stack<Integer> stack = new Stack<>();
//		stack.push(arg0)
//		while(true) {
//			int jump = i + leap;
//			int one = i + 1;
//			int back = i - 1;
//					
//			if(jump >= len || one >= len) break;
//			if(i < 0 || temp[i] == 1) return false;
//			
//			temp[i] = 1;
//			if(game[jump] == 0) {
//				i = jump;
//			} else if(game[one] == 0) {
//				i = one;
//			} else if(back >= 0 ) {
//				i = back;
//			} else {
//				i = stack.pop();
//			}
//			stack.push(i);
//		}
//		
//		return true;
//    }
}
