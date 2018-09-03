package hackerrank.joeunho.kakao;

public class KGame_2017_02 {
    public static void main(String[] args) {
        String dartResult="1T2D3D#";
        System.out.println(solution(dartResult));
    }
    public static int solution(String dartResult) {
        int[] arr = new int[3];
        int answer = 0;
        int count = 0 ;
        for(int i=0;i<dartResult.length();i++){
            String checkValue1 = dartResult.substring(i,i+1);
            if(isStringDouble(checkValue1)==true){
                    if(count<3){
                        arr[count] = i;
                        count++;
                    }
            }
        }
        String[] game = new String[3];
        game[0] = dartResult.substring(arr[0],arr[1]);
        game[1] = dartResult.substring(arr[1],arr[2]);
        game[2] = dartResult.substring(arr[2],dartResult.length());
        int[] result = new int[3];
        for(int i=0;i<game.length;i++){
            double value = 0;
                if(isStringDouble(game[i].substring(0,1))==true && isStringDouble(game[i].substring(1,2))==true){

                    value=Math.pow(10,powCheck(game[i].substring(2,3)));
                    if(game[i].length()==4){
                        if("*".equals(game[i].substring(3,4))){//스타상
                            if(i==0){
                                result[i]=(int)value*2;
                            }else{
                                result[i-1]=result[i-1]*2;
                                result[i]=(int)value*2;
                            }
                        }else{//아차상
                            result[i]=(int)value*(-1);
                        }
                    }else{
                        result[i]=(int)value;
                    }

                }else{
                    value=Math.pow(Integer.parseInt(game[i].substring(0,1)),powCheck(game[i].substring(1,2)));
                    if(game[i].length()==3){
                        if("*".equals(game[i].substring(2,3))){//스타상
                            if(i==0){
                                result[i]=(int)value*2;
                            }else{
                                result[i-1]=result[i-1]*2;
                                result[i]=(int)value*2;
                            }
                        }else{//아차상
                            result[i]=(int)value*(-1);
                        }
                    }else{
                        result[i]=(int)value;
                    }
                }
        }
        for(int i:result){
            answer = answer+i;
        }
        return answer;
    }
    // 숫자여부 체크
    public static boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double powCheck(String a){
        if("S".equals(a)){
            return 1;
        }else if("D".equals(a)){
            return 2;
        }else{
            return 3;
        }
    }


}

