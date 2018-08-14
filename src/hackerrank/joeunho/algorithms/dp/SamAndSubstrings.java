package hackerrank.joeunho.algorithms.dp;

public class SamAndSubstrings {
    public static void main(String[] args) {
        String n = "123";
        System.out.println(substrings(n));
    }
    public static int substrings(String n) {
        //123 - 1 2 3  12 23 123
        //1234 - 1 2 3 4   12 23 34  123  234  1234
        int sum = 0;
        int count = 1;
        return sumRecur(sum,count,n);
    }

    public static int sumRecur(int sum,int count,String n){
        if(count==n.length()){
            return sum+Integer.parseInt(n);
        }else{
            for(int i=0;i<n.length()+1-count;i++){
                sum+=Integer.parseInt(n.substring(i,i+count));
            }
            count++;

        }
        return sumRecur(sum,count,n);
    }

}
