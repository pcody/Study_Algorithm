import sys
from collections import deque
import itertools

def bfs(N, M, laboratory, virus):
    answer = 0
    visited = [[0] * N for _ in range(N)]
    vecxy = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    q = deque()
    flag1, flag2 = 0, 0

    # 초기 바이러스 위치를 q에 넣는다
    for x, y in virus:
        visited[y][x] = 1
        q.append([x, y, 0])
    
    time = 0
    # 0의 개수를 세서
    zeroCnt = 0
    for elem in laboratory:
        zeroCnt += elem.count(0)
    # 바이러스를 전파할 0이 있을 때만 flag1: 1
    if zeroCnt > 0:
        flag1 = 1    
    # flag1: 1일때만 큐를 진행
    if flag1:
        # q를 돌면서 4방향 검사
        while q:
            x, y, time = q.popleft()
            answer = max(answer, time)

            for vecx, vecy in vecxy:
                nx, ny = x + vecx, y + vecy
                # 좌표 내이고
                if 0 <= nx < N and 0 <= ny < N:
                    # 방문을 안 했고
                    if not visited[ny][nx]:
                        # 정보가 0이면 퍼뜨릴 수 있는 곳이므로 q에 넣는다
                        if laboratory[ny][nx] == 0:
                            # 방문정보는 시간으로
                            # 0을 방문할때마다 총 방문해야할 0개수를 1씩 뺌
                            zeroCnt -= 1
                            visited[ny][nx] = time + 1
                            q.append([nx, ny, time + 1])
                        elif laboratory[ny][nx] == 2:
                            # 비활성 바이러스를 방문할때
                            # 방문정보는 -2로 변경
                            visited[ny][nx] = -2
                            # 방문할 0이 남았으면 큐에 넣을때 시간+1
                            if zeroCnt > 0:
                                q.append([nx, ny, time + 1])
                            # 0이 남지 않았으면 큐에 마지막 시간
                            else:
                                q.append([nx, ny, time])
                        # 정보가 1이면 퍼뜨릴 수 없는 곳이므로
                        else:
                            # -1로 표시 (비활성바이러스, 벽)
                            visited[ny][nx] = -1
        
        # q를 다 돌고난 후 방문리스트에 벽은 -1로 변경
        for j in range(N):
            for i in range(N):
                if not visited[j][i] and laboratory[j][i] == 1:
                    visited[j][i] = -1

        for elem in visited:
            # print(elem)
            # 못간 구역이 있으면 flag1: 1
            if 0 in elem:
                flag2 = 1

        # time이 0이 아니고, 못간 구역이 있으면
        if time and flag2:
            # -1 리턴
            answer = -1
        # print(time, answer)
    return answer

N, M = map(int, sys.stdin.readline().split())
answers = []

# 연구실 정보 입력
laboratory = []
for _ in range(N):
    laboratory.append(list(map(int, sys.stdin.readline().split())))

# 바이러스 좌표 구하기
allVirus = []
for j in range(N):
    for i in range(N):
        if laboratory[j][i] == 2:
            allVirus.append([i, j])

# 활성 바이러스 구하기
activeVirus = itertools.combinations(allVirus, M)
for virus in activeVirus:
    # BFS
    answers.append(bfs(N, M, laboratory, virus))

answers.sort(reverse = True)
# answers max 원소가 -1이 아니면
if max(answers) != -1:
    # 역순 소팅 후 -1 직전 인덱스의 값을 answer로 취함
    if -1 in answers:
        answer = answers[answers.index(-1) - 1]
    # -1이 없으면 최소값을 answer로 취함
    else:
        answer = min(answers)
# answers max 원소가 -1이면
else:
    answer = -1
print(answer)

# 맞음
# 11 2
# 1 1 0 1 1 1 1 1 0 1 1
# 1 1 2 1 1 1 1 1 2 1 1
# 0 1 2 1 1 1 0 1 2 1 1
# 0 1 0 1 1 1 0 1 0 1 1
# 0 0 2 0 0 1 0 0 2 0 0
# 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1
# 1 1 1 1 1 1 1 1 1 1 1
# 4

# 맞음
# 4 1
# 2 1 1 1
# 1 1 1 1
# 1 1 1 1
# 1 1 1 1
# 0

# 맞음
# 5 1
# 2 2 2 1 1
# 2 1 1 1 1
# 2 1 1 1 1
# 2 1 1 1 1
# 2 2 2 2 0
# 1

# 맞음
# 5 1
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 0 2 0 2 0
# 1 1 1 1 1
# 3

# 맞음
# 5 1
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 2 0 0 2 0
# 1 1 1 1 1
# 2

# 맞음
# 4 2
# 0 1 1 0
# 2 1 1 2
# 2 1 1 2
# 0 1 1 0
# 2

# 맞음
# 5 3
# 2 2 2 0 0
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 2

# 맞음
# 4 4
# 1 1 1 1
# 1 2 2 1
# 1 2 2 1
# 1 1 1 1
# 0

# 맞음
# 4 2
# 1 1 1 1
# 1 2 2 1
# 1 2 2 1
# 1 1 1 1
# 0

# 맞음
# 4 1
# 1 1 1 1
# 1 2 2 1
# 1 2 2 1
# 1 1 1 1
# 0