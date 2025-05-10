function solution(arr, queries) {
    let answer = [];

    for (let i = 0; i < queries.length; i++) {
        let [s, e, k] = queries[i];
        let min = Infinity;

        for (let j = s; j <= e; j++) {
            if (arr[j] > k && arr[j] < min) {
                min = arr[j];
            }
        }

        answer.push(min === Infinity ? -1 : min);
    }

    return answer;
}