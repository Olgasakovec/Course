import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    static {
        System.getProperty("user.dir");
    }

    public static void main(String[]args) {
        try (FileInputStream fin = new FileInputStream("src/variant5.txt"))
        {
            int i = -1;
            while ((i = fin.read()) != -1) {
                System.out.println((char) i);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}


