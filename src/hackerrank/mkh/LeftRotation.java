package hackerrank.mkh;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LeftRotation {
	static void leftRotation2(int[] arr, int d) {
		int arrLen = arr.length;
		int temp;
		
		for (int i=0; i<d; i++) {
			for(int j=0; j<arrLen; j++) {
				if(j+1 < arrLen) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void leftRotation(int[] arr, int d) {
		int arrLen = arr.length;
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		for (int i=0; i<d; i++) {
//			for(int j=arrLen; j>0; j--) {
//				Collections.swap(list,j,j+d);
//			}
			Collections.rotate(list,d);
		}
		
		list.forEach(w->System.out.print(w+" "));
	}
	

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];
        int[] result = new int[n];
        
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        
//        leftRotation(a,d);
        for(int i=0;i<a.length;i++) {
        	result[(i+(d)) % a.length ] = a[i];	
        }
        
        System.out.println(Arrays.toString(result));
        
        scanner.close();
    }
}
