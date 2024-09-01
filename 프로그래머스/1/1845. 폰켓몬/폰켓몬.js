function solution(nums) {
var answer = 0;
let pickup = nums.length / 2
const table = new Map()
nums.forEach(num => {
    if(table.get(num)){
    table.set(num, table.get(num) + 1)
    }else{
    table.set(num, 1)
    }
    })

    if(table.size < pickup) {
    answer = table.size
    }else{
    answer = pickup
    }
    return answer;
}