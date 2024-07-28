function solution(n) {
    let r = [];
    for (let i = 1; i<= n; i++){
        if(n % i == 0) r.push(i);
    }
    return r.reduce((a,b) => a+b, 0);
}