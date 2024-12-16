def solution(keymap, targets):
    
    key_count = {}
    for idx, keys in enumerate(keymap):
        for pos, char in enumerate(keys):
            if char in key_count:
                key_count[char] = min(key_count[char], pos + 1)  
            else:
                key_count[char] = pos + 1
    
    answer = []
    for target in targets:
        total = 0
        for char in target:
            if char in key_count:
                total += key_count[char]
            else:
                total = -1
                break
        answer.append(total)
    
    return answer
