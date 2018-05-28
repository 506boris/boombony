package by.vit.boombony.maps;

import java.io.*;

public class FileLoader {

    private static final String PATH = "c://";

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
