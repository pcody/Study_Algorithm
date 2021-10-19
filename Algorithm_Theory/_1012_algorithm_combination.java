public class _1012_algorithm_combination {
    public static void main(String[] args) {
        // nCr 구현
        int n = 10;
        int[] visited = new int[n + 1];
        combination(visited, 0, 3, 0);
    }

    // n개의 수에서 r개를 뽑아야함
    // nn: 뽑은 수, r: 뽑아야할 수, j: 직전에 뽑은 인덱스
    public static void combination(int[] visited, int nn, int r, int j) {
        if (nn >= r) {
            for (int i = 1; i < visited.length; i++) {
                if (visited[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0 && i > j) {
                visited[i] = 1;
                combination(visited, nn + 1, r, i);
                visited[i] = 0;
            }
        }
    }

}