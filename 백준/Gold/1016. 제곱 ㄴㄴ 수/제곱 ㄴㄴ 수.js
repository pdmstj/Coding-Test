const fs = require("fs");
const [min, max] = fs.readFileSync("/dev/stdin", "utf8").trim().split(" ").map(Number);

const isNotSquareFree = Array(max - min + 1).fill(false);
let count = 0;

for (let i = 2; i * i <= max; i++) {
  let start = Math.ceil(min / (i * i));

  while (start * i * i <= max) {
    isNotSquareFree[start * i * i - min] = true;
    start++;
  }
}

for (let i = 0; i <= max - min; i++) {
  if (!isNotSquareFree[i]) count++;
}

console.log(count);