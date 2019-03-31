package hackerrank.joeunho.N;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TableA {
    String id;
    String name;
    String occ;
    public TableA(String id,String name,String occ){
        this.id = id;
        this.name = name;
        this.occ = occ;
    }

}

class TableB {
    String id;
    String city;
    String zip;
    public TableB(String id,String city,String zip){
        this.id = id;
        this.city = city;
        this.zip = zip;
    }
}

class TableAB implements Comparable<TableAB>{
    String id;
    String name;
    String occ;
    String city;
    String zip;

    public TableAB(String id,String name,String occ,String city,String zip){
        this.name = name;
        this.occ = occ;
        this.id = id;
        this.city = city;
        this.zip = zip;
    }

    @Override
    public int compareTo(TableAB p) {
        return id.compareTo(p.id);
    }
}

public class Sqlpractice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num1 = sc.nextInt();
//        int num2 = sc.nextInt();

        int num1 = 4;
        int num2 = 5;
        TableA[] a = new TableA[num1];
        a[0] = new TableA("1","aa1","bb1");
        a[1] = new TableA("4","aa4","bb4");
        a[2] = new TableA("3","aa3","bb3");
        a[3] = new TableA("2","aa2","bb2");


        TableB[] b = new TableB[num2];
        b[0] = new TableB("5","aaa5","bbb5");
        b[1] = new TableB("2","aaa2","bbb2");
        b[2] = new TableB("3","aaa3","bbb3");
        b[3] = new TableB("6","aaa6","bbb6");
        b[4] = new TableB("4","aaa4","bbb4");

        TableAB ab = null;

        ArrayList<TableAB> list = new ArrayList<>();

        for(int i=0;i<a.length;i++){
            ab = new TableAB(a[i].id,a[i].name,a[i].occ,"null","null");
            list.add(ab);

        }

        for(int j=0;j<b.length;j++){
            for(int i=0;i<list.size();i++){
                if(list.get(i).id == b[j].id){
                    list.get(i).city = b[j].city;
                    list.get(i).zip = b[j].zip;
                }
            }
        }
        Collections.sort(list);

        for(TableAB t : list){
            System.out.println(t.id + " / "+t.name + " / "+t.occ + " / "+t.city + " / "+t.zip+ " / ");
        }




    }
}
