def solution(hp):
    general = hp // 5 
    remainder = hp % 5    
    soldier = remainder // 3 
    worker = remainder % 3 
    
    return general + soldier + worker
