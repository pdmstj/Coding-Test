def count_pairs_with_sum(nums, x):
    num_set = set()
    count = 0

    for num in nums:
        if x - num in num_set:
            count += 1
        num_set.add(num)

    return count

n = int(input())
nums = list(map(int, input().split()))
x = int(input())

print(count_pairs_with_sum(nums, x))
