package hackerrank.mkh;

import java.util.Hashtable;
import java.util.Scanner;

public class RansomNote {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
	}
	
	static void checkMagazine(String[] magazine, String[] note) {
		Hashtable<String, Integer> t = new Hashtable<>();
		int count = 1;
		
		for(int i=0; i<magazine.length; i++) {
			if(t.containsKey(magazine[i])) {
				count = t.get(magazine[i])+1;
			} else {
				count = 1;
			}
			t.put(magazine[i], count);
		}
		
		for(int i=0; i<note.length; i++) {
			if(!t.containsKey(note[i]) || t.get(note[i]) < 1) {
				System.out.println("No");
				return;
			} else {
				t.put(note[i], t.get(note[i])-1);
			}
		}

		System.out.println("Yes");
    }
}
