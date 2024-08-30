function solution(cards1, cards2, goal) {
    let answer = 'Yes'
    
    goal.forEach((card) => {
        if(cards1[0] === card) cards1.shift();
        else if(cards2[0] === card) cards2.shift();
        else if(cards1[0] !== card && cards2[0] !== card){
            answer = 'No';
            return;
        }
    })
    
    return answer;
}