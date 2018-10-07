package hackerrank.joeunho.zig;

public class JTest_3 {
    public static void main(String[] args) {
            //String content = "ab2v9bc13j5jf4jv";

            String content = "10";


            String[] temp = content.replaceAll("[^0-9]"," ").split(" ");
            int sum = 0;
            for(String s : temp){
                System.out.println(s+"/");
                if(!s.equals("") && (Integer.parseInt(s)%2==1)){
                    sum+=Math.pow(Double.parseDouble(s),2);
                }
            }

            System.out.println("sum : "+sum);
    }
}
