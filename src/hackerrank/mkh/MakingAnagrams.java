package hackerrank.mkh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MakingAnagrams {
	 private static final int NUM_LETTERS = 26; // we assume lower-case letters only
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        
        System.out.println(res);

        scanner.close();
	}
	
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	// 문제는 a에 있는 문자가 b에 없을 경우, 또는 b에 있는 문자가 a에 없는 경우 해당 문자를 삭제 시키고 그 횟수를 리턴.
    	List<String> aList = new ArrayList<>(Arrays.asList(a.split("")));
    	List<String> bList = new ArrayList<>(Arrays.asList(b.split("")));
    	int aSize = aList.size();
    	int bSize = bList.size();
    	   	
    	// a와 b 전체 사이즈에서 각 리스트에 동일한 문자를 제외한 나머지 문자의 수를 구해서 처리.
    	// 루프를 돌리면서, a와 b에 같은 문자가 있을 경우 각 리스트의 전체 사이즈에서 -1 처리.
    	// bList에는 동일한 문자가 있을 수 있으므로 remove(i) 처리.
    	for(String i : aList) {
    		if(bList.contains(i)) {
    			aSize--;
    			bSize--;
    			bList.remove(i);
    		}
    	}
    	
    	return aSize + bSize;
    }
}
