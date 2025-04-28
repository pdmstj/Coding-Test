const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = parseInt(input[0]);
const logs = input.slice(1);

let count = 0;
let users = new Set();

for (const log of logs) {
  if (log === 'ENTER') {
    users.clear(); 
  } else {
    if (!users.has(log)) {
      users.add(log);
      count++; 
    }
  }
}

console.log(count);
