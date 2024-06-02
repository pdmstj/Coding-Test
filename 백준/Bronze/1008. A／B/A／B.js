const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');

let a = parseFloat(input[0]);
let b = parseFloat(input[1]);

let result = a / b;

console.log(result.toFixed(10));