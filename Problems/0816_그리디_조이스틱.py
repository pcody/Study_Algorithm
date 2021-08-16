def solution(name):
    answer = 0
    name = list(name)
    chk = name.count('A')
    n = len(name)
    cur = 0
    
    while chk < n:
        if name[cur] != 'A':
            answer += min(ord(name[cur]) - ord('A'), ord('Z') - ord(name[cur]) + 1)
            name[cur] = 'A'
            chk += 1
        nCur, offset = nextCur(name, cur)
        cur= nCur
        answer += offset

    return answer

def nextCur(name, cur):
    n = len(name)

    rCur = cur
    r = 0
    while True:
        rCur += 1
        r += 1
        rCur %= n
        if r >= n:
            return 0, 0
        if name[rCur] != 'A':
            break

    lCur = cur
    l = 0
    while True:
        lCur -= 1
        l += 1
        if lCur < 0:
            lCur = n - 1
        if l >= n:
            return 0, 0
        if name[lCur] != 'A':
            break

    if l < r:
        return lCur, l
    else:
        return rCur, r

# 실패
# def solution(name):
#     answer = 0
#     N = len(name)

#     bef = 0
#     for cur in range(N):
#         if name[cur] == 'A':
#             pass
#         else:
#             if cur != 0:
#                 if cur - bef <= bef + N - cur:
#                     answer += cur - bef
#                 else:
#                     answer += bef + N - cur
#             bef = cur
#             temp = ord(name[cur])-ord('A')
#             if temp <= 12:
#                 answer += temp
#             else:
#                 answer += 26-temp

#     return answer

print(solution("JEROEN"), 56)
print(solution("JAN"), 23)
    

