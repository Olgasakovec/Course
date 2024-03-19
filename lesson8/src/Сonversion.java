import java.io.ByteArrayOutputStream;

public class Сonversion {
    public static void main(String[] args) {
        String text = "Hello java";
        byte[] bytes = text.getBytes();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes, 0, bytes.length);

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        for (int i = byteArray.length - 1; i >= 0; i--) {
            System.out.print((char) byteArray[i]);
        }
    }
}