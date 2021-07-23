# 위상정렬
# 기본 컨셉
# 정점들의 진입차수(In-degree)란 한 정점으로 들어오는 간선의 개수를 말함.
# 진입 차수를 한 배열에 저장하고
# 진입차수가 0인 노드를 모두 스택에 넣고, 하나씩 꺼내면서
# 해당 노드에서 갈 수 있는 노드의 진입 차수를 1 감소시킨다.
# 진입 차수가 0이 된 노드는 스택에 넣는다.
# 스택을 사용하거나 큐를 사용하는 경우에 따라 결과가 달라질 수 있음

adj_matrix = [[0, 0, 1, 1, 0, 0],
              [0, 0, 0, 1, 1, 0],
              [0, 0, 0, 1, 0, 1],
              [0, 0, 0, 0, 0, 1],
              [0, 0, 0, 0, 0, 1],
              [0, 0, 0, 0, 0, 0]]

def topological_sort(adj_matrix):
    N = len(adj_matrix) - 1
    in_degrees = [0] * (N + 1)
    stack = []
    answer = []

    # 진입 차수
    for j in range(N):
        for i in range(N + 1):
            if j == i:
                continue
            else:
                if adj_matrix[j][i] == 1:
                    in_degrees[i] += 1
    print("진입 차수 : ", end='')
    print(in_degrees)

    # 초기 스택
    for i, elem in enumerate(in_degrees):
        if elem == 0:
            stack.append(i)
    print("초기 스택 : ", end='')
    print(stack)

    while stack:
        node = stack.pop()
        answer.append(node)
        print(f"pop된 노드: {node}")
        for i, elem in enumerate(adj_matrix[node]):
            if elem != 0:
                in_degrees[i] -= 1
                if in_degrees[i] == 0:
                    print(f"진입차수 0이된 노드: {i}")
                    stack.append(i)

    return answer

print(topological_sort(adj_matrix))
