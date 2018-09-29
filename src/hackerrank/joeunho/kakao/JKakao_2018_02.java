package hackerrank.joeunho.kakao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class JKakao_2018_02 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N=5;
        int[] stages ={2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(solution(N,stages));
    }

    public static int[] solution(int N, int[] stages) {

        int total = stages.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        HashMap<Integer,Double> fail = new HashMap<Integer,Double>();

        for(int i : stages){
            if(map.get(i)==null){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }


        for(int i=0;i<N;i++){
            if(map.get(i+1)==null){
                fail.put(i+1, (double) 0);
            }else{
                int r = map.get(i+1);
                double f =(double) r/total;
                total = total - r;
                fail.put(i+1, f);
            }
        }

        Integer[] in = new Integer[N];

        int count=0;
        for(int i=1;i<N+1;i++){
            in[count++]=i;
        }

        Arrays.sort(in,new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                double d = fail.get(o2)-fail.get(o1);
                int result =0;
                if(d>0){
                    result=1;
                }else if(d<0){
                    result=-1;
                }
                return result ;
            }

        });

        int[] answer = new int[N];
        int index=0;
        for(int i:in){
            System.out.println(i);
            answer[index++] = i;
        }

        return answer;
    }
}
