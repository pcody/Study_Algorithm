package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0919_AxB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int a, b;
        String[] temp = str.split(" ");
        a = Integer.parseInt(temp[0]);
        b = Integer.parseInt(temp[1]);
        System.out.println(a * b);
    }
}
