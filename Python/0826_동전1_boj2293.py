import sys

# def dp(n, k, coin):
#     global res

#     coin.sort()

#     for j in range(k):
#         for i in range(n):
#             if coin[i] > j + 1:
#                 if i - 1 >= 0:
#                     res[i][j] = res[i - 1][j]
#                 else:
#                     res[i][j] = 0
#             else:
#                 if j - coin[i] <= 0:
#                     res[i][j] = 1 + res[i - 1][j]
#                 else:
#                     if i - 1 >= 0:
#                         res[i][j] = res[i][j - coin[i]] + res[i - 1][j]
#                     else:
#                         res[i][j] = res[i][j - coin[i]]

#     return res[n - 1][k - 1]
# 메모리 : res + coin = n*k + n = 4*(100*10000 + 100) = 4*1000100 = 40000400 Bytes = 3.8MB
# 3.8 + @ 인데 메모리초과?
# 1차원 배열로 풀어야 한다

def dp(n, k, coin):
    res = [0] * (k + 1)
    res[0] = 1
    for i in range(n):
        for j in range(coin[i], k + 1):
            res[j] += res[j - coin[i]]

    return res[k]

n, k = map(int, sys.stdin.readline().split())
coin = []
for _ in range(n):
    coin.append(int(sys.stdin.readline().rstrip()))
# res = [[0] * k for _ in range(n)]
print(dp(n, k, coin))


# 동전\가치 1 2 3 4 5 6 7 8 9 10
# 1        1 2 3 4 5 6 7 8 9 10
# 2
# 5
# res[i][k]: 가치 k에서 i동전까지 사용할 때 동전합 경우의 수
# k 0 1 2 3 4 5 6 7 8 9 10
# 0 0 0 0 0 0 0 0 0 0 0 0
# 1 1 1 1 1 1 1 1 1 1 1 1
# 2 1 1 2 2 3 3 4 4 5 5 6
# 5 1 1 2 2 3 4 5 6 7 8 10

# res[i][k] res[i-1][k] (c[i] < k)
#           res[i][k-c[i]] + res[i-1][k] (c[i] >= k)

# 111
# 12

# 1111
# 22
# 121

# 5
# 11111
# 221
# 2111

# 51
# 111111
# 222
# 2211
# 21111

# 511
# 52
# 1111111
# 2221
# 22111
# 211111

# 5111
# 521
# 11111111
# 2222
# 22211
# 221111
# 2111111

# 51111
# 5211
# 522
# 111111111
# 22221
# 222111
# 2211111
# 21111111

# 55
# 511111
# 52111
# 5221
# 1111111111
# 22222
# 222211
# 2221111
# 22111111
# 211111111