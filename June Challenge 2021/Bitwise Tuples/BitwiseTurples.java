package CPP;

import java.io.DataInputStream;
import java.io.IOException;

public class BitwiseTurples {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

    }

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        long t = scn.nextLong();
        for (int i = 0; i < t; i++) {
            long n = scn.nextLong();
            long m = scn.nextLong();
            long answer = power(2,n) -1;
            answer = power(answer, m);
            System.out.println(answer);
        }
    }

    public static long power(long a, long b) {
        long temp = 1;
        while (b > 0) {
            if ((b % 2) == 1) {
                temp = (temp * a) % 1000000007;
            }
            a = (a*a)%1000000007;
            b = b/2;
        }
        return temp;
    }
}
