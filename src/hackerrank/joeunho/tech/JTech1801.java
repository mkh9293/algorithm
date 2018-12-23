package hackerrank.joeunho.tech;

import java.util.*;

public class JTech1801 {
    public static void main(String[] args) {
        //int[] A = {2,2,1};
        int[] A = {3,2,1,2};

        solution(A);
    }
    public static void solution(int[] A){
        Map<Integer,Integer> map = new HashMap<>();
        List<Student> list = new ArrayList<>();
        for(int i : A){
            list.add(new Student(i));
        }
        Collections.sort(list);

        int count = -1;
        int rank = 0;
        int pre = 0 ;
        for(Student s: list){
            System.out.println(s.grade);
            if(count==-1){
                rank = 1;
                count = 1;
            }else{
                if(pre!=s.grade){
                    rank += count;
                    count = 1;
                }else{
                    rank = map.get(pre);
                    count++;
                }
            }
            pre = s.grade;
            map.put(s.grade,rank);
        }

        for(int i : A){
            System.out.print(map.get(i)+" ");
        }




    }
}

class Student implements Comparable<Student>{
     int grade;

    public Student(int grade) {
        this.grade = grade;
    }
    @Override
    public int compareTo(Student o) {
        if (this.grade > o.grade) {
            return -1;
        } else if (this.grade < o.grade) {
            return 1;
        } else {
            return 0;
        }
    }


}

