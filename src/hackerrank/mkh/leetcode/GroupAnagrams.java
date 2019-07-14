package hackerrank.mkh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author mkh
 * https://leetcode.com/problems/group-anagrams/
 * 
 */
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> str = groupAnagrams(arr);
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) { 
		List<List<String>> arr1 = new ArrayList<>();
		Map<String, List<Integer>> map = new HashMap<>();
		
		for(int i=0; i<strs.length; i++) {
			List<Integer> list = new ArrayList<>();
			
			// 하나의 문자를 정렬
			char[] chr = strs[i].toCharArray();
			Arrays.sort(chr);
			String s = "";
			for(char c : chr)
				s += c;
			
			if(map.get(s) != null) {
				list = map.get(s);
			}
				
			list.add(i);
			
			map.put(s, list);
		}
		
		for( String key : map.keySet() ){
			List<String> arr2 = new ArrayList<>();
			List<Integer> list = map.get(key);
			
			for(int j=0; j<list.size(); j++) {
				arr2.add(strs[list.get(j)]);
			}
			
			arr1.add(arr2);
		}
		
		
		return arr1;
    }	
}
/*
 * [
	 ["ate","eat","tea"],
	 ["nat","tan"],
	 ["bat"]
	]
*/