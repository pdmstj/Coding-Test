def count_pages():
    while True:
        # 문서의 총 페이지 수 입력
        N = int(input())
        if N == 0:
            break

        # 인쇄 범위 입력
        ranges = input().split(',')

        # 유효한 페이지를 담을 집합
        valid_pages = set()

        for r in ranges:
            if '-' in r:
                # 범위 처리 (low-high)
                low, high = map(int, r.split('-'))
                if low <= high:
                    valid_pages.update(range(max(1, low), min(N + 1, high + 1)))
            else:
                # 단일 페이지 처리
                page = int(r)
                if 1 <= page <= N:
                    valid_pages.add(page)

        # 유효한 페이지 수 출력
        print(len(valid_pages))

# 실행
count_pages()
