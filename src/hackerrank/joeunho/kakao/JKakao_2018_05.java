package hackerrank.joeunho.kakao;


import java.util.Arrays;
import java.util.Comparator;

class Location{
    int x;
    int y;
    int order;
    public Location(int x,int y,int order){
        this.x=x;
        this.y=y;
        this.order=order;

    }
}

class Node{
    int order;
    int data;
    Node left;
    Node right;
}


public class JKakao_2018_05 {
    public static void main(String[] args) {
        int[][] answer = {};
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int size1 = nodeinfo.length;
        Location[] location = new Location[size1];
        int size2 = nodeinfo[0].length;

        for(int i=0;i<size1;i++){
            location[i] =  new Location(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }

        Arrays.sort(location, new Comparator<Location>(){
            public int compare(Location v1,Location v2){
                if(v1.y==v2.y){
                    return v1.x-v2.x;
                }

                return v2.y - v1.y;
            }
        });

        Node root =  new Node();
        root.data = location[0].x;
        root.order = location[0].order;
        for(int i=1;i<location.length;i++){
            insertNode(root,location[i]);
        }

        StringBuilder arr1 = new StringBuilder();
        preOrder(root,arr1);
        String[] str1 = arr1.toString().split(" ");
        answer = new int[2][str1.length];
        for(int a=0;a<str1.length;a++){
            answer[0][a]=Integer.parseInt(str1[a]);
        }

        StringBuilder arr2= new StringBuilder();
        postOrder(root,arr2);
        String[] str2 = arr2.toString().split(" ");
        for(int a=0;a<str2.length;a++){
            answer[1][a]=Integer.parseInt(str2[a]);
        }

        System.out.println("===============================");
        for(int a=0;a<str1.length;a++){
            System.out.println(answer[0][a]+"/");

        }
        System.out.println("===============================");
        for(int a=0;a<str1.length;a++){
            System.out.println(answer[1][a]+"/");

        }






    }
    public static void insertNode(Node root,Location location){
        Node next = new Node();
        next.data = location.x;
        next.order = location.order;
        if(root.data > location.x){
            if(root.left==null){
                root.left=next;
            }else{
                root=root.left;
                insertNode(root,location);
            }
        }else{
            if(root.right==null){
                root.right=next;
            }else{
                root=root.right;
                insertNode(root,location);
            }
        }
    }

    public static void preOrder(Node root,StringBuilder arr){
        if(root == null){
            return ;
        }else{
            arr.append(root.order+" ");
            preOrder(root.left,arr);
            preOrder(root.right,arr);
        }

    }

    public static void postOrder(Node root,StringBuilder arr){
        if(root == null){
            return ;
        }else{
            postOrder(root.left,arr);
            postOrder(root.right,arr);
            arr.append(root.order+" ");
        }
    }


}
