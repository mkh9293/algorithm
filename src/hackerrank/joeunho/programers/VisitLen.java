package hackerrank.joeunho.programers;

public class VisitLen {
    public static void main(String[] args) {
        //String s ="LULLLLLLU";
        String s ="LULLLLLLU";
        solution(s);
    }
    public static void solution(String s){
        int l = 5;
        int r = 5;
        int u = 5;
        int d = 5;

        int x = 11;
        int y = 11;
        int curX=5;
        int curY=5;
        int[][] space = new int[x][y];

        char[] ch = s.toCharArray();
        space[5][5] = 1;
        for(int i=0;i<x;i++){

            for (int j=0;j<y;j++){
                System.out.print(space[i][j]+" ");
            }
            System.out.println();

        }

        boolean flag = false;
        int index = 0;
        for(char c:ch){
            if(c=='U'){
                if(curY>0){
                    curY--;
                }
            }
            if(c=='D'){
                if(curY<11){
                    curY++;
                }

            }
            if(c=='L'){
                if(curX>0){
                    curX--;
                }
            }
            if(c=='R'){
                if(curX<11){
                    curX++;
                }
            }

            index++;
            if(space[curY][curX]==2 && index==ch.length){
                flag = true;
            }
            space[curY][curX]=2;

        }

        System.out.println();
        System.out.println();

        for(int i=0;i<x;i++){

            for (int j=0;j<y;j++){
                System.out.print(space[i][j]+" ");
            }
            System.out.println();

        }

        int count= 0;
        for(int i=0;i<x;i++){

            for (int j=0;j<y;j++){
                if(space[i][j]==2){
                    count++;
                }
            }

        }

        if(flag){
            count++;
        }
        System.out.println("result : "+count);

    }
}
