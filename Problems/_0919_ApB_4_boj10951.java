package JavaCompleted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _0919_ApB_4_boj10951 {
    public static void main(String[] args) throws IOException {
        func3();
    }

    public static String fucn1() {
        Scanner sc = new Scanner(System.in);
        String[] str;
        StringBuilder answer = new StringBuilder();
        while (true) {
            try {
                str = sc.nextLine().split(" ");
                Integer a = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
                answer.append(a.toString() + "\n");
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        sc.close();
        return answer.toString();
    }

    public static String func2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str, answer = "";
        StringTokenizer st;

        while ((str = reader.readLine()) != null) {
            st = new StringTokenizer(str);
            Integer a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            answer = answer + a.toString() + "\n";
        }

        reader.close();
        return answer;
    }

    public static void func3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringTokenizer st;

        while ((str = reader.readLine()) != null) {
            st = new StringTokenizer(str);
            Integer a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            writer.write(a.toString() + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}