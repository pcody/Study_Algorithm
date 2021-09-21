import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0921_croatiaAlphabet_boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String str = rd.readLine();
        List<String> arr = new ArrayList<>(Arrays.asList(str.split("")));
        List<String> answerList = new ArrayList<String>();

        while (arr.size() > 0) {
            int size = arr.size();
            String ch = arr.get(0);
            if (!ch.equals("c") && !ch.equals("d") && !ch.equals("l") && !ch.equals("n") && !ch.equals("s")
                    && !ch.equals("z")) {
                answerList.add(arr.get(0));
                arr.remove(0);
            } else {
                if (ch.equals("l") || ch.equals("n")) {
                    if (size >= 2 && arr.get(1).equals("j")) {
                        String temp = ch + arr.get(1);
                        answerList.add(temp);
                        arr.remove(0);
                        arr.remove(0);
                    } else {
                        answerList.add(ch);
                        arr.remove(0);
                    }
                } else if (ch.equals("s") || ch.equals("z")) {
                    if (size >= 2 && arr.get(1).equals("=")) {
                        String temp = ch + arr.get(1);
                        answerList.add(temp);
                        arr.remove(0);
                        arr.remove(0);
                    } else {
                        answerList.add(ch);
                        arr.remove(0);
                    }
                } else if (ch.equals("d")) {
                    if (size >= 2 && arr.get(1).equals("-")) {
                        String temp = ch + arr.get(1);
                        answerList.add(temp);
                        arr.remove(0);
                        arr.remove(0);
                    } else if (size >= 3 && arr.get(1).equals("z") && arr.get(2).equals("=")) {
                        String temp = ch + arr.get(1) + arr.get(2);
                        answerList.add(temp);
                        arr.remove(0);
                        arr.remove(0);
                        arr.remove(0);
                    } else {
                        answerList.add(ch);
                        arr.remove(0);
                    }
                } else if (ch.equals("c")) {
                    if (size >= 2 && (arr.get(1).equals("=") || arr.get(1).equals("-"))) {
                        String temp = ch + arr.get(1);
                        answerList.add(temp);
                        arr.remove(0);
                        arr.remove(0);
                    } else {
                        answerList.add(ch);
                        arr.remove(0);
                    }
                }
            }

        }

        // System.out.println(arr);
        System.out.println(answerList);
        System.out.println(answerList.size());
        rd.close();
    }
}