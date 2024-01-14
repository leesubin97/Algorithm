import java.util.*;
/*
    number.length() - k 자리 수만큼 구해야함
    자리수 n이면 n-1 만큼 빼고 앞에서 부터 최대값 계산
    그다음 index  기준으로 남은 자리수만큼 빼놓고 최대값 계산
*/
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder numberBuilder = new StringBuilder();
        char[] arr = number.toCharArray();
        
        // number 에서 k 개의 수 제거 시 만들 수 있는 가장 큰 문자열 자리수
        int answerLength = arr.length - k;
        // 자리수 인덱스 정의
        int index = 0;
        
        // 만들어야하는 자리수 만큼 돌면서 index기준으로 최대값 계산
        for(int i = 0; i < answerLength; i++){
            char max = '0';
            for(int j = index; j <= i + k; j++){
                if(arr[j] > max){
                    max = arr[j];
                    index = j+1;
                    //System.out.println(max);
                }
            }
            numberBuilder.append(Character.toString(max));
        }
        
        answer = numberBuilder.toString();
        return answer;
    }
}