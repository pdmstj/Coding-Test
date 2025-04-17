const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];
rl.on("line", function (line) {
    input.push(line);
    if (input.length === 2) {
        rl.close();
    }
}).on("close", function () {
    const [a, b] = input[0].split(" ").map(Number); 
    const [c, d] = input[1].split(" ").map(Number); 

    const numerator = a * d + b * c;
    const denominator = b * d;

    const gcd = (x, y) => y === 0 ? x : gcd(y, x % y);
    const common = gcd(numerator, denominator);

    const reducedNumerator = numerator / common;
    const reducedDenominator = denominator / common;

    console.log(`${reducedNumerator} ${reducedDenominator}`);
});
