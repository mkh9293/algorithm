package hackerrank.joeunho.kakao;

import java.util.HashMap;

public class JKakao_2018_01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }

    public static String[] solution(String[] record) {

        HashMap<String,String> map = new HashMap<String,String>();
        //Queue<String> que = new Queue<String>();
        String[] answer = {};

        int count=0;
        String[] temp = null;
        for(String s : record){
            temp = s.split(" ");
            if("Enter".equals(temp[0])){
                map.put(temp[1], temp[2]);
                count++;
            }else if("Leave".equals(temp[0])){
                count++;
            }else{
                map.put(temp[1], temp[2]);
            }
            temp = null;
        }
        System.out.println(">> "+map.toString());
        answer = new String[count];
        int index=0;

        String[] temp2 = null;
        String in = "님이 들어왔습니다.";
        String out = "님이 나갔습니다.";
        for(String s : record){
            temp2 = s.split(" ");
            if("Enter".equals(temp2[0])){
                answer[index]=map.get(temp2[1])+in;
                index++;
            }else if("Leave".equals(temp2[0])){
                answer[index]=map.get(temp2[1])+out;
                index++;
            }

            temp2 = null;
        }

        return answer;
    }
}
