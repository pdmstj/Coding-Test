function solution(money) {
    let answer = [];
    answer[0] = Math.floor(money / 5500); // 5500으로 나눈 몫
    answer[1] = money % 5500;             // 5500으로 나눈 나머지
    return answer;
}