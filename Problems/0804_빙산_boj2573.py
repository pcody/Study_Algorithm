import sys
from collections import deque

def bfs(N, M, arr):
    vecx, vecy = [-1, 0, 1, 0], [0, 1, 0, -1]
    
    # 0이 된 빙산이 있는지 확인할 변수
    flag = 0
    # 중간에 녹여서 0을 만들면 BFS를 돌면서 체크되므로 감소시킬 것들은 리스트에 담는다
    zArr = []

    # 바다(0)에 접한 빙산의 좌표와 녹는 수치를 저장한다
    for j in range(N):
        for i in range(M):
            if arr[j][i] > 0:
                zNum = 0
                for k in range(4):
                    ni, nj = i + vecx[k], j + vecy[k]
                    if 0 <= ni < M and 0 <= nj < N:
                        if arr[nj][ni] == 0:
                            zNum += 1
                zArr.append((i, j, zNum))
    
    # 빙산을 녹인다
    for i, j, zNum in zArr:
        # 0 아래로는 떨어지지 않는 한줄 코드
        arr[j][i] = max(0, arr[j][i] - zNum)
        # 다 녹아서 사라졌으면 flag 1로 만들어줌
        if arr[j][i] == 0:
            flag = 1
    
    # flag리턴
    return flag

def chkIce(N, M, arr):
    vecx, vecy = [-1, 0, 1, 0], [0, 1, 0, -1]

    # 빙산의 개수를 저장할 변수
    num = 0
    q = deque()
    visited = [[0 for _ in range(M)] for _ in range(N)]
    for j in range(N):
        for i in range(M):
            # 빙산이 존재하고 방문을 안 했으면 if문 실행
            if arr[j][i] > 0 and not visited[j][i]:
                # q에 넣고 방문처리 및 num 증가시킴
                q.append((i, j))
                num += 1
                visited[j][i] = num

                # arr[j][i]와 연결된 모든 빙산은 방문처리됨
                while q:
                    curi, curj = q.popleft()

                    for k in range(4):
                        ni, nj = curi + vecx[k], curj + vecy[k]
                        if 0 <= ni < M and 0 <= nj < N:
                            if arr[nj][ni] > 0 and not visited[nj][ni]:
                                q.append((ni, nj))
                                visited[nj][ni] = num
    return num

N, M = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
num = chkIce(N, M, arr)
if num > 1:
    print(0)
else:
    year = 0
    while True:
        # 1년째 부터 센다
        year += 1
        
        # bfs돌고
        flag = bfs(N, M, arr)
        # 다 녹은 빙산이 있으면 빙산 개수 센다
        if flag:
            num = chkIce(N, M, arr)
        
        # 빙산 개수가 1개 이상이면 year 출력하고 루프 break
        if num > 1:
            print(year)
            break

        # 빙산 개수가 순서대로 녹아서 0이면 0 출력하고 루프 break
        if num == 0:
            print(0)
            break