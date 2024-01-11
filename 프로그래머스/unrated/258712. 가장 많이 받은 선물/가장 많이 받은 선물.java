import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        /*
            결과 : 이번달의 선물 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측 
            조건 : 1. 한친구가 다른 친구에게 더 많은 선물을 준 경우
                  2. 서로 주고받은 선물의 수가 같거나 없는 경우는 선물지수가 높은 사람이 선물을 받음
            A (3)-> , A (10)<-  = -7
        */
        
        int answer = 0;
        Map<String, Integer> indexMap = new HashMap<>();
        int giftState[][] = new int[friends.length][friends.length];
        
   
        // STEP1. 친구 인덱스 저장
        for(int i = 0; i < friends.length; i++){
            indexMap.put(friends[i],i);
        }
        
        // STEP2. 주고 받은 현황 저장
        for(String friend : gifts){
            StringTokenizer stk = new StringTokenizer(friend);
            giftState[indexMap.get(stk.nextToken())][indexMap.get(stk.nextToken())]++;
        }
        
        // STEP3. 선물 지수 계산 및 다음달 선물을 가장 많이받을 친구의 선물 수 
         for (int i = 0; i < friends.length; i++) {
            int giftCount = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    int giftScoreA = 0;
                    int giftScoreB = 0;
                    for (int k = 0; k < friends.length; k++) {
                        giftScoreA += giftState[i][k] - giftState[k][i];
                        giftScoreB += giftState[j][k] - giftState[k][j];
                    }
                    // 조건 1,2 충족시 다음 달 선물 +
                    if (giftState[i][j] > giftState[j][i] || 
                        (giftState[i][j] == giftState[j][i] && giftScoreA > giftScoreB)) {
                        giftCount++;
                    }
                }
            }
             
             // 최대 선물일경우 변경
             if(answer < giftCount){
                 answer = giftCount;
             }
        }
        return answer;
    }
}
