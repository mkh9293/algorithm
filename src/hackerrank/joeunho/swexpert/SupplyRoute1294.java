package hackerrank.joeunho.swexpert;

public class SupplyRoute1294 {
    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0,0},
                {1,1,1,0},
                {1,0,1,1},
                {1,0,1,0}
        };
        /*0 1 1 1
        1 2 2 1
        2 2 3 2
        3 2 3 2*/
        System.out.println(solutoin(arr,4));
    }
    public static int solutoin(int[][] arr, int size){


        boolean check = true;
        int sum = 0;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++){
                if(i==0 && j<size-1){
                    arr[i][j+1]= arr[i][j] + arr[i][j+1];
                }
                if(j==0 && i<size-1){
                    arr[i+1][j] =  arr[i][j] + arr[i+1][j];
                }
                if(i>0 && j>0){
                    arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1]) + arr[i][j];
                }
            }
        }

        return arr[size-1][size-1];
    }
}
