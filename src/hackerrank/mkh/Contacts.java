package hackerrank.mkh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
	public static Trie trie = new Trie("");
	public static boolean chk = false;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int nItr = 0; nItr < n; nItr++) {
			String[] opContact = scanner.nextLine().split(" ");

			String op = opContact[0];

			String contact = opContact[1];
			
			if(op.equals("add")) {
				makeTrie(contact);
			} else {
				
			}
		}
		scanner.close();
	}
	
	public static void makeTrie(String str) {
		String[] sArr = str.split("");
		for(String s : sArr) {
			if(!chk) {
				trie.addLastStr(s);
			} else {
				settingTrie(trie, s);
			}
		}
		chk = true;
	}
	
	public static void settingTrie(Trie t, String s) {
		Trie temp = t.findStr(s);
		if(temp != null) {
			settingTrie(temp, s);
		} else {
			temp.addLastStr(s);
			trie = temp;
			return;
		}
	}
}

class Trie {
	public List<Trie> node = new ArrayList<>();
	public String str;
	
	public Trie(String str) {
		this.str = str;
	}
	
	public Trie findStr(String s) {
		for(Trie t : node) {
			if(t.str.equals(s)) return t;
		}
		return null;
	}
	
	public void addStr(String s) {
		node.add(new Trie(s));
	}
	
	public void addLastStr(String s) {
		node.add(node.size(), new Trie(s));
	}
	
}
