package CPP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BellaCiao {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        long nextLong() { return Long.parseLong(next()); }
    }


    public static void main(String[] args) {
        FastReader scn = new FastReader();

        long t = scn.nextLong();
        for (int i = 0; i < t; i++) {
            long D = scn.nextLong();
            long d = scn.nextLong();
            long P = scn.nextLong();
            long Q = scn.nextLong();
            long total = 0;
            long n = D/d;
            long remainder = D%d;
            total = ((2*P*n + n*(n-1)*Q)/2)*d + remainder*(P + n*Q);
            System.out.println(total);
        }
    }
}
