package hackerrank.mkh.goorm;

import java.util.Arrays;
import java.util.Scanner;

public class BillboardAdbvert {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int lotate = scan.nextInt();
		scan.nextLine();
		
		String[][] element = new String[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size ;j++) {
				element[i][j] = scan.next();
			}
		}
		
		rotateArr(element, lotate);
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size ;j++) {
				System.out.print(element[i][j]+" ");
			}
			System.out.println();
		}
		
		
		// lotate test
		lotate = 2;
		size = 2;
		String[] test = {"김연아", "김아연","아연김","아김연","김김아"};
		int n = lotate;
		 if(n < 0) // rotating left?
	      {
	          n = -n % size; // convert to +ve number specifying how 
	                                // many positions left to rotate & mod
	          n = size - n;  // rotate left by n = rotate right by length - n
	      }
		 	String[] result = new String[size];
	      for(int i = 0; i < size; i++){
	    	  System.out.println("count : "+(i+n) % size);
	          result[(i+n) % size ] = test[i];
	      }
	      
	      System.out.println(Arrays.toString(result));
	}
	
	static String[][] rotateArr(String[][] a, int lotate) {
        int n = a.length;
        int num = 0;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n-i-1; j++){
            	if(i%2 == 0 && lotate > 0) {
            		// 오른쪽으로 lotate
            		num = (i+lotate) % n;
            	} else {
            		// 왼쪽으로 lotate
            		num = (i+(n-lotate)) % n; 
            	}
            	
            	System.out.println("num : "+num);
                String temp = a[i][j];
//                a[i][j] = a[n-j-1][i];
                a[i][j] = a[num-j-1][i];
                a[num-j-1][i] = a[num-1-i][num-1-j];
                a[num-1-i][num-1-j] = a[j][num-1-i];
                a[j][num-1-i] = temp;
//                a[n-j-1][i] = a[n-1-i][n-1-j];
//                a[n-1-i][n-1-j] = a[j][n-1-i];
//                a[j][n-1-i] = temp;
            }
        }
        return a;
    }
	
}
