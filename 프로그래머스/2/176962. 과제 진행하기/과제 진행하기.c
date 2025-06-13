#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char name[11];
    int start;
    int playtime;
} Task;

typedef struct {
    char name[11];
    int remain;
} StackTask;

int convertTime(const char* timeStr) {
    int h = (timeStr[0] - '0') * 10 + (timeStr[1] - '0');
    int m = (timeStr[3] - '0') * 10 + (timeStr[4] - '0');
    return h * 60 + m;
}

int compare(const void* a, const void* b) {
    Task* t1 = (Task*)a;
    Task* t2 = (Task*)b;
    return t1->start - t2->start;
}

char** solution(const char*** plans, size_t plans_rows, size_t plans_cols) {
    Task* tasks = (Task*)malloc(sizeof(Task) * plans_rows);
    for (int i = 0; i < plans_rows; i++) {
        strcpy(tasks[i].name, plans[i][0]);
        tasks[i].start = convertTime(plans[i][1]);
        tasks[i].playtime = atoi(plans[i][2]);
    }

    qsort(tasks, plans_rows, sizeof(Task), compare);

    StackTask* stack = (StackTask*)malloc(sizeof(StackTask) * plans_rows);
    int top = -1;

    char** answer = (char**)malloc(sizeof(char*) * plans_rows);
    int answerIndex = 0;

    int currentTime = tasks[0].start;

    for (int i = 0; i < plans_rows; i++) {
        int taskStart = tasks[i].start;
        int taskTime = tasks[i].playtime;
        int taskEnd = taskStart + taskTime;

        if (i + 1 < plans_rows) {
            int nextStart = tasks[i + 1].start;

            if (taskEnd <= nextStart) {
                answer[answerIndex++] = strdup(tasks[i].name);
                currentTime = taskEnd;

                while (top >= 0) {
                    StackTask topTask = stack[top];
                    if (currentTime + topTask.remain <= nextStart) {
                        currentTime += topTask.remain;
                        answer[answerIndex++] = strdup(topTask.name);
                        top--;
                    } else {
                        stack[top].remain = topTask.remain - (nextStart - currentTime);
                        break;
                    }
                }

                currentTime = nextStart; 
            } else {
                StackTask paused;
                strcpy(paused.name, tasks[i].name);
                paused.remain = taskEnd - nextStart;
                stack[++top] = paused;
                currentTime = nextStart;
            }
        } else {
            answer[answerIndex++] = strdup(tasks[i].name);
            currentTime = taskEnd;
        }
    }

    while (top >= 0) {
        answer[answerIndex++] = strdup(stack[top--].name);
    }

    free(tasks);
    free(stack);
    return answer;
}
