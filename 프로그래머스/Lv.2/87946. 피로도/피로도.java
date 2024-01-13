import java.util.*;
/*
    유저가 탐험할 수 있는 최대 던전 수 출력
    결과 : 유저가 던전을 돌면서 피로도가 소모되는데 그 상태에서 더이상 탐험 가능한지 확인
*/
class Solution {
    public int solution(int k, int[][] dungeons) {
        // 던전 경험 상태 저장하도록함
        boolean[] experDungeonsState = new boolean[dungeons.length];
        return experDangeons(k, dungeons, experDungeonsState);
    }
    
    private int experDangeons(int k, int[][] dungeons, boolean[] visited){
        int maxExperDangeons = 0;
        for(int i = 0 ; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                maxExperDangeons = Math.max(maxExperDangeons, 1 + experDangeons(k-dungeons[i][1], dungeons, visited));
                visited[i] = false;
            }
        }
        return maxExperDangeons;
    }
}