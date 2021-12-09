import java.util.Arrays;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class CRC {
    public static void main(String[] args) {

        // byte[][] test = {{1, 0, 0, 1}, {1, 0, 1, 1,}, {0, 0, 1, 0}, {0, 1, 0, 1}, {0, 1, 1, 0}};
        String [] inputs = {"Computer", "Network", "Ko", "Daeeun", "2017108246"};

        byte[] bytes = inputs[3].getBytes();
        System.out.println(Arrays.toString(bytes));

        System.out.println(getCRC32(bytes));
    }

    // Checksum
    public static long getChecksum(Checksum checksum){

        return checksum.getValue();
    }

    // CRC-32
    public static long getCRC32(byte[] bytes) {
        Checksum crc = new CRC32();
        crc.update(bytes, 0, bytes.length);
        long calculated = crc.getValue();
        crc.reset();
        return calculated;
    }

    // Internet Checksum
    public static long getInternetChecksum(byte[] bytes){


        return 0;
    }

    // Fletcher-16 Checksum
    public static long getFletcherChecksum(byte[] bytes){

        short sum1 = 0;
        short sum2 = 0;
        short modulus = 255;

        for (int i = 0; i < bytes.length; i++){
            sum1 = (short) ((sum1 + bytes[i]) % modulus);
            sum2 = (short) ((sum2 + sum1) % modulus);
        }
        return (short) ((sum2 << 8) | sum1);
    }

    // Adler Checksum
    public static long getAdlerChecksum(byte[] bytes){

        Checksum checksum = new Adler32();

        checksum.update(bytes, 0, bytes.length);

        return checksum.getValue();
    }

}
