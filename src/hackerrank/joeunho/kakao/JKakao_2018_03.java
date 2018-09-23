package hackerrank.joeunho.kakao;

import java.util.ArrayList;
import java.util.HashSet;

public class JKakao_2018_03 {
    public static void main(String[] args) {
        String[] str1 = {"100","ryan","music","2"};
        String[] str2 = {"200","apeach","math","2"};
        String[][] relation = {
         {"100","ryan","music","2"}
        ,{"200","apeach","math","2"}
        ,{"300","tube","computer","3"}
        ,{"400","con","computer","4"}
        ,{"500","muzi","music","3"}
        ,{"600","apeach","music","2"}
        };

        solution(relation);
        System.out.println("=======================================");
        //solution(str2);

    }
    public static void solution(String[][] relation){
        int r = relation.length;
        int c = relation[0].length;
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        int index = 0;
        while(index!=r){
            ArrayList<String> al = new ArrayList<String>();
            al.add("");//공집합
            for(int i=0; i<c; i++){
                al.addAll(new ArrayList<String>(al)); //복사
                for(int j=(int)Math.pow(2, i); j<(int)Math.pow(2, i+1); j++)
                    al.set(j, al.get(j)+" "+relation[index][i]);
            }
            list.add(al);
            index++;
        }

        int alSize = list.get(0).size();

        ArrayList<String> result = new ArrayList<String>();

        for(int j=0;j<alSize;j++){
            boolean flag = true;
            HashSet<String> set = new HashSet<String>();

            for(int i=0;i<r;i++){
                if (!set.contains(list.get(i).get(j))) {
                    set.add(list.get(i).get(j));
                }else{
                    flag = false;
                }
            }
            if(flag == true){
                result.add(list.get(0).get(j));
            }
        }
        /*System.out.println("======================= result ======================  "+result.size());
        int resultsize = result.size();
            for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }*/
        int resultsize = result.size();
        int count = 0;
        for(int i=0;i<result.size();i++){
            String temp = result.get(i);
            if(!temp.equals("")) {
                for (int j = i + 1; j < result.size(); j++) {
                    if (result.get(j).contains(temp)) {
                        result.remove(j);
                        result.add(j, "");
                        count++;
                    }
                }
            }
        }


        System.out.println("======================= result2 ======================  "+(resultsize-count));
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

        for(int i=0;i<result.size();i++){
            String temp = result.get(i);
            if(!"".equals(temp)){
                System.out.println(temp);
            }
        }


    }


}
