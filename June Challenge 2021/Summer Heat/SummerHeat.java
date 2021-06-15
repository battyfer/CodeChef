package CPP;

import java.util.Scanner;

public class SummerHeat {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            int x = scn.nextInt();
            int y = scn.nextInt();
            int count = 0;
            count = (x/a) + (y/b);
            System.out.println(count);
        }
    }
}
