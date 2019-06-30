package ReadApp;

import Task_1_2.CreatedFile;

public class Main {
    public static void main(String[] args) {
        CreatedFile file = new CreatedFile("Files/fileReader.txt");
        FileReader reader = new FileReader(file);

        while (reader.isEnabled()) {
            reader.readFile();
        }
    }
}
