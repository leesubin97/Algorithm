class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        /*
            t 초 동안 붕대를 감고, 1초마다 x 만큼의 체력 회복, t초 연속으로 붕대감기 성공시 y 체력 회복
            현재 체력이 최대 체력보다 커지는것 불가능
            몬스터 공격시 기술취소 성공시간 0
            0 이하 사망
            결과: 모든 공격 후 최종 체력 출력. 단, 캐릭터의 체력이 0 이하시 -1 출력
            조건: 공격/회복 ,
                  시간이니 1부터 시작, 공격을 언제 했는지 확인 필요
        */
        
        // STEP1. 필요 데이터 정의
        int techTime = bandage[0]; // 붕대 감는 시간
        int recovery = bandage[1]; // 초당 회복량
        int addRecovery = bandage[2]; // 추가 회복량
        int currentTime = 1; // 현재 시간 (1초부터 시작)
        int attackIndex = 0; // 다음 공격의 인덱스
        int continuousTime = 0; // 연속으로 붕대를 감은 시간
        int maxHealth = health; // 최대 체력

        // STEP2. 공격 시 붕대 기술 사용 계산
        // 마지막 공격 시간 
        int lastAttackTime = attacks[attacks.length - 1][0];

        while (currentTime <= lastAttackTime) {
            if (attackIndex < attacks.length && attacks[attackIndex][0] == currentTime) {
                // 공격 - 체력 감소 및 연속 시간 초기화
                health -= attacks[attackIndex][1];
                attackIndex++;
                continuousTime = 0;
            } else {
                // 회복 - 붕대감기
                health += recovery;
                continuousTime++;
                if (continuousTime >= techTime) {
                    // 연속 시간이 기술 시전 시간에 도달하면 추가 회복
                    health += addRecovery;
                    continuousTime = 0; // 추가 회복 후 연속 시간 초기화
                }
            }

            // 최대 체력을 초과하지 않게 조정
            health = Math.min(health, maxHealth);
            currentTime++;
            
            // 체력이 0 이하로 떨어지면 죽음
            if (health <= 0) {
                return -1;
            }
        }

        return health;
    }
}
