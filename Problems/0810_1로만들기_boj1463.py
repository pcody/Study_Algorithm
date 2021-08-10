import sys
sys.setrecursionlimit(10**6)

# TOP DOWN 메모리초과
# def dp(N, res):
#     if N <= 1:
#         if res[1] == sys.maxsize:
#             res[1] = 0
#         return res[1]
#     elif N == 2:
#         if res[2] == sys.maxsize:
#             res[2] = 1
#         return res[2]
#     elif N == 3:
#         if res[3] == sys.maxsize:
#             res[3] = 1
#         return res[3]
#     else:
#         if res[N] == sys.maxsize:
#             a, b, c = N + 1, N + 1, N + 1
#             if N % 3 == 0:
#                 if res[N // 3] == sys.maxsize:
#                     a = dp(N // 3, res)
#                 else:
#                     a = res[N // 3]
#             if N % 2 == 0:
#                 if res[N // 2] == sys.maxsize:
#                     b = dp(N // 2, res)
#                 else:
#                     b = res[N // 2]
#             if res[N - 1] == sys.maxsize:
#                 c = dp(N - 1, res)
#             else:
#                 c = res[N - 1]
#             res[N] = min(a, b, c) + 1
        
#         return res[N]

# BOTTOM UP
def dp(N, res):
    res[1] = 0
    if N == 1:
        # 리턴 처리 안 해주면 런타임(인덱스) 에러 발생한다
        return res[1]
    res[2] = 1
    if N == 2:
        # 리턴 처리 안 해주면 런타임(인덱스) 에러 발생한다
        return res[2]

    res[3] = 1

    for i in range(4, N + 1):
        a, b, c = N + 1, N + 1, N + 1
        if i % 3 == 0:
            a = res[i // 3] + 1
        if i % 2 == 0:
            b = res[i // 2] + 1
        c = res[i - 1] + 1

        res[i] = min(a, b, c)
    
    return res[N]

N = int(sys.stdin.readline().rstrip())
res = [sys.maxsize] * (N + 1)
print(dp(N, res))

# 10 -> /2 -> 5
#       -1 -> 9

# 9 -> /3 -> 3
#      -1 -> 8

# 8 -> /2 -> 4
#   -> -1 -> 7

# 7 -> -1 -> 6

# 6 -> /3 -> 2
#      /2 -> 3
#      -1 -> 5

# 5 -> -1 -> 4

# 4 -> /2 -> 2
#      -1 -> 3

# 3 -> /3 -> 1
#   -> -1 -> 2

# 2 -> /2 -> 1
#   -> -1 -> 1