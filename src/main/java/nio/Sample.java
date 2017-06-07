package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by joshua.chi on 6/6/17.
 */
public class Sample {
    public void p() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/joshua.chi/workspace/leetcode-training/src/main/resources/data.txt", "r");
            FileChannel c = randomAccessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(100);

            int i = c.read(buffer);
            while (i != -1) {

                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println(buffer.get());
                }
                buffer.clear();
                i = c.read(buffer);
            }

            c.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.p();

    }
}
