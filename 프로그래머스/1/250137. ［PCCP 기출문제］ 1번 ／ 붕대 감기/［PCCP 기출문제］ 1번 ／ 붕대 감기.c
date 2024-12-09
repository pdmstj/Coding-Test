#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// bandage_len은 배열 bandage의 길이입니다.
// attacks_rows는 2차원 배열 attacks의 행 길이, attacks_cols는 2차원 배열 attacks의 열 길이입니다.
int solution(int bandage[], size_t bandage_len, int health, int** attacks, size_t attacks_rows, size_t attacks_cols) {
    // 붕대 감기 기술 정보
    int t = bandage[0];  // 시전 시간
    int x = bandage[1];  // 초당 회복량
    int y = bandage[2];  // 추가 회복량

    // 현재 체력, 연속 성공 시간, 공격 인덱스
    int current_health = health;
    int success_time = 0;
    int attack_index = 0;

    // 시간 시뮬레이션 (최대 공격 시간까지 반복)
    for (int time = 1; time <= 1000; time++) {
        // 몬스터 공격 처리
        if (attack_index < attacks_rows && attacks[attack_index][0] == time) {
            // 몬스터의 공격 시간에 피해량 감소
            current_health -= attacks[attack_index][1];
            // 연속 성공 초기화
            success_time = 0;
            // 공격 처리 완료
            attack_index++;
        } else {
            // 붕대 감기 효과 적용
            success_time++;
            if (success_time <= t) {
                current_health += x; // 초당 회복량
                if (current_health > health) {
                    current_health = health; // 최대 체력 초과 방지
                }
            }
            if (success_time == t) {
                // 연속 성공 시간 도달 시 추가 회복량 적용
                current_health += y;
                if (current_health > health) {
                    current_health = health; // 최대 체력 초과 방지
                }
                success_time = 0; // 성공 시간 초기화
            }
        }

        // 캐릭터 사망 체크
        if (current_health <= 0) {
            return -1; // 캐릭터 사망
        }

        // 공격이 모두 끝난 경우 시뮬레이션 종료
        if (attack_index >= attacks_rows && success_time == 0) {
            break;
        }
    }

    return current_health; // 남은 체력 반환
}
