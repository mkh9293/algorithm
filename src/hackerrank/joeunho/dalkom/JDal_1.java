package hackerrank.joeunho.dalkom;

import java.util.Arrays;
import java.util.HashMap;

public class JDal_1 {
    public static void main(String[] args) {
        //int[] arr = {2,2,1};
        int[] arr = {3,2,1,2};
        //3 2 2 1//점수 등수

        int[] temp = arr.clone();
        int size = temp.length;
        int[] reverse = new int[size];
        int[] result = new int[size];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.sort(temp);

        int count = 0;
        for(int i=size-1;i>=0;i--){
            reverse[count++]=temp[i];
        }

        int index = 1;
        int pre = 0;
        for(int i:reverse){
            if(pre!=i) {
                map.put(i, index);
                pre = i;
            }
            index++;
        }
        System.out.println(map.toString());
        for(int i=0;i<size;i++){
            result[i]=map.get(arr[i]);
            System.out.println(result[i]);
        }

    }
}
