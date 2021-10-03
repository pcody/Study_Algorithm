import sys
sys.setrecursionlimit(10**8)

def setQueensOnBoard(N, board, queen):

    if len(queen) >= N:
        # print(queen)
        findCombination(N, board, queen)
        return

    for j in range(N):
        for i in range(N):
            if board[j][i] == 0:
                if queen != []:
                    x, y = queen[-1][0], queen[-1][1]
                    if j > y or (j == y and i > x):
                        board[j][i] = 1
                        queen.append([i, j])
                        setQueensOnBoard(N, board, queen)
                        board[j][i] = 0
                        queen.pop()
                else:
                    board[j][i] = 1
                    queen.append([i, j])
                    setQueensOnBoard(N, board, queen)
                    board[j][i] = 0
                    queen.pop()

def findCombination(N, board, queen):
    global answer

    vecxy = [[0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
    flag = 0
    
    for x, y in queen:
        if flag == 1:
            break

        for _ in range(8):
            if flag == 1:
                break

            dx, dy = vecxy[_][0], vecxy[_][1]
            nx, ny = x + dx, y + dy
            while 0 <= nx < N and 0 <= ny < N:
                if flag == 1:
                    break

                if board[ny][nx] == 1:
                    flag = 1
                nx, ny = nx + dx, ny + dy

    if flag == 0:
        answer += 1

N = int(sys.stdin.readline().rstrip())
board = [[0] * N for _ in range(N)]
answer = 0
setQueensOnBoard(N, board, [])
print(answer)