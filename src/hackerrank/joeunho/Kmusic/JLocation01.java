package hackerrank.joeunho.Kmusic;

public class JLocation01 {
    public static void main(String[] args) {
        String a = "abcd";

        System.out.println(solution(a,1,2));
    }
    public static String solution(String a,int left,int right){
        char[] ch = a.toCharArray();
        int size = ch.length;
        char[] temp1 = new char[size];//left
        char[] temp2 = new char[size];//right

        //left logic
        for(int i=0;i<size;i++){
            int index = i-(left%size);
            if(index<0){
                index+=size;
            }
            temp1[index] = ch[i];
        }

        //right logic
        for(int i=0;i<size;i++){
            int index = (i+right)%size;
            temp2[index] = temp1[i];
        }

        StringBuilder sb = new StringBuilder();
        for(char s : temp2){
            sb.append(s);
        }
        return sb.toString();
    }
}
