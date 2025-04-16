function solution(myString) {
    const parts = myString.split('x');
    return parts.map(part => part.length);
}
