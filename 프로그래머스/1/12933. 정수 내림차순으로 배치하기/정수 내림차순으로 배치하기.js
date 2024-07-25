n = 1240789

function solution(n) {
    var answer = [];
    var count = String(n) // 숫자를 문자로 변환 
    var sum = ''
    for(let i=0; i<count.length; i++){
      answer.push(count[i])
      answer.sort((a,b)=>b-a) // 내림차순
    }
      return Number(answer.join(""))
    
}

solution(n)