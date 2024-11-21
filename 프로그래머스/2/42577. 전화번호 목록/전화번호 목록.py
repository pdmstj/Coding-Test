def solution(phone_book):
    # 전화번호 목록을 정렬
    phone_book.sort()
    
    # 정렬된 전화번호 리스트에서 인접한 두 번호를 비교
    for i in range(len(phone_book) - 1):
        # 현재 번호가 다음 번호의 접두어인지 확인
        if phone_book[i+1].startswith(phone_book[i]):
            return False  # 접두어 관계가 있으면 False 반환
    
    # 접두어 관계가 없으면 True 반환
    return True
