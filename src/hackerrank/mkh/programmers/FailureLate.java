package hackerrank.mkh.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FailureLate {
	public static void main(String[] args) {
		int[] arr = {4,3,3,2};
		solution(5, arr);
	}
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		
		int failCount = 0;
		int playerCount = stages.length;
		double[] temp = new double[N];
		for(int i=0; i<stages.length; i++) {
			if(stages[i] <= N) {
				temp[stages[i]-1]++;
			}
		}
		
		int tempFail = 0;
		for(int i=0; i<temp.length; i++) {
			tempFail += temp[i];
			temp[i] = temp[i] / (playerCount - failCount);
			if(Double.isNaN(temp[i])) temp[i] = 0;
			failCount = tempFail;
		}
		
		List<Double> copyTemp = new ArrayList<>();
		for(int i=0; i<N; i++) {
			copyTemp.add(temp[i]);
		}
		Arrays.sort(temp);
		
		int count = 0;
		for(int i=N-1; i>=0; i--) {
			int index = copyTemp.indexOf(temp[i]);
			answer[count++] = index+1;
			copyTemp.set(index, null);
		}
		
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
