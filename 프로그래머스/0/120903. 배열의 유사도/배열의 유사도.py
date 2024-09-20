def solution(s1, s2):
    return len(set(s1) & set(s2))

s1 = ["a", "b", "c"]
s2 = ["com", "b", "d", "p", "c"]
print(solution(s1, s2)) 

s1 = ["n", "omg"]
s2 = ["m", "dot"]
print(solution(s1, s2))
