from itertools import combinations

def solution(relation):
    n = len(relation[0])
    cands = []
    for i in range(1, n+1):
        for comb in combinations(range(n), i):
            if any(set(comb) > set(c) for c in cands): continue
            if len({tuple(r[i] for i in comb) for r in relation}) == len(relation):
                cands.append(comb)
    return len(cands)