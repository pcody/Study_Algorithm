## 4차 트라이
import sys

def dp(N, K, packsInfo):
    global res
    
    for j in range(K+1):
        for i in range(1, N+1):
            if j == 0:
                res[i][j] = 0
            else:
                if packsInfo[i][0] <= j:
                    res[i][j] = max(res[i-1][j-packsInfo[i][0]] + packsInfo[i][1], res[i-1][j])
                else:
                    res[i][j] = res[i-1][j]

N, K = map(int, sys.stdin.readline().split())
packsInfo = []
for i in range(N):
    packsInfo.append(list(map(int, sys.stdin.readline().split())))
packsInfo = [[0,0]] + packsInfo
res = [[0 for _ in range(K+1)] for _ in range(N+1)]
dp(N, K, packsInfo)
# print(res)
print(res[N][K])

# ## DP로 3차 트라이
# ## 가방수*가방수 의 배열을 채운다는 생각으로 만들었으나 실패
# import sys

# def dp(N, K, packsInfo):
#     global res

#     res[0][0][0] = packsInfo[0][0]
#     res[0][0][1] = packsInfo[0][1]

#     for j in range(1, N):
#         for i in range(N):
#             if i > j:
#                 res[j][i][0] = 0
#                 res[j][i][1] = 0
#             else:
#                 if packsInfo[j][0] + res[j-1][i][0] <= K:
#                     res[j][i][0] = packsInfo[j][0] + res[j-1][i][0]
#                     res[j][i][1] = packsInfo[j][1] + res[j-1][i][1] 
#                 else:
#                     res[j][i][0] = res[j-1][i][0]
#                     res[j][i][1] = res[j-1][i][1]

# N, K = map(int, sys.stdin.readline().split())
# packsInfo = []
# for i in range(N):
#     packsInfo.append(list(map(int, sys.stdin.readline().split())))
# res = [[[0,0] for _ in range(N)] for _ in range(N)]
# dp(N, K, packsInfo)
# answerList = sorted(res[N-1])
# answer = answerList[-1]
# print(res[N-1])
# print(answerList)
# print(answer[1])

# 4 4
# 2 10
# 2 100
# 2 10
# 2 100

# 4 5
# 2 100
# 3 50
# 2 100
# 3 50

# 4 4
# 2 100
# 3 50
# 2 100
# 3 50

# ## 2차 트라이 K를 어떻게 계산해야할지 모르겠어서 실패
# ## DP로 풀어보자
# import sys

# def dp(N, K, w, arr):
#     global answer, res
#     # 물건을 챙긴다1 안챙긴다0

#     # 0일때
#     res[0][1] = arr[0][1]
#     res[0][0] = 0

#     # 1부터
#     for i in range(1, N):
#         if w + arr[i][0] <= K:
#             w += arr[i][0]
#             res[i][1] = max(res[i-1][1] + arr[i][1], res[i-1][0] + arr[i][1])
#         else:
#             res[i][1] = max(res[i-1][1], res[i-1][0])
#         res[i][0] = max(res[i-1][1], res[i-1][0])
#     if res[i][1] > res[i][0]:
#         return w, res[i][1]
#     else:
#         return w, res[i][0]


# N, K = map(int, sys.stdin.readline().split())
# arr = []
# for i in range(N):
#     arr.append(list(map(int, sys.stdin.readline().split())))
# answer = 0
# res = [[0, 0] for _ in range(N)]
# dp(N, K, arr[0][0], arr)
# print(max(res[N-1][0], res[N-1][1]))




# ## 1차 try
# ## 재귀 시간초과..
# import sys

# def dfs(N, K, cur, w, pack):
#     global answer, temp

#     for i in range(cur, N):
#         # 무게합이 <= K 일 때 가치합을 구하고
#         if w + pack[i][0] <= K:
#             temp = temp + pack[i][1]
#             # 가치합이 최대이면 교체
#             if answer < temp:
#                 answer = temp
#             # 다음 재귀를 부르는데
#             # i+1부터 더해질 수 있도록
#             dfs(N, K, i + 1, w + pack[i][0], pack)
#             temp -= pack[i][1]

# N, K = map(int, sys.stdin.readline().split())
# pack = []
# for i in range(N):
#     pack.append(list(map(int, sys.stdin.readline().split())))

# pack.sort()

# answer = 0
# temp = 0
# # cur는 0부터 시작
# dfs(N, K, 0, 0, pack)
# print(answer)