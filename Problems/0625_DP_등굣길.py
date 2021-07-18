def solution(m, n, puddles):
    answer = 0
    divisor = 1000000007

    grid = [[0] * (m+1) for _ in range(n+1)]

    for x, y in puddles:
        grid[y][x] = -1

    for j in range(1, n+1):
        for i in range(1, m+1):
            if j == 1 and i == 1:
                grid[j][i] = 1
            elif j == 1 and i > 1:
                if grid[j][i] != -1:
                    grid[j][i] += grid[j][i-1] if grid[j][i-1] > 0 else 0 % divisor
            elif i == 1:
                if grid[j][i] != -1:
                    grid[j][i] += grid[j-1][i] if grid[j-1][i] > 0 else 0 % divisor
            else:
                if grid[j][i] != -1:
                    a = grid[j][i-1] if grid[j][i-1] > 0 else 0
                    b = grid[j-1][i] if grid[j-1][i] > 0 else 0
                    grid[j][i] += (a + b) % divisor
    
    answer = grid[n][m] % divisor
    return answer

print(solution(4, 3, [[2, 2]]), 4)
print(solution(4, 3, [[2, 1], [1, 2]]), 0)