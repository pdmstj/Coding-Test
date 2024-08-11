def solution(s, n):
    s_word = list(map(ord, list(s)))
    aL_dict = {i-ord('a'):chr(i) for i in range(ord('a'), ord('z')+1)}
    aU_dict = {i-ord('A'):chr(i) for i in range(ord('A'), ord('Z')+1)}
    ans =[]
    
    for i in s_word:
        if chr(i).islower():
            order = (i-ord('a')+n) % 26
            ans.append(aL_dict[order])
        elif chr(i).isupper():
            order = (i-ord('A')+n) % 26
            ans.append(aU_dict[order])
        else: #공백
            ans.append(' ')
    # print(ans)
    answer = ''.join(ans)
    return answer