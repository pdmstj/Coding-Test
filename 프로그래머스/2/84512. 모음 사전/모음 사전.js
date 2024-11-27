function solution(word) {
    // 사전순서 알파벳
    const vowels = ['A', 'E', 'I', 'O', 'U'];
    // 각 자리수별 가중치 계산
    const weights = [781, 156, 31, 6, 1]; // 5^4 + 5^3 + ... 순으로 미리 계산

    let answer = 0;
    for (let i = 0; i < word.length; i++) {
        const idx = vowels.indexOf(word[i]); // 현재 글자의 사전 위치
        answer += idx * weights[i] + 1; // 가중치에 따른 위치 계산
    }

    return answer;
}
