package hackerrank.mkh.goorm;

import java.util.HashMap;
import java.util.Map;

public class LandExpand {
	public static void main(String[] args) {
		int size = 5;
//		String land = "A 0 0 0 0\n"
//				+	  "0 0 0 0 0\n"
//				+ 	  "0 0 0 0 0\n"
//				+ 	  "0 0 0 0 0\n"
//				+ 	  "0 0 0 0 B\n";
//		String land = "A 0 0 0 10\n"
//				+	  "0 0 0 10 0\n"
//				+ 	  "0 0 10 0 0\n"
//				+ 	  "0 10 0 0 0\n"
//				+ 	  "10 0 0 0 0\n";
		String land = "A 0 0 0 0\n"
				+	  "0 0 6 0 D\n"
				+ 	  "0 0 B 0 0\n"
				+ 	  "0 C 8 0 0\n"
				+ 	  "0 0 0 0 0\n";
		System.out.println(10/0);
//		solution(size, land);
	}
	
	public static void solution(int size, String land) {
		String[][] arr = new String[size][size];
		String[][] result = new String[size][size];
		
		// 2차원 배열로 변경
		String[] temp = land.split("\n");
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				arr[i] = temp[i].split(" "); 
				result[i] = arr[i];
			}
		}
		
		int count = 0;
		while(true) {
			boolean updated = false;	
			Map<int[], String> map = new HashMap<>();
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {

					// 상, 하, 좌, 우 확인
					if(isNumeric(arr[i][j])) {
						Map<String, Integer> tempMap = new HashMap<>();						
						int num = Integer.parseInt(arr[i][j]);
						
						// 하측 확인 
						if((i-1) >= 0 && (num != 1 && num != 3 && num != 5 && num != 9) && !isNumeric(arr[i-1][j])) {
							tempMap.put(arr[i-1][j], tempMap.getOrDefault(arr[i-1][j], 0)+1);
						}
						
						// 상 확인 
						if((i+1) <= size-1 && (num != 2 && num != 3 && num != 6 && num != 10) && !isNumeric(arr[i+1][j])) {
							tempMap.put(arr[i+1][j], tempMap.getOrDefault(arr[i+1][j], 0)+1);
						}
						
						// 좌측 확인 
						if((j-1) >= 0 && (num != 4 && num != 5 && num != 6 && num != 12) && !isNumeric(arr[i][j-1])) {
							tempMap.put(arr[i][j-1], tempMap.getOrDefault(arr[i][j-1], 0)+1);
						}
						
						// 우측 확인 
						if((j+1) <= size-1 && (num != 8 && num != 9 && num != 10 && num != 12) && !isNumeric(arr[i][j+1])) {
							tempMap.put(arr[i][j+1], tempMap.getOrDefault(arr[i][j+1], 0)+1);
						}
						
						// 국가 좌표 저장
						if(tempMap.size() > 0) {
							int tempVal = 0;
							String tempKey = "";
							// 인접해있는 국가가 가장 많은 곳 확인
							for(String s : tempMap.keySet()) {
								if(tempVal < tempMap.get(s)) {
									tempKey = s;
									tempVal = tempMap.get(s);
								}
							}
							
							// 인접한 국가가 모두 동일한 경우 체크
							if(tempMap.size() > 1) {
								boolean chk = false;
								for(String s : tempMap.keySet()) {
									if(tempMap.get(s) != tempVal) {
										chk = true;
										break;
									}
								}
								if(!chk) continue;	
							}
							
							map.put(new int[] {i, j}, tempKey);
							updated = true;
						} 
						
					} 
					
				}
			}

			
			if(!updated) break;
			
			
			// 배열에 국가 세팅
			for(int[] is : map.keySet()) {
				String value = map.get(is);
				arr[is[0]][is[1]] = value;
			}
			count++;
		}
		
		System.out.println(count);
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean isNumeric(String s) {
		try {
			double d = Double.parseDouble(s);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}
