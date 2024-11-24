function solution(clothes) {
    let clothesMap = new Map();

    // 1. 의상의 종류별 개수 카운팅
    for (let [item, type] of clothes) {
        clothesMap.set(type, (clothesMap.get(type) || 0) + 1);
    }

    // 2. 모든 조합의 경우의 수 계산
    let combinations = 1;
    for (let count of clothesMap.values()) {
        combinations *= (count + 1); // 해당 종류의 의상을 입지 않는 경우 포함
    }

    // 3. 아무것도 입지 않는 경우(1) 제외
    return combinations - 1;
}
