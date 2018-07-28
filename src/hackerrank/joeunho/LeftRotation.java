package hackerrank.joeunho;/*
왼쪽으로 회전하는 원리

 */

public class LeftRotation {
    public static void main(String[] args) {

        int n=5;
        int d=4;
        int[] arr = {1, 2, 3, 4, 5};
        solution(n,d,arr);

    }
    public static void solution(int n ,int d ,int[] a){
        //n=5 d=4
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            int index = i-(d%n);
            if(index<0){
                index+=n;
            }
            temp[index] = a[i];
        }
        for(int i : temp){
            System.out.println(i);
        }
    }

}
