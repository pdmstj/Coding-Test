def solution(arr, delete_list):
    # delete_list에 없는 원소들만 남긴 배열을 반환
    return [item for item in arr if item not in delete_list]
