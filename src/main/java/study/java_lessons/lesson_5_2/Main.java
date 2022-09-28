package study.java_lessons.lesson_5_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    protected static byte[] compareToken = new byte[]{13, 10};
    protected static byte[] replaceToken = new byte[]{10};

    public static void convert(InputStream in, OutputStream out) throws IOException {
        int b;
        int it = 0;
        byte[] buf = new byte[2];
        while ((b = in.read()) > 0) {
            if (it == 0) {
                if (b != compareToken[it]) {
                    out.write(b);
                    continue;
                } else {
                    buf[it] = (byte) b;
                    it++;
                }

            } else {
                if (b == compareToken[it]) {
                    it = 0;
                    out.write(replaceToken);
                } else {
                    out.write(buf[0]);
                    buf[0] = (byte) b;
                }
            }
        }
        if (it != 0) {
            out.write(buf[0]);
        }
        out.flush();
    }
//    public static void convert(InputStream in, OutputStream out) throws IOException {
//        TokenComparator comparator = new TokenComparator();
//        int b;
//        while ((b = in.read()) > 0) {
//            if (TokenComparator.TokenFlags.CONTINUE != comparator.put((byte) b)) {
//                out.write(comparator.getBuffer());
//            }
//        }
//        if (TokenComparator.TokenFlags.CONTINUE == comparator.getFlag()) {
//            out.write(comparator.getBuffer());
//        }
//        out.flush();
//    }

    public static void main(String[] args) throws IOException {
        convert(System.in, System.out);
    }

}
