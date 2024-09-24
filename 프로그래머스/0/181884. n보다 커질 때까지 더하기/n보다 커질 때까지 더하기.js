function solution(numbers, n) {
  var answer = 0;
  for (let item of numbers) {
    answer += item;
    if (answer > n) break;
  }
  return answer;
}