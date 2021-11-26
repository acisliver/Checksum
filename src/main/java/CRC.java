import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class CRC {
    public static void main(String[] args) {

        byte[][] test = {{1, 0, 0, 1}, {1, 0, 1, 1,}, {0, 0, 1, 0}, {0, 1, 0, 1}, {0, 1, 1, 0}};

        System.out.println(getCRC32(test[0]));
    }

    public static long getCRC32(byte[] bytes) {

        Checksum crc = new CRC32();
        crc.update(bytes, 0, bytes.length);
        long calculated = crc.getValue();
        crc.reset();
        return calculated;
    }
}
