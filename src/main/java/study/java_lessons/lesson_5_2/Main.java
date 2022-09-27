package study.java_lessons.lesson_5_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {

    public static void convert(InputStream in, OutputStream out) throws IOException {
        TokenComparator comparator = new TokenComparator();
        int b;
        while ((b = in.read()) > 0) {
            if (TokenComparator.TokenFlags.CONTINUE != comparator.put((byte) b)) {
                out.write(comparator.getBuffer());
            }
        }
        if (TokenComparator.TokenFlags.CONTINUE == comparator.getFlag()) {
            out.write(comparator.getBuffer());
        }
        out.flush();
    }

    public static class TokenComparator {
        protected byte[] buffer;
        protected int it;
        protected byte[] compareToken = new byte[]{13, 10};
        protected byte[] replaceToken = new byte[]{10};

        public TokenComparator() {
            this.buffer = new byte[compareToken.length];
            this.it = 0;
        }

        public TokenFlags getFlag() {
            if (it == 0) return TokenFlags.CONTINUE;
            if (it == this.compareToken.length) return TokenFlags.EQUAL;
            if (this.buffer[it - 1] != this.compareToken[it - 1]) return TokenFlags.MISMATCH;
            return TokenFlags.CONTINUE;
        }

        public TokenFlags put(byte b) {
            if (this.getFlag() != TokenFlags.CONTINUE) throw new RuntimeException(String.valueOf(this.getFlag()));
            this.buffer[it++] = b;
            return this.getFlag();
        }

        public byte[] getBuffer() {
            byte[] res = (it == this.compareToken.length) ?
                    Arrays.copyOf(this.replaceToken, this.replaceToken.length)
                    : Arrays.copyOf(this.buffer, this.it);
            it = 0;

            return res;
        }

        public enum TokenFlags {CONTINUE, EQUAL, MISMATCH}
    }
}
