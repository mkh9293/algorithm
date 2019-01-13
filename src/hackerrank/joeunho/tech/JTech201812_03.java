package hackerrank.joeunho.tech;

public class JTech201812_03 {
    public static void main(String[] args) {
        String s1 ="hellopython";
        String key ="abcdefghijk";
        int location = 3;
        System.out.println(solution(s1,key,location));
    }
    public static String solution(String s1,String key,int location){
        char[] ch1 = s1.toCharArray();
        char[] keyCh2 = key.toCharArray();
        int len = ch1.length;
        char[] temp = new char[len];

        for(int i=0;i<len;i++) {
            int num = (int)ch1[i]-96 + (int)keyCh2[i]-96;
            num = num%26;
            num = num+96;
            temp[i] = (char)num;
        }
        return location(temp,location);
    }
    public static String location(char[] temp,int location){
        int size = temp.length;
        char[] result = new char[size];//left
        StringBuilder sb = new StringBuilder();

        if(location<0){
            location = location*(-1);
            for(int i=0;i<size;i++){
                int index = i-(location%size);
                if(index<0){
                    index+=size;
                }
                result[index] = temp[i];
            }
            for(char s : result){
                sb.append(s);
            }
            return sb.toString();
        }
        //right logic
        for(int i=0;i<size;i++){
            int index = (i+location)%size;
            result[index] = temp[i];
        }
        for(char s : result){
            sb.append(s);
        }
        return sb.toString();
    }
}
