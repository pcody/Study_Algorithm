import sys
from collections import deque

# 상좌하우
vecxy = [[0,-1],[-1,0],[1,0],[0,1]]

# 최단거리 내 잡아먹을 수 있는 물고기의 위치를 큐에 담는다
def findFishes(N, arr, pos, fishes):
    global vecxy
    visited = [[0] * N for _ in range(N)]
    q = deque()

    # 처음 상어의 위치를 큐에 넣고 방문처리
    px, py, lv, _ = pos
    q.append([px, py, 0])
    visited[py][px] = 1

    while q:
        x, y, distance = q.popleft()

        for vecx, vecy in vecxy:
            nx, ny = x + vecx, y + vecy
            # 맵 안에 있어야 하고 방문 안 한 지점에서 물고기 탐색
            if 0 <= nx < N and 0 <= ny < N and not visited[ny][nx]:
                # 상어보다 작은 크기만 큐에 담는다
                if arr[ny][nx] < lv:
                    q.append([nx, ny, distance + 1])
                    visited[ny][nx] = 1
                    
                    # 0은 물고기가 아니므로 0보다 큰 것만
                    # 이동하는데 걸린 거리도 fishes에 넣어줌
                    if arr[ny][nx] > 0:
                        # fishes에 마지막 원소의 거리보다 많아지면 삽입하지않고 탈출
                        # 동일 거리 물고기들만 계산하고 탈출하는 것
                        if fishes and fishes[-1][2] < distance + 1:
                            q.clear()
                            break
                        fishes.append([nx, ny, distance + 1])

                elif arr[ny][nx] == lv:
                    q.append([nx, ny, distance + 1])
                    visited[ny][nx] = 1

def solution(N, arr, start):
    global vecxy
    # 총 걸린 시간
    totalTime = 0
    # 상어 정보
    sx, sy, lv, eat = start

    fishes = deque()
    # 거리를 구할 때 상어의 좌표
    findFishes(N, arr, start, fishes)
    if not fishes:
        return totalTime
    else:
        while fishes:
            # 큐에서 pop한 위치의 물고기를 잡아먹는다고 가정
            fx, fy, distance = fishes.popleft()
            # 먹은 수
            eat += 1
            # 이동거리만큼 시간 추가
            totalTime += distance
            # 상어 위치 이동
            arr[sy][sx] = 0
            sx, sy = fx, fy
            arr[sy][sx] = 9
            if eat >= lv:
                eat = 0
                lv += 1
                # 상어의 크기가 증가한 경우
                # 잡아먹을 수 있는 물고기 큐를 클리어하고 다시 구함
                fishes.clear()
                findFishes(N, arr, [sx, sy, lv, eat], fishes)
                # fishes는 distance, y좌표, x좌표 순으로 정렬함
                # 가까운 거리, 위, 왼쪽 부터 잡아먹기 위해서
                fishes = list(fishes)
                fishes.sort(key = lambda x : (x[2], x[1], x[0]))
                fishes = deque(fishes)
            else:
                # 크기가 증가하지 않아도
                # 물고기 큐를 클리어하고 다시 구함
                fishes.clear()
                findFishes(N, arr, [sx, sy, lv, eat], fishes)
                # fishes는 distance, y좌표, x좌표 순으로 정렬함
                # 가까운 거리, 위, 왼쪽 부터 잡아먹기 위해서
                fishes = list(fishes)
                fishes.sort(key = lambda x : (x[2], x[1], x[0]))
                fishes = deque(fishes)
            
    return totalTime

N = int(sys.stdin.readline().rstrip())
arr = []
start = []
for j in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    try:
        i = temp.index(9)
        # x, y 좌표, 현재 크기, 먹은 수
        start = [i, j, 2, 0]
    except:
        pass
    arr.append(temp)

print(solution(N, arr, start))