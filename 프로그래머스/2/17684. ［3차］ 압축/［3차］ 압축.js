function solution(msg) {
    // 1. 사전 초기화
    let dictionary = {};
    for (let i = 1; i <= 26; i++) {
        dictionary[String.fromCharCode(64 + i)] = i; // A=1, B=2, ..., Z=26
    }
    
    let nextIndex = 27; // 새롭게 추가될 단어의 색인 번호
    let answer = [];
    let w = ""; // 현재 입력(w)

    // 2. 입력 문자열을 순회하며 처리
    for (let i = 0; i < msg.length; i++) {
        let c = msg[i]; // 다음 글자(c)
        if (dictionary[w + c]) {
            // 사전에 w + c가 있으면 w를 확장
            w = w + c;
        } else {
            // 사전에 w + c가 없으면 현재 w의 색인 번호를 출력
            answer.push(dictionary[w]);
            // 사전에 w + c를 등록
            dictionary[w + c] = nextIndex++;
            // w를 c로 초기화
            w = c;
        }
    }

    // 마지막으로 남은 w에 대해 색인 번호를 출력
    if (w) {
        answer.push(dictionary[w]);
    }

    return answer;
}
