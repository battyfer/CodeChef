package CPP;

import java.io.*;

public class ShortestRoute {

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


    public static void main(String[] args)throws IOException {
        Reader scn = new Reader();
        PrintWriter writer = new PrintWriter(System.out);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            int[] cities = new int[n];
            int[] traveller = new int[m];
            for (int j = 0; j < n; j++) {
                cities[j] = scn.nextInt();
            }
            for (int j = 0; j < m; j++) {
                traveller[j] = scn.nextInt();
            }

            int[] array1 = new int[n];
            int[] array2 = new int[n];
            for (int j = 0; j < n; j++) {
                if(cities[j] == 1)
                {
                    array1[j] = 0;
                }
                else
                {
                    array1[j] = 3;
                }
                if (cities[j] == 2)
                {
                    array2[j] = 0;
                }
                else
                {
                    array2[j] = 3;
                }
            }

            int count1 = -1;
            int count2 = -1;
            int abc = n-1;
            for (int j = 0; j < n; j++) {
                if(array1[j] == 0)
                {
                    count1 = j;
                }
                else if(array1[j] == 3 && count1 == -1)
                {
                    array1[j] = -1;
                }
                else
                {
                    array1[j] = j-count1;
                }
                if(array2[abc] == 0)
                {
                    count2 = abc;
                }
                else if(array2[abc] == 3 && count2 == -1)
                {
                    array2[abc] = -1;
                }
                else
                {
                    array2[abc] = count2 - abc;
                }
                abc--;
            }

            for (int j = 0; j < m; j++) {
                if((traveller[j]) == 1 && array1[(traveller[j] -1)] != 0 && array2[(traveller[j] -1)] != 0)
                {
                    writer.println(0);
                }
                else if(array1[(traveller[j] -1)] == -1 || array2[(traveller[j] -1)] == -1)
                {
                    writer.println(Math.max(array1[(traveller[j] -1)], array2[(traveller[j] -1)]));
                }
                else
                {
                    writer.println(Math.min(array1[(traveller[j] -1)], array2[(traveller[j] -1)]));
                }
                writer.flush();
            }
        }
        writer.close();
    }
}
