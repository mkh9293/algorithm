package hackerrank.joeunho.groom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class  Memo {

    String content;
    String date;
    public Memo(String content,String date){
        this.content=content;
        this.date=date;
    }
}


public class JCode_1 {
    public static void main(String[] args) throws ParseException {
        String input = "2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.\n"
        +"타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일\n"
        +"배민은행앞 별다방에서 18-06-12에 만나기로 함\n"+"END";

        HashMap<Integer,String> map1 = new HashMap<Integer,String>();
        HashMap<Integer,String> map2 = new HashMap<Integer,String>();

        String[] str = input.split("\n");
        Memo[] list = new Memo[str.length-1];
        int index = 0;
        for(String s : str){
            if(index<str.length-1) {
                if (s.contains("/")) {
                    System.out.println("=================1==============");
                    int start = s.indexOf("/");
                    int end = s.lastIndexOf("/");

                    System.out.println(s.substring(start - 4, end + 2));
                    String date = s.substring(start - 4, end + 2);

                    list[index] = new Memo(s,convert(date));
                }
                if (s.contains("-")) {
                    System.out.println("=================2==============");
                    int start = s.indexOf("-");
                    int end = s.lastIndexOf("-");

                    System.out.println(s.substring(start - 4, end + 2));
                    String date = s.substring(start - 4, end + 2);
                    convert(date);
                    list[index] = new Memo(s,convert(date));
                }
                if (s.contains("년") && s.contains("월") && s.contains("일")) {
                    System.out.println("===============3================");
                    System.out.println("s3 > " + s);
                    int start = s.indexOf("년");
                    int end = s.indexOf("일");
                    String date = s.substring(start - 4, end);
                    System.out.println("> >" + date);
                    convert(date);
                    list[index] = new Memo(s,convert(date));
                }
                index++;
            }
        }

        Arrays.sort(list, new Comparator<Memo>(){
            public int compare(Memo v1,Memo v2){
                return Integer.parseInt(v1.date) - Integer.parseInt(v2.date);
            }
        });

        for(Memo memo : list){
            System.out.println(memo.content);
        }



    }
    public static String convert(String date){
        System.out.println("conver **********************************: "+date);
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");//여기에 정규표현식을 적습니다.
        Matcher matcher = pattern.matcher(date);
        int count = 0;
        while(matcher.find()){
            if(count==0){
                if(matcher.group(0).length()==2){
                    sb.append("20"+matcher.group(0));
                }else{
                    sb.append(matcher.group(0));
                }
            }
            if(count==1){
                if(matcher.group(0).length()==1){
                    sb.append("0"+matcher.group(0));
                }else{
                    sb.append(matcher.group(0));
                }
            }
            if(count==2){
                if(matcher.group(0).length()==1){
                    sb.append("0"+matcher.group(0));
                }else{
                    sb.append(matcher.group(0));
                }
            }
            count++;
        }

        return sb.toString();
    }

}
