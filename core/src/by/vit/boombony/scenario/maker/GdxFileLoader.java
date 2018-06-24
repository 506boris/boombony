package by.vit.boombony.scenario.maker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class GdxFileLoader {

    public static void write(String fileName, String file) {

        FileHandle fileHandle = Gdx.files.absolute(fileName);
        fileHandle.writeString(file, false);
    }

    public static String read(String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        return fileHandle.readString();
    }
}
