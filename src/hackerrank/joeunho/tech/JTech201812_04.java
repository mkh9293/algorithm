package hackerrank.joeunho.tech;

public class JTech201812_04 {
    public static void main(String[] args) {
        int num =4;

        System.out.println("result : "+solution(num));
    }
    public static int solution(int num){
        boolean check = true;
        int n=1;
        int compare = 0;
        while(check)
        {
            compare= (int)(n*(n+1)*0.5);
            if(num<compare){
                break;
            }
            n++;
        }
        n=n-1;
        compare= (int)(n*(n+1)*0.5);
        int result = (num-compare);
        if(result==0){
            return n;
        }
        return result;
    }

}
