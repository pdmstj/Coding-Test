#include <stdio.h>
#include <string.h>

int solution(const char* my_string, const char* is_suffix) {
    int my_len = strlen(my_string);    // my_string의 길이
    int suffix_len = strlen(is_suffix); // is_suffix의 길이
    
    // is_suffix가 my_string보다 길면 접미사가 될 수 없다
    if (suffix_len > my_len) {
        return 0;
    }

    // my_string의 끝부분이 is_suffix와 일치하는지 확인
    if (strcmp(my_string + my_len - suffix_len, is_suffix) == 0) {
        return 1;  // 접미사가 맞으면 1 반환
    } else {
        return 0;  // 접미사가 아니면 0 반환
    }
}

int main() {
    printf("%d\n", solution("banana", "ana"));     // 1
    printf("%d\n", solution("banana", "nan"));     // 0
    printf("%d\n", solution("banana", "wxyz"));    // 0
    printf("%d\n", solution("banana", "abanana")); // 0
    return 0;
}
