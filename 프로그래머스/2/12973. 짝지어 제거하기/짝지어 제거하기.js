function solution(s) {
    let st = [];

    for (let letter of s) {
        if (st.length === 0) {
            st.push(letter);
        } else {
            if (st[st.length - 1] === letter) {
                st.pop();
            } else {
                st.push(letter);
            }
        }
    }

    return st.length === 0 ? 1 : 0;
}