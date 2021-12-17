import java.util.Arrays;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class CRC {
    public static void main(String[] args) {

        // 입력값
        // byte[][] test = {{1, 0, 0, 1}, {1, 0, 1, 1,}, {0, 0, 1, 0}, {0, 1, 0, 1}, {0, 1, 1, 0}};
        String [] inputs = {"Computer", "Network", "Ko", "Daeeun", "2017108246"};

        // 대응되는 ASCII 코드 값으로 변환
        byte[] bytes = inputs[3].getBytes();

        // String to byte array
        System.out.println(Arrays.toString(bytes));

        System.out.println(getCRC32(bytes));
    }

    // CRC-4
    public static Object getCRC32(byte[] bytes) {
        return null;
    }

    // Internet Checksum
    public static long getInternetChecksum(byte[] bytes) {
        int length = bytes.length;
        int i = 0;
        long sum = 0;
        while (length > 0) {
            sum += (bytes[i++]&0xff) << 8;
            if ((--length)==0) break;
            sum += (bytes[i++]&0xff);
            --length;
        }

        // 음수범위를 없애고
        // Left값을 Right값에 더한 후
        // 1의 보수
        return (~((sum & 0xFFFF)+(sum >> 16)))&0xFFFF;
    }



    // Fletcher-16 Checksum
    public static long getFletcherChecksum(byte[] bytes){

        short sum1 = 0;
        short sum2 = 0;

        // 모듈러 연산 값
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
