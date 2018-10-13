package hackerrank.mkh.programmers;

import java.util.Arrays;

public class GradeScoring {
	public static void main(String[] args) {
		int[] grade = {2,2,1};
//		int[] grade = {2,3,1,2};
		System.out.println(Arrays.toString(solution(grade)));
	}
	
	public static int[] solution(int[] grade) {
//		int count = grade.length;
//		int[] result = new int[count];
//	
//		for(int i=0; i<count; i++) {
//			int temp = count - grade[i];
//			
//			if(temp == count -1) result[i] = count;
//			else result[i] = temp;
//		}
		
		int temp = 1;
		int[] result = new int[grade.length]; 
		
		for(int i=0;i<grade.length;i++) {
			result[i] = temp;
			for(int j=0;j<grade.length;j++) {
				if(grade[i] < grade[j]) {
					result[i] = ++temp;
				}
			}
			temp = 1;
		}
		
		return result;
	}
}
