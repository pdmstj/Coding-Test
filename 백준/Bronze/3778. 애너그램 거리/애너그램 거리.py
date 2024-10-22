def anagram_distance(word1, word2):
    from collections import Counter
    
    # 각 단어의 문자 빈도를 세기
    count1 = Counter(word1)
    count2 = Counter(word2)
    
    # 필요한 삭제 횟수를 계산하기 위한 변수
    total_distance = 0
    
    # 두 단어의 모든 고유 문자를 모음
    all_chars = set(count1.keys()).union(set(count2.keys()))
    
    # 각 문자의 빈도 차이를 계산
    for char in all_chars:
        total_distance += abs(count1.get(char, 0) - count2.get(char, 0))
    
    return total_distance

def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    
    N = int(data[0])  # 테스트 케이스의 개수
    results = []
    
    index = 1
    for i in range(1, N + 1):
        word1 = data[index].strip()  # 첫 번째 단어
        word2 = data[index + 1].strip()  # 두 번째 단어
        index += 2
        
        # 애너그램 거리 계산
        distance = anagram_distance(word1, word2)
        # 결과 형식에 맞춰 추가
        results.append(f"Case #{i}: {distance}")
    
    # 모든 결과 출력
    print("\n".join(results))

if __name__ == "__main__":
    main()
