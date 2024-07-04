#include <stdlib.h>
#include <string.h>

char* solution(const char* phone_number) {
    char* answer = (char*)malloc(strlen(phone_number) * sizeof(char));
    for (int i = 0; i < strlen(phone_number)-4; i++) { answer[i] = '*'; }
    for (int i = strlen(phone_number)-4; i <= strlen(phone_number); i++) { answer[i] = phone_number[i]; }
    return answer;
}