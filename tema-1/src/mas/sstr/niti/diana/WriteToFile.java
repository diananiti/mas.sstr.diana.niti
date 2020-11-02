package mas.sstr.niti.diana;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WriteToFile {

    private static final String FILENAME = "C:\\Users\\diana\\Desktop\\Lab1\\output.txt";

    private static BufferedWriter bw = null;
    private static FileWriter fw = null;

    public static void writeToFile(String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bw.write(content);
            bw.newLine();
            // no need to close it.
            //bw.close();

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void closeFile() {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
