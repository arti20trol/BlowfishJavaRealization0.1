package blowfish.methods;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleMethods {
    public static long trim(long data) {
        return (data & 0xFFFFFFFFL);
    }

    public static int[] readFile(String filename) throws IOException {
        InputStream is = new FileInputStream(filename);
        int[] a = new int[is.available()];
        int i = 0;
        while (is.available() > 0) {
            a[i] = is.read();
            i++;
        }
        return a;
    }

    public static String arrayToString(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int datum : data) {
            sb.append(datum);
        }
        return sb.toString();
    }

    public static void printBinary32(int data) {
        System.out.println(String.format("%32s", Integer.toBinaryString(data)).replace(' ', '0'));
    }
    public static void printBinary64(long data) {
        System.out.println(String.format("%64s", Long.toBinaryString(data)).replace(' ', '0'));
    }

}
