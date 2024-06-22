const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
if (input.length === 1 && input[0] === "") {
  result = 0;
} else {
  result = input.length;
}

console.log(result);