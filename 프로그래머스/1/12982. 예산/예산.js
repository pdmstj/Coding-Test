function solution(d, budget) {
    //오름차순으로 정렬
    d.sort((a, b) => a - b);
    
    let total = 0;
    let count = 0;

    for (let i = 0; i < d.length; i++) {
        total += d[i];

        if (total <= budget) {
            count++;
        } else {
            break;
        }
    }

    return count; 
}
