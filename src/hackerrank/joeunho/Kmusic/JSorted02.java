package hackerrank.joeunho.Kmusic;

import java.util.*;

public class JSorted02 {
    public static void main(String[] args) {
        int[] arr ={8,5,5,5,5,1,1,1,4,4};
        //int[] arr ={3,1,2,2,4};
        List<Integer> list = new ArrayList<>();
        for(int i:arr){
            list.add(i);
        }
        JSorted02 j = new JSorted02();
        j.sort(list);
    }
    public void sort(List<Integer> a){
        Map<Integer,Integer> map = new HashMap<>();
        int size = a.size();
        for(Integer i : a){
            /*if(map.get(i)==null){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }*/
            map.merge(i,1,Integer::sum);
        }

        Num[] nums = new Num[size];
        int index = 0;
        for(Integer i : a){
            nums[index++] = new Num(i,map.get(i));
        }

        Arrays.sort(nums,(m1,m2)->{
            if(m1.count==m2.count){
                return m1.value - m2.value;
            }else{
                return m1.count - m2.count;
            }
        });

        for(Num n:nums){
            System.out.println(n.value);
        }


    }

}

class Num{
    int value;
    int count;
    public Num(int value,int count){
        this.value = value;
        this.count = count;
    }

}
