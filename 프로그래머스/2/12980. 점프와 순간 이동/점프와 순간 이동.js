function solution(n) {
    let answer = 0;
    let sumDistance = 0;
    let distance = 1;

    while (sumDistance !== n) {
        if (sumDistance + distance * 2 > n) {
            sumDistance += distance;
            answer++;
            distance = 1;
        } else {
            distance *= 2;
        }
    }

    return answer;
}