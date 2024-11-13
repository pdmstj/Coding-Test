def solution(num_list):
    # 마지막 원소와 그 전 원소를 비교하여 조건에 맞는 값을 추가
    if num_list[-1] > num_list[-2]:
        num_list.append(num_list[-1] - num_list[-2])
    else:
        num_list.append(num_list[-1] * 2)
    
    return num_list
