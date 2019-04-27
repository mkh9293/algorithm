package hackerrank.joeunho;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.hackerrank.com/challenges/pangrams/problem?h_r=internal-search
public class Pangrams {
    public static void main(String[] args) {
        //String s = "All of the letters of the alphabet are present in the string.";
        String s = "We promptly judged antique ivory buckles for the prize";
        System.out.println(pangrams(s));
    }
    public static String pangrams(String s) {
        String result = "not pangram";
        String content = s.toLowerCase();

        char[] ch = content.toCharArray();

        Set<Character> set = new HashSet<>();
        for(char c : ch){
            if(c != ' '){
                set.add(c);
            }

        }

        if(set.size()==26){
            result = "pangram";
        }

        return result;

    }
}
