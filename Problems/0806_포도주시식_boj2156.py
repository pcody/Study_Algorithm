import sys

# 점화식을 만드는게 어려웠다.
# max(i-2까지 먹는 최대값에 i를 먹는 경우, i-3까지 먹는 최대값에 i-1, i를 먹는 경우)를 생각했었으나
# i-2까지 안먹는 값에 i를 먹는 경우, i-3을 안 먹고 i-1, i를 먹는 경우도 있으니
# res[i-2][1] + w[i] --> max(res[i-2]) + w[i], res[i-3][1] + w[i-1] + w[i] --> max(res[i-3]) + w[i-1] + w[i]
# 처럼 계산하여야 한다..
# 지난 3월에 한 번 풀었던 문제인데 복습하여 5개월만에 겨우 이해 하고 넘어가는 기념으로 깃에 올려둔다.

def dp(n, w):
    global res

    res[1][0] = 0
    res[1][1] = w[1]
    if n == 1:
        return max(res[1])

    res[2][0] = max(res[1])
    res[2][1] = max(res[1]) + w[2]

    for i in range(3, n + 1):
        res[i][0] = max(res[i-1])
        res[i][1] = max(max(res[i-2]) + w[i], max(res[i-3]) + w[i-1] + w[i])

    return max(res[n])

    
n = int(sys.stdin.readline().rstrip())
w = [0]
for _ in range(n):
    w.append(int(sys.stdin.readline().rstrip()))

res = [[0 for _ in range(2)] for _ in range(n+1)]


# n번째를 먹을때와 안먹을때 중 큰 것이 답
# Bottom Up 방식
print(dp(n, w))

# n번째 포도주를 마실건지 안 마실건지
# 점화식 세우기
# f(n), eat:1 마신다, 0 안 마신다
# n = 1 -- f(1) = max(0, wine[1])
# n = 2 -- f(2) = max(res[1][0]+w[2], res[1][1]+w[2], res[1][1])
# n = 3 -- f(3) = f(1)+
# n = k -- f(k) = max(res[j][1], res[j][0])
#         res[j][0] = res[j-1][1], res[j][1] = max(res[j-2][1]+w[j], res[j-3][1]+w[j-1]+w[j])




# Top Down방식 --> 다시 풀어봐야 한다... 메모리초과
# answer = max(dp(n, 1, w), dp(n, 0, w))
# print(answer)

# sys.setrecursionlimit(10**6)
# def dp(n, eat, w):
#     global res

#     if n <= 0:
#         return 0
    
#     # dp(n, eat, w)은 n번째를 eat=1 먹는경우, eat=0 안먹는경우 최대값을 리턴함
#     if eat:
#         if res[n][1] == 0:
#             # res[j][1] = max(res[j-2][1]+w[j], res[j-3][1]+w[j-1]+w[j])
#             # n번째를 먹는 경우 최대값은 n-2를 먹고 n을 먹는 경우, n-3을 먹고 n-1, n을 먹는 경우 중 최대값
#             res[n][1] = max(dp(n-2, 1, w) + w[n], dp(n-3, 1, w) + w[n-1] + w[n])
#         return res[n][1]
#     else:
#         if res[n][0] == 0:
#             # res[n][0] = res[n-1][1], n번째를 안먹는 경우 최대값은 n-1번째를 먹는 경우
#             res[n][0] = dp(n-1, 1, w)
#         return res[n][0]