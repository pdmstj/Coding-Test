from itertools import combinations

def solution(numbers):
    return list(sorted(set([sum(combs) for combs in combinations(numbers, 2)])))