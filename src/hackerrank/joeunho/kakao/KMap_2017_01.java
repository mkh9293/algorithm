package hackerrank.joeunho.kakao;

public class KMap_2017_01 {
    public static void main(String[] args) {
        /*int n=5;
        int[] arr1 ={9, 20, 28, 18, 11};
        int[] arr2 ={30, 1, 21, 17, 28};*/

        int n=6;
        int[] arr1 ={46, 33, 33, 22, 31, 50};
        int[] arr2 ={27, 56, 19, 14, 14, 10};


        solution(n,arr1,arr2);
    }

     public static String[] solution(int n, int[] arr1, int[] arr2) {
         String[] answer = new String[n];

         String temp1 = null;
         String temp2 = null;

         for(int i=0;i<n;i++){
             StringBuilder sb = new StringBuilder();
             temp1=convert(n,arr1[i]);
             temp2=convert(n,arr2[i]);
             for(int j=0;j<n;j++){
                 int a = Integer.parseInt(temp1.substring(j,j+1));
                 int b = Integer.parseInt(temp2.substring(j,j+1));
                 if(a==0 && b==0){
                     sb.append(" ");
                 }else{
                     sb.append("#");
                 }
             }

             answer[i]=sb.toString();

         }
        return answer;
    }

    public static String convert(int n,int a){
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(Integer.toBinaryString(a)));

        int difference = n-sb.length();
        for(int i=0;i<difference;i++){
            sb.insert(0,"0");
        }
        return sb.toString();
    }
}
