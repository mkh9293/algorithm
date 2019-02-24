package hackerrank.joeunho.swexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//sw expert 6730
public class Race6730 {
    public static void main(String[] args) {
        int[] arr ={10, 70, 30, 50, 90};
        //int[] arr ={30, 100};
        solution(arr);
    }

    static void solution(int[] arr){
        int size = arr.length;
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();

        up.add(0);
        down.add(0);

        int cur = arr[0];
        for(int i=1;i<size;i++){
            int value = arr[i]-cur;
            if(value>0){//up
                up.add(value);
            }else{//down
                down.add(Math.abs(value));
            }
            cur = arr[i];
        }

        System.out.println(Collections.max(up)+" "+Collections.max(down));

    }

}
