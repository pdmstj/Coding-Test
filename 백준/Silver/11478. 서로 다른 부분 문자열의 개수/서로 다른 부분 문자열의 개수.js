const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

const S = input;
const substrings = new Set();

for (let i = 0; i < S.length; i++) {
    for (let j = i + 1; j <= S.length; j++) {
        substrings.add(S.substring(i, j));
    }
}

console.log(substrings.size);