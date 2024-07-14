function solution(s) {
    let result = "";
    let index = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] === " ") {
            result += " ";
            index = 0;
        } else {
            result += index % 2 === 0 ? s[i].toUpperCase() : s[i].toLowerCase();
            index++;
        }
    }

    return result;
}