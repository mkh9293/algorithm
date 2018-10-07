package hackerrank.mkh.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingScore {
	public static void main(String[] args) {
//		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
//		System.out.println(solution("Blind",pages));
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		System.out.println(solution("Muzi",pages));
	}
	
	public static int solution(String word, String[] pages) {
		int answer = 0;
		word = word.toLowerCase();
		List<Page> pageList = new ArrayList<>();
		
		Map<String, Page> map = new HashMap<>();
		int index = 0;
		for(String s : pages) {
			s = s.toLowerCase();
			int num = 0;
		
			String[] bodys = s.split("[^a-z]");
			for(String b : bodys) {
				if(b.equals("")) continue;
				if(b.toLowerCase().contains(word) && b.length() == word.length()) {
					num++;
				}	
			}
			
			Page page = new Page();
			page.url = searchUrl(s,"<meta[^>]*content=[\"']?([^>\"']+)[\"']?[^>]*>").get(0);
			page.linkList = searchUrl(s, "<a[^>]*href=[\"']?([^>\"']+)[\"']?[^>]*>");
			page.index = index++;
			page.base = num;
			map.put(page.url, page);
			pageList.add(page);
		}
		
		// link 점수 구하기
		for(Page page : pageList) {
			for(String s : page.linkList) {
				Page tempPage = map.get(s);
				if(tempPage!=null) {
					tempPage.link += (double)page.base / page.linkList.size();	
				}
			}
		}
		
		// matching 점수 구하기
		for(Page page : pageList) {
			page.matching = page.base + page.link;
		}
	
		Collections.sort(pageList);
		return pageList.get(0).index;
	}
	
	public static List<String> searchUrl(String str, String reg) {
		List<String> list = new ArrayList<>();

		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		while(m.find()) {
			list.add(m.group(1));
		}
		return list;
	}
}

class Page implements Comparable<Page> {
	int index;
	int base;
	double link;
	double matching;
	String url;
	List<String> linkList = new ArrayList<>();
	
	public Page getPage() {
		return this;
	}
	
	public void setLink(String url) {
		linkList.add(url);
	}
	
	@Override
	public int compareTo(Page page) {
		if(this.matching > page.matching) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
