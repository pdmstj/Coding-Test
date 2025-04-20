function solution(schedules, timelogs, startday) {
    let answer = 0;

    const n = schedules.length;

    for (let i = 0; i < n; i++) {
        let ok = true;

        for (let j = 0; j < 7; j++) {
            const day = (startday + j - 1) % 7 + 1;

            if (day === 6 || day === 7) continue;

            const desired = schedules[i];
            const actual = timelogs[i][j];

            let hour = Math.floor(desired / 100);
            let minute = desired % 100 + 10;

            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }

            const allowed = hour * 100 + minute;
            if (actual > allowed) {
                ok = false;
                break;
            }
        }
        if (ok) answer++;
    }
    return answer;
}