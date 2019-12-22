package hackerrank.mkh.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mkh
 */
public class MakeNumberToZero {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5)));
	}
	
	public static int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		int count = n/2;
		int num = 0;
	
		if(n % 2 != 0) {
			list.add(num);
		}
		
		num += 1;
		for(int i=count; i>0 ; i--) {
			list.add(num);
			list.add(num * -1);
			
			num++;
		}
		
		return list.stream().mapToInt(x->x).toArray();
	}
}
