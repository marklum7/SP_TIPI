import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String filePath = "/F:/123/var1.txt";

        HashMap types = new HashMap<>();
        types.put("d0bfd1", "txt");
        types.put("000000", "mp4");
        types.put("89504e", "png");
        types.put("ffd8ff", "jpg");

        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[3];

                String fileSignature = bytesToHex(buffer);
               // System.out.println(fileSignature);
                var format = types.get(fileSignature);
                System.out.println("Формат файла: " + format);


        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            hexStringBuilder.append(String.format("%02x", b));
        }
        return hexStringBuilder.toString();
    }
}