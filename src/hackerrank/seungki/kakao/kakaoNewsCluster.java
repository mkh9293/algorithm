package hackerrank.seungki.kakao;

import java.util.ArrayList;
import java.util.List;
public class kakaoNewsCluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(solution("ab","bc"));
	}

	static int solution(String str1, String str2) {
		List<String> halist = new ArrayList<>();
		List<String> list = new ArrayList<>();
		List<String> kolist = new ArrayList<>();
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		for (int a = 0; a < str1.length() - 1; a++) {
			String k = str1.substring(a, a + 2);
			if (k.charAt(0) >= 'A' && k.charAt(0) <= 'Z' && k.charAt(1) >= 'A' && k.charAt(1) <= 'Z') {
				list.add(k);
				halist.add(k);
			}
		}
		for (int a = 0; a < str2.length() - 1; a++) {
			String k = str2.substring(a, a + 2);
			if (k.charAt(0) >= 'A' && k.charAt(0) <= 'Z' && k.charAt(1) >= 'A' && k.charAt(1) <= 'Z') {
				if (list.contains(k)) {
					list.remove(k);
					kolist.add(k);
				} else {
					halist.add(k);
				}
			}
		}
		double hap = halist.size();
		double ko = kolist.size();
		int answer = (int) ((ko / hap) * (double) 65536);
//	    System.out.println(hap);
//	    System.out.println(ko);
		if (ko == 0 || hap == 0) {
			return 65536;
		}
		return answer;
	}
}
