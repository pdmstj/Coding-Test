test = int(input())
cnt = 0
for tc in range(test):
    word = list(map(ord, input()))
    checker = []
    for spell in word:
        if spell not in checker or checker[-1] == spell:
            checker.append(spell)
        else:
            checker = []
            break
    if len(checker) != 0:
        cnt += 1
print(cnt)