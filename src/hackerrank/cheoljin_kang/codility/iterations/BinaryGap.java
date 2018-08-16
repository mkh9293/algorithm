package hackerrank.cheoljin_kang.codility.iterations;

/*
    Problem source : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {
    public static void main(String[] args) {
        int n1 = 9; // result : 2
        int n2 = 529; // result : 4
        int n3 = 20; // result : 1
        int n4 = 15; // result : 0
        System.out.println("result : " + solution(n1));
        System.out.println("result : " + solution(n2));
        System.out.println("result : " + solution(n3));
        System.out.println("result : " + solution(n4));
    }

    static int solution(int N) {
        int result = 0;
        if (N != 0) {
            String binaryNum = Integer.toBinaryString(N);
            String[] arrayNum = binaryNum.split("");
            int maxValue = 0;
            int zeroCount = 0;
            int index = 0;
            boolean firstOne = false;
            boolean lastOne = false;
            while (index <= binaryNum.length() - 1) {
                if (arrayNum[index].equals("0")) {
                    if(firstOne == true && lastOne == false) {
                        zeroCount++;
                    } else if(firstOne == true && lastOne == true) {
                        lastOne = false;
                        zeroCount++;
                    }
                    index ++;
                } else {
                    if(firstOne == false && lastOne == false) {
                        firstOne = true;
                    } else if(firstOne == true && lastOne == false) {
                        lastOne = true;
                        if(maxValue < zeroCount) {
                            maxValue = zeroCount;
                        }
                        zeroCount = 0;
                    }
                    index++;
                }
            }
            result = maxValue;
        }
        return result;
    }
}
