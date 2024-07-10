function solution(t, p) {
    let count= 0;
    const pLength=p.length;
    const pValue=parseInt(p);
    for(let i=0; i<=t.length - pLength; i++){
        const subStr = t.substring(i, i+pLength);
        const subValue = parseInt(subStr);
        if(subValue <= pValue) count++;
    }
    return count;
}