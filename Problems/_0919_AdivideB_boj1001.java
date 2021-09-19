package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0919_AdivideB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] temp = str.split(" ");

        System.out.println(Double.parseDouble(temp[0]) / Double.parseDouble(temp[1]));
    }
}
