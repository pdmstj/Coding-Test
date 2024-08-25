function solution(k, score) {
    let result = [],king=[] //result:정답배열, king:명예의 전당에 올라간 점수 배열

    score.forEach((v,i)=>{

    king.sort((a,b)=>b-a)

     if(i<k)king.push(v)
     else{
      if(Math.min(...king)<v){
       king.pop()
       king.push(v)
       }
      }
     result.push(Math.min(...king))
  })
    
    return result
}