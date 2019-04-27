package hackerrank.mkh;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pangrams {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);
        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
    }
    
    // Complete the pangrams function below.
    static String pangrams(String s) {
    	Set<String> set = new HashSet<>();
    	
    	String[] sArr = s.split("");
    	for(String a : sArr) {
    		if(a.matches("[a-zA-Z]")) {
    			set.add(a.toLowerCase());
    		}
    	}
    	
    	if(set.size() == 26) return "pangram";
    	return "not pangram";
    }
    
    static String pangrams2(String s) {
    	long count = Pattern.compile("").splitAsStream(s.toLowerCase())
    			     .filter(a->Pattern.matches("[a-zA-z]", a))
    			     .collect(Collectors.toSet())
    			     .size();
    	
    	return count == 26 ? "pangrams" : "not pangrams";
    }
}
