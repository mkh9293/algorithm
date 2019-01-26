package hackerrank.joeunho.shoping;


public class GoodString {
    public static void main(String[] args) {
//        String a ="aabbabab";
//        String b ="aaaabbbb";

        String a ="aabaaabbabbb";
        String b ="abababababab";

//        String a ="aaabbb";
//        String b ="aababb";
        System.out.println("result : "+solition(a,b));
    }
    public static int solition(String a,String b){
        if(a.equals(b)){
            return 0;
        }
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        int size1 = ch1.length;
        int size2 = ch2.length;

        if(size1!=size2){
            return -1;
        }

        int count = 0;
        for(int i=0;i<size1;i++){
            char c1 = ch1[i];
            char c2 = ch2[i];

            if(c1!=c2){
                for(int j=i+1;j<size2;j++){
                    c2=ch2[j];
                    if(c1==c2){
                        int location_count = j-i;
                        count+=location_count;

                        //swap 메서드로 따로 빼기
                        //이 상황에서 swap기능을 빼는 이유는 보기 좋은 리팩토링 연습을 위해
                        ch2 = swap(ch2,i,j);
                        break;
                    }
                }
            }
        }

        return count;
    }

    public static char[] swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }

}
