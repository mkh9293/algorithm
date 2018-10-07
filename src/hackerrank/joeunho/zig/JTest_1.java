package hackerrank.joeunho.zig;

import java.util.HashSet;

public class JTest_1 {
    public static void main(String[] args) {
        //int p = 1987;
        int p = 2015;
        p=p+1;
        boolean check = true;
        HashSet<Character> map = new HashSet<Character>();
        int result =0;

        do{
            char[] ch = String.valueOf(p).toCharArray();
            for(char c : ch){
                map.add(c);
            }
            if(map.size()==4){
                result = p;
                check = false;
            }else{
                p++;
            }
            map.clear();
        }while(check);

        System.out.println("result : "+result);
    }
}
