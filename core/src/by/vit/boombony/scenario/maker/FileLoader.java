package by.vit.boombony.scenario.maker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileLoader {

    private static final String PATH = "";

    public static void write(String fileName, String file) {
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(PATH + fileName);
            outputStream.write(file.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {

            FileInputStream fis = new FileInputStream(PATH + fileName);

            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return sb.toString();
    }
}
