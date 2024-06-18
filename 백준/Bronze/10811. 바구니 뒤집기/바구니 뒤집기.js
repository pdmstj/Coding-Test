const fs = require("fs");

const [MnN, ...exes] = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const [n, m] = MnN.split(" ").map((e) => +e);
const baskets = new Array(n).fill(0).map((v, i) => i + 1);
let result = "";

const execute = (str) => {
  const [i, j] = str.split(" ").map((e) => +e);
  const tempBaskets = [...baskets];

  for (let x = 0; x <= j - i; x++) {
    baskets[j - x - 1] = tempBaskets[i + x - 1];
  }
};

exes.forEach(execute);
baskets.forEach((e) => (result += `${e} `));
console.log(result);