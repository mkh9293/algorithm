package hackerrank.mkh.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class JoinTable {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Table t1 = new Table();
		Table t2 = new Table();
		String nullStr = "";
		for(int i=0; i<2; i++) {
			int y = Integer.parseInt(br.readLine());
			String header = br.readLine();
			
			String[] headers = header.split(" ");
			int x = headers.length;
			
			// table1 init
			if(i == 0) {
				t1.addHeader(headers);
				
				for(int j=1; j<y; j++) {
					t1.addColumn(br.readLine());
				}	
			} else {
				// table2 init
				t2.addHeader(headers);
				
				for(int j=1; j<y; j++) {
					t2.addColumn(br.readLine());
				}
			}
			
		}
		
		
		Table join = makeJoin(t1, t2);
		
		Map<Integer, String> joinMap = join.getMap();
		Iterator<Integer> k = joinMap.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		sb.append(Arrays.toString(join.getHeader())+"\n");
		while(k.hasNext()) {
			Integer key = k.next();
			sb.append(key+ " " +joinMap.get(key)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static Table makeJoin(Table t1, Table t2) {
		Table join = new Table();
		
		Set<String> headerSet = new LinkedHashSet<>();
		for(int i=0; i<t1.getHeader().length; i++) headerSet.add(t1.getHeader()[i]);
		for(int i=0; i<t2.getHeader().length; i++) headerSet.add(t2.getHeader()[i]);
		join.addHeader(headerSet.stream().toArray(String[]::new));
		
		Map<Integer, String> m1 = t1.getMap();
		Map<Integer, String> m2 = t2.getMap();
		Iterator<Integer> keys = m1.keySet().iterator();
		while(keys.hasNext()) {
			StringBuilder sb = new StringBuilder();
			Integer key = keys.next();
            sb.append(key+" "+m1.get(key)+" ");
            
            if(m2.containsKey(key)) {
            	sb.append(m2.get(key));
            } else {
            	for(int i=0; i<t2.getHeader().length-1;i++) {
            		sb.append("NULL ");
            	}
            }
            
            join.addColumn(sb.toString());
		}
		
		return join;
	}
}


class Table {
	private String[] header;
	private Map<Integer, String> map = new HashMap<>();
	
	public void addHeader(String[] headers) {
		this.header = headers;
	}
	
	public String[] getHeader() {
		return header;
	}

	public void addColumn(String data) {
		String[] str = data.split(" ");
		int id = Integer.parseInt(str[0]);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<str.length; i++) {
			sb.append(str[i]+" ");
		}
		
		map.put(id, sb.toString().substring(0,sb.length()-1));
	}
	
	public Map<Integer, String> getMap() {
		return map;
	}
	
}