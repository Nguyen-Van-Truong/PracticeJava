import java.io.*;

public class EncryptXor {
    public static void encryptXor(String input, String output, String key) throws IOException {
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);
        byte[] buffer = new byte[1024];
        int bytesRead;
        byte[] keyBytes = key.getBytes();
        long keyIndex = 0;
        while ((bytesRead = fis.read(buffer)) != -1) {
            for (int i = 0; i < bytesRead; i++) {
                buffer[i] = (byte) (buffer[i] ^ keyBytes[(int) (keyIndex % keyBytes.length)]);
                keyIndex++;
            }

            fos.write(buffer, 0, bytesRead);

        }
        fis.close();
        fos.close();

    }

    public static void main(String[] args) {
        String input = "D:\\intellji\\PracticeJava\\PracticeJava\\src\\1.txt";
        String output = "D:\\intellji\\PracticeJava\\PracticeJava\\src\\2.txt";
        String output2 = "D:\\intellji\\PracticeJava\\PracticeJava\\src\\3.txt";
        String key = "abc123";

        try {
            encryptXor(input, output, key);
            encryptXor(output, output2, key);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
