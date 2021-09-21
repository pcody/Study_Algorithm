import sys
from collections import deque

def bfs(S):

    q = deque()
    visited = [[0] * (S * 2) for _ in range(S * 2)]
    q.append([1, 0, 0])
    visited[1][0] = 1

    while q:
        # m:모니터, c:클립보드, t:걸린시간
        m, c, t = q.popleft()
        if m == S:
            return t
        else:
            # 화면 이모티콘 0개일때
            # 1. 클립보드로 복사하는 경우 제외
            # 3. 화면 이모티콘 삭제하는 경우 제외
            if m == 0:
                # 2. 클립보드 -> 화면
                if not visited[m + c][c]:
                    q.append([m + c, c, t + 1])
                    visited[m + c][c] = 1
            # 클립보드 이모티콘 0개일때
            # 2. 화면으로 붙여넣는 경우 제외
            elif c == 0:
                # 1. 화면 -> 클립보드
                if not visited[m][m]:
                    q.append([m, m, t + 1])
                    visited[m][m] = 1
                # 3. 화면 이모티콘 1개 삭제
                if not visited[m - 1][c]:
                    q.append([m - 1, c, t + 1])
                    visited[m - 1][c] = 1
            else:
                if m != c:
                    # 1. 화면 -> 클립보드
                    if not visited[m][m]:
                        q.append([m, m, t + 1])
                        visited[m][m] = 1
                if c > 0:
                    if m + c < S * 2:
                        # 2. 클립보드 -> 화면
                        if not visited[m + c][c]:
                            q.append([m + c, c, t + 1])
                            visited[m + c][c] = 1
                if m > 0:
                    # 3. 화면 이모티콘 1개 삭제
                    if not visited[m - 1][c]:
                        q.append([m - 1, c, t + 1])   
                        visited[m - 1][c] = 1

S = int(sys.stdin.readline().rstrip())
print(bfs(S))