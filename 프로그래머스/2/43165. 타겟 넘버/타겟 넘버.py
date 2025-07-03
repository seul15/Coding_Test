from itertools import product
def solution(numbers, target):
    l = [(x,-x) for x in numbers]
    return list(map(sum,product(*l))).count(target)