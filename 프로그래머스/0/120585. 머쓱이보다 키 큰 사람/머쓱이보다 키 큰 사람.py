def solution(array, height):
    return sum(1 for i in array if i > height)
def solution(array, height):
    return len([i for i in array if i>height])