import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class _1009_startAndLink_boj14889 {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(rd.readLine());
        int[][] ability = new int[N + 1][N + 1];
        int[] visited = new int[N + 1];
        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(rd.readLine());
            for (int i = 1; i < N + 1; i++) {
                ability[j + 1][i] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(ability, N, new ArrayList<Integer>(), visited);
        System.out.println(res);
        rd.close();
    }

    public static int calAbility(int[][] ability, int N, List<Integer> team) {
        int s = 0;
        for (int j = 0; j < team.size() - 1; j++) {
            for (int i = j + 1; i < team.size(); i++) {
                s = s + ability[team.get(j)][team.get(i)] + ability[team.get(i)][team.get(j)];
            }
        }
        return s;
    }

    public static void dfs(int[][] ability, int N, List<Integer> teamS, int[] visited) {
        if (teamS.size() >= N / 2) {
            List<Integer> teamL = new ArrayList<>();
            for (int i = 1; i < N + 1; i++) {
                if (teamS.contains(i))
                    continue;
                teamL.add(i);
            }
            int sSum = calAbility(ability, N, teamS);
            int lSum = calAbility(ability, N, teamL);
            // System.out.print(teamS.toString() + ":" + sSum);
            // System.out.println(teamL.toString() + ":" + lSum);
            res = Math.min(res, Math.abs(sSum - lSum));
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0) {
                if (teamS.size() == 0) {
                    visited[i] = 1;
                    teamS.add(i);
                    dfs(ability, N, teamS, visited);
                    teamS.remove(teamS.size() - 1);
                    visited[i] = 0;
                } else {
                    if (i > teamS.get(teamS.size() - 1)) {
                        visited[i] = 1;
                        teamS.add(i);
                        dfs(ability, N, teamS, visited);
                        teamS.remove(teamS.size() - 1);
                        visited[i] = 0;
                    }
                }
            }
        }
    }
}
