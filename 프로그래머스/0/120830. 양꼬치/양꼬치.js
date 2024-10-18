function solution(n, k) {
    // 양꼬치 비용
    const lambCost = n * 12000;
    
    // 음료수 비용에서 서비스로 받은 음료수 개수만큼 빼기
    const drinkCost = (k - Math.floor(n / 10)) * 2000;
    
    // 총 비용 계산
    return lambCost + drinkCost;
}
