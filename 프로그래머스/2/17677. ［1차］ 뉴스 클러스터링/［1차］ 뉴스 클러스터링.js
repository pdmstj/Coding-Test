function solution(str1, str2) {
    
    const makeMultiset = (str) => {
        const multiset = [];
        const lowerStr = str.toLowerCase(); 
        for (let i = 0; i < lowerStr.length - 1; i++) {
            const pair = lowerStr.substring(i, i + 2);
            if (/^[a-z]{2}$/.test(pair)) { 
                multiset.push(pair);
            }
        }
        return multiset;
    };

    const set1 = makeMultiset(str1);
    const set2 = makeMultiset(str2);

    const map1 = {};
    const map2 = {};
    
    set1.forEach((item) => map1[item] = (map1[item] || 0) + 1);
    set2.forEach((item) => map2[item] = (map2[item] || 0) + 1);

    let intersectionSize = 0;
    let unionSize = 0;

    const allKeys = new Set([...Object.keys(map1), ...Object.keys(map2)]);
    allKeys.forEach((key) => {
        const count1 = map1[key] || 0;
        const count2 = map2[key] || 0;
        intersectionSize += Math.min(count1, count2);
        unionSize += Math.max(count1, count2);
    });

    const jaccard = unionSize === 0 ? 1 : intersectionSize / unionSize;

    return Math.floor(jaccard * 65536);
}

console.log(solution("FRANCE", "french"));      
console.log(solution("handshake", "shake hands")); 
console.log(solution("aa1+aa2", "AAAA12"));       
console.log(solution("E=M*C^2", "e=m*c^2"));       
