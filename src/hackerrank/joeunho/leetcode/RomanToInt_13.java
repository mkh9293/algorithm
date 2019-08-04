package hackerrank.joeunho.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt_13 {
    public static void main(String[] args) {
        String s ="III";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        int sum = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        //  제약사항

        /*if(s.contains("CM")){
            s = s.replace("CM","");
            sum +=900;
        }
        if(s.contains("CD")){
            s = s.replace("CD","");
            sum +=400;
        }
        if(s.contains("XC")){
            s = s.replace("XC","");
            sum +=90;
        }
        if(s.contains("XL")){
            s = s.replace("XL","");
            sum +=40;
        }
        if(s.contains("IX")){
            s = s.replace("IX","");
            sum +=9;
        }
        if(s.contains("IV")){
            s = s.replace("IV","");
            sum +=4;
        }*/

        if(s.length()>0){
            s=s+",";
            char[] ch = s.toCharArray();

            for(int i=0;i<ch.length-1;i++){
                if('I'==ch[i]){ // V,X
                    if('V'==ch[i+1]){
                        sum +=4;
                        i++;
                        continue;
                    }
                    if('X'==ch[i+1]){
                        sum +=9;
                        i++;
                        continue;
                    }
                }
                else if('X'==ch[i]){ // L,C
                    if('L'==ch[i+1]){
                        sum +=40;
                        i++;
                        continue;
                    }
                    if('C'==ch[i+1]){
                        sum +=90;
                        i++;
                        continue;
                    }
                }
                else if('C'==ch[i]){ // D,M
                    if('D'==ch[i+1]){
                        sum +=400;
                        i++;
                        continue;
                    }
                    if('M'==ch[i+1]){
                        sum +=900;
                        i++;
                        continue;
                    }
                }

                sum+=map.get(ch[i]);

            }
        }

        System.out.println(s);

        return sum;
    }
}
