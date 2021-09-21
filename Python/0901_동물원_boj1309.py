import sys
divisor = 9901

def dp(N, res):
    
    res[1] = [1, 1, 1]
    for j in range(2, N + 1):
        res[j][0] = sum(res[j - 1]) % divisor
        res[j][1] = res[j - 1][0] + res[j - 1][2] % divisor
        res[j][2] = res[j - 1][0] + res[j - 1][1] % divisor
    
    return sum(res[N]) % divisor

# 메모리 초과
# 4byte * 3 * (100001) = 1200012
# 숫자가 너무 커지므로 divisor로 나눠주는 코드를 넣어야 함
N = int(sys.stdin.readline().rstrip())
res = [[0, 0, 0] for _ in range(N + 1)]
print(dp(N, res))

# 칸\경우 빈 우리, 1열에 배열, 2열에 배열
# 1
# 2
# 3
# 4
# ...
# N
# res[N][0] 사자 X = sum(res[N-1])
# res[N][1] 사자 1열 = res[N-1][0] + res[N-1][2]
# res[N][2] 사자 2열 = res[N-1][0] + res[N-1][1]

# 00
# 10

# 01
# 10

# 00 10 00 10 01
# 01 01 00 00 00
# 10 10 10 10 10
