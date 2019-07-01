package Task_1_2;

import java.io.File;
import java.io.IOException;

public class CreatedFile extends File {

    public CreatedFile (String pathname) {
        super(pathname);

        try {
            createNewFile();
            mkdirs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
