import sys

def setQueens(N, board, queens, row):
    global answer
    if len(queens) >= N:
        # print(queens)
        answer += 1
        return

    for j in range(row, N):
        for i in range(N):
            if board[j][i] == 0:
                if queens == []:
                    board[j][i] = 1
                    queens.append([i, j])
                    setQueens(N, board, queens, row + 1)
                    queens.pop()
                    board[j][i] = 0
                else:
                    flag = 0
                    for qx, qy in queens:
                        if qy == j or qx == i or (abs(qx - i) == abs(qy - j)):
                            flag = 1
                            break
                    
                    if flag == 0:
                        board[j][i] = 1
                        queens.append([i, j])
                        setQueens(N, board, queens, row + 1)
                        queens.pop()
                        board[j][i] = 0                

N = int(sys.stdin.readline().rstrip())
board = [[0] * N for _ in range(N)]
answer = 0
setQueens(N, board, [], 0)
print(answer)