#include <stdio.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
int* solution(int arr[], size_t arr_len) {
    // 반환할 배열을 동적 할당 (arr_len 크기만큼)
    int* answer = (int*)malloc(arr_len * sizeof(int));

    // 배열의 각 요소에 대해 조건에 맞는 연산 수행
    for (size_t i = 0; i < arr_len; i++) {
        if (arr[i] >= 50 && arr[i] % 2 == 0) {
            answer[i] = arr[i] / 2;  // 50 이상 짝수인 경우 2로 나눔
        } else if (arr[i] < 50 && arr[i] % 2 != 0) {
            answer[i] = arr[i] * 2;  // 50 미만 홀수인 경우 2를 곱함
        } else {
            answer[i] = arr[i];  // 조건에 맞지 않는 경우 그대로 유지
        }
    }

    return answer;  // 결과 배열 반환
}

int main() {
    int arr[] = {1, 2, 3, 100, 99, 98};
    size_t arr_len = sizeof(arr) / sizeof(arr[0]);

    // solution 함수 호출
    int* result = solution(arr, arr_len);

    // 결과 출력
    for (size_t i = 0; i < arr_len; i++) {
        printf("%d ", result[i]);
    }

    // 동적 메모리 해제
    free(result);

    return 0;
}
