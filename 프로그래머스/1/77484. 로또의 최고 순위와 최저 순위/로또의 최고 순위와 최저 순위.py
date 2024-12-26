def solution(lottos, win_nums):
    
    matched_count = sum(1 for num in lottos if num in win_nums)
    zero_count = lottos.count(0)
    
    max_matched = matched_count + zero_count
    
    min_matched = matched_count
    
    def get_rank(count):
        if count == 6:
            return 1
        elif count == 5:
            return 2
        elif count == 4:
            return 3
        elif count == 3:
            return 4
        elif count == 2:
            return 5
        else:
            return 6
    
    return [get_rank(max_matched), get_rank(min_matched)]
