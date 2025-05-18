function solution(intStrs, k, s, l) {
    const answer = [];
    for (let str of intStrs) {
        const num = parseInt(str.substr(s, l)); 
        if (num > k) {
            answer.push(num);
        }
    }
    return answer;
}