function solution(citations) {
    // 1. 내림차순 정렬
    citations.sort((a, b) => b - a);
    
    // 2. H-Index 계산
    let hIndex = 0;
    for (let i = 0; i < citations.length; i++) {
        // i+1은 현재 논문의 순서, citations[i]는 인용 횟수
        if (citations[i] >= i + 1) {
            hIndex = i + 1; // h값 갱신
        } else {
            break; // 더 이상 조건을 만족하지 않으면 종료
        }
    }
    
    return hIndex;
}
