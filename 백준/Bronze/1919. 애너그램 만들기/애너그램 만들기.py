from collections import Counter

word1 = input().strip()
word2 = input().strip()

# 각 단어의 문자 빈도 계산
freq1 = Counter(word1)
freq2 = Counter(word2)

# 빈도 차이 계산
total_removals = 0
all_chars = set(freq1.keys()).union(freq2.keys())

for char in all_chars:
    total_removals += abs(freq1[char] - freq2[char])

print(total_removals)
