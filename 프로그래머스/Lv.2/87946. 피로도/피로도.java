import java.util.*;
/*
    유저가 탐험할 수 있는 최대 던전 수 출력
*/
class Solution {
    public int solution(int k, int[][] dungeons) {
        // 던전 경험 상태 저장하도록함
        boolean[] experDungeonsState = new boolean[dungeons.length];
        return experDangeons(k, dungeons, experDungeonsState);
    }

    private int experDangeons(int k, int[][] dungeons, boolean[] visited){
        // 탐험 가능 최대 던전 수
        int maxExperDangeons = 0;
        
        // 모든 던전 탐색
        for(int i = 0 ; i < dungeons.length; i++){
            // 현재 피로도 기준으로 던전 경험을 안한 경우 탐색
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                maxExperDangeons = Math.max(maxExperDangeons, 1 + experDangeons(k-dungeons[i][1], dungeons, visited));
                visited[i] = false;
            }
        }
        return maxExperDangeons;
    }
}
