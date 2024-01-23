/*
    주식 가격이 떨어질때 시간을 계산
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                
                // 주식 가격이 하락할때 , 앞의 수보다 뒤의 수가 작을때
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                // 다음 수의 인덱스가 마지막 인덱스와 같을때
                if (j == answer.length - 1) {
                    answer[i] = j-i;
                }
            }
        }
        return answer;
    }
}