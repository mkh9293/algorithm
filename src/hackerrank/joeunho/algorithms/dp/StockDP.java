package hackerrank.joeunho;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/*
@ Content : hakerRank - Stock Maximize
 */

public class StockDP {

    public static void main(String[] args) {
        //int[] arr = {5, 3, 2, 1, 2, 100, 1, 3, 2,1};
        //int[] arr = {5, 3, 2};
        //int[] arr = {1, 2, 100};
        int[] arr = {1, 3, 1, 2};

        System.out.print(solution(arr));


    }

    public static long solution(int[] prices){
        List<Integer> list = Arrays.stream(prices)
                                    .boxed()
                                    .collect(Collectors.toList());


        long profit = 0L;

        while(list.size()>1){

            long max = Collections.max(list);
            long checkPoint = list.indexOf(max);
            if(checkPoint==0){
                list.remove(0);
            }else{

                for(int i=0;i<checkPoint;i++){
                    profit +=max - list.get(0);
                    list.remove(0);
                }
                if(list.size()!=0) {
                    list.remove(0);
                }

            }

        }

        return profit;


    }

}
