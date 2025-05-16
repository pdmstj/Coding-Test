function solution(a, b, c, d) {
    const dice = [a, b, c, d];
    const count = {};

    for (let num of dice) {
        count[num] = (count[num] || 0) + 1;
    }

    const entries = Object.entries(count).map(([k, v]) => [Number(k), v]);
    
    if (entries.length === 1) {
        return 1111 * entries[0][0];
    } else if (entries.length === 2) {
        const [num1, cnt1] = entries[0];
        const [num2, cnt2] = entries[1];
        if (cnt1 === 3 || cnt2 === 3) {
            const p = cnt1 === 3 ? num1 : num2;
            const q = cnt1 === 1 ? num1 : num2;
            return (10 * p + q) ** 2;
        } else {
            return (num1 + num2) * Math.abs(num1 - num2);
        }
    } else if (entries.length === 3) {
        let p, q, r;
        for (let [num, cnt] of entries) {
            if (cnt === 2) p = num;
            else if (q === undefined) q = num;
            else r = num;
        }
        return q * r;
    } else {
        return Math.min(...dice);
    }
}