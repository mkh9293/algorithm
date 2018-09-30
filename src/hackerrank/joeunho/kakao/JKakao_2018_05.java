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


public class JKakao_2018_05 {
    public static void main(String[] args) {
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

        for(int i=0;i<size1;i++){
            System.out.println(">> "+location[i].order+" // x: "+location[i].x+" // y: "+location[i].y);
            System.out.println("================================");
        }


    }
}
