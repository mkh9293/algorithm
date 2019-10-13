package hackerrank.mkh.synapsoft;

import java.util.HashSet;
import java.util.Set;

public class pixelCount {
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		String input = "1 0 4 2\n" +
                "8 3 9 4\n" +
                "2 3 5 7\n" +
                "4 6 7 8\n" +
                "3 1 6 5\n" +
                "1 8 4 10\n" +
                "7 2 9 5\n" +
                "8 8 10 9\n" +
                "1 4 2 6";
        System.out.println(solution(input));
	}
	
	static int solution(String input) {
		String[] lines = input.split("\n");
		
        for (int i = 0; i < lines.length; i++) {
            String[] slice = lines[i].split(" ");
//            int square_left_x = Integer.parseInt(slice[0]);
//            int square_right_x = Integer.parseInt(slice[2]);
//            int square_up_y = Integer.parseInt(slice[1]);
//            int square_down_y = Integer.parseInt(slice[3]);

//            System.out.print(square_left_x);
//            System.out.print(square_right_x);
//            System.out.print(square_up_y);
//            System.out.print(square_down_y);
//            System.out.println();
            int one = Integer.parseInt(slice[0]);
            int two = Integer.parseInt(slice[1]);
            int three = Integer.parseInt(slice[2]);
            int four = Integer.parseInt(slice[3]);
            make(one, two, three, four);
            
        }
        
		return set.size();
	}
	
	static void make(int one, int two, int three, int four) {
        for(int i=two; i<four; i++) {
        	for(int j=one; j<three; j++) {
        		set.add(i + " : " + j);
        	}
        }
       
	}
}
