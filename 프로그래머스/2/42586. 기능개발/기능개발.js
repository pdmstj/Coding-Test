function solution(progresses, speeds) {
    let answer = [];
    let days = progresses.map((progress, index) => Math.ceil((100 - progress) / speeds[index])); // 각 작업의 남은 일수 계산
    let maxDay = days[0]; // 첫 번째 작업의 완료 시점
    let count = 0;

    for (let i = 0; i < days.length; i++) {
        if (days[i] <= maxDay) {
            // 현재 작업이 이전 작업 완료 시점 내에 완료 가능하면 함께 배포
            count++;
        } else {
            // 새로운 배포 그룹 시작
            answer.push(count); // 이전 배포 그룹 수 추가
            count = 1;          // 현재 작업을 새로운 배포 그룹으로 설정
            maxDay = days[i];   // 배포 기준일 갱신
        }
    }
    // 마지막 배포 그룹 추가
    answer.push(count);

    return answer;
}
