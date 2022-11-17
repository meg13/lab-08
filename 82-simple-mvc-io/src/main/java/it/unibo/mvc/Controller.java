package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentfile;

    public void setFile(final File file) {
        this.currentfile = file;
    }
    public File getFile() {
        return currentfile;
        
    }
    public String getPath() {
        return currentfile.getAbsolutePath();
    }
    public void writeString(final String insert) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentfile));
            writer.write(insert);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

}
