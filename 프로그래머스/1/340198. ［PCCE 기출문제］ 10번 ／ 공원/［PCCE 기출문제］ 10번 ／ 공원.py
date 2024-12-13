def solution(mats, park):
    mats.sort(reverse=True)
    rows = len(park)
    cols = len(park[0])
    
    def can_place(size):
        for i in range(rows - size + 1):
            for j in range(cols - size + 1):
                valid = True
                for x in range(size):
                    for y in range(size):
                        if park[i + x][j + y] != "-1":
                            valid = False
                            break
                    if not valid:
                        break
                if valid:
                    return True
        return False

    for size in mats:
        if can_place(size):
            return size
    
    return -1
