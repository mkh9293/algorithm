package hackerrank.mkh.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RightOfView{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
          int result = 0;

          int width = Integer.parseInt(br.readLine());
          int[] arr = new int[width];
  
          //스트링 토크나이저를 이용해 readLine()을 통해 한 줄을 한번에 입력받은것을 띄어쓰기(" ")를 기준으로 쪼갬
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int j = 0;
          int count = 0;
          
          while(st.hasMoreTokens()){
              //nextToken()을 통해 띄어쓰기(" ")를 제거하고 남은 숫자를 스트링 형태에서 int로 형변환하여 arr에 저장.
              arr[j] = Integer.parseInt(st.nextToken());
              j++;
          }

            result = solution(arr);

            System.out.println("#" + i + " "+result);
        }
    }

    public static int solution(int[] arr){
    	int result = 0;
    	
    	//로직
    	
    	
    	
    	return result;
    }
}








