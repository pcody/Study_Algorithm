import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class _220127_IPAddress_boj2064 {
    static List<String> addresses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());
        for (int i = 0; i < n; i++) {
            addresses.add(rd.readLine());
        }

        String[] network = findNetwork().split("/");
        String minNetwork = network[0];
        String mask = network[1];
        System.out.println(minNetwork);
        System.out.println(mask);
        rd.close();
    }

    public static String findNetwork() {
        // m: 0의 개수
        String res = "";
        int[] mask = { 0, 0, 0, 0 };
        for (int m = 0; m <= 32; m++) {
            mask = getMask(m);
            boolean flag = true;
            res = filterByMask(mask, addresses.get(0));
            for (int i = 1; i < addresses.size(); i++) {
                String temp = filterByMask(mask, addresses.get(i));
                if (!res.equals(temp)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return res + "/" + mask[0] + "." + mask[1] + "." + mask[2] + "." + mask[3];
    }

    public static String filterByMask(int[] mask, String address) {
        String[] add = address.split("\\.");
        String ret = "";
        for (int i = 0; i < 4; i++) {
            ret += (mask[i] & Integer.parseInt(add[i]));
            if (i < 3) {
                ret += ".";
            }
        }
        return ret;
    }

    public static int[] getMask(int m) {
        int[] mask = { 255, 255, 255, 255 };
        if (m <= 8) {
            mask[3] = (mask[3] >> m) << m;
        } else if (m <= 16) {
            mask[3] = 0;
            mask[2] = (mask[2] >> (m - 8)) << (m - 8);
        } else if (m <= 24) {
            mask[3] = 0;
            mask[2] = 0;
            mask[1] = (mask[1] >> (m - 16)) << (m - 16);
        } else {
            mask[3] = 0;
            mask[2] = 0;
            mask[1] = 0;
            mask[0] = (mask[0] >> (m - 24)) << (m - 24);
        }
        return mask;
    }
}