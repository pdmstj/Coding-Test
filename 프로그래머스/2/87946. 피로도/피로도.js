function solution(k, dungeons) {
    let maxCount = 0;
    
    // 순열 생성 함수
    function getPermutations(arr, n) {
        if (n === 1) return arr.map(v => [v]);
        return arr.flatMap((v, i) => 
            getPermutations([...arr.slice(0, i), ...arr.slice(i + 1)], n - 1).map(p => [v, ...p])
        );
    }

    // 모든 순열 생성
    const permutations = getPermutations(dungeons, dungeons.length);
    
    // 각 순열에 대해 탐험 가능한 던전 수 계산
    for (const perm of permutations) {
        let fatigue = k; // 현재 피로도
        let count = 0; // 탐험한 던전 수
        
        for (const [minRequired, consume] of perm) {
            if (fatigue >= minRequired) {
                fatigue -= consume;
                count++;
            } else {
                break;
            }
        }
        
        maxCount = Math.max(maxCount, count);
    }
    
    return maxCount;
}
