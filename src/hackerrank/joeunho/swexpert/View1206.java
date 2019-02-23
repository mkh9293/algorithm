package hackerrank.joeunho.swexpert;


public class View1206 {
    public static void main(String[] args)throws Exception {
        int[] arr = {0, 0, 3, 5, 2, 4, 9, 0, 6, 4, 0, 6, 0, 0};
        System.out.println(solution(arr));

    }
    public static int solution(int[] arr){
        int size = arr.length;
        int sum = 0;
        for(int i=2;i<size-2;i++){
            //차액
            int min = 0;
            int left1 = arr[i] - arr[i-2];
            int left2 = arr[i] - arr[i-1];
            int right1 = arr[i] - arr[i+1];
            int right2 = arr[i] - arr[i+2];
            if(left1 >0 && left2 >0 && right1 >0 && right2 >0){
                min = left1;
                if(min>left2){
                    min= left2;
                }
                if(min>right1){
                    min= right1;
                }
                if(min>right2){
                    min = right2;
                }
            }
            sum+=min;

        }

        return sum;
    }
}
