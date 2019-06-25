package Task_1_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) {
        CreatedFile file1 = new CreatedFile("Files/task2_1.txt");
        CreatedFile file2 = new CreatedFile("Files/task2_2.txt");
        CreatedFile file3 = new CreatedFile("Files/task2_3.txt");
        CreatedFile file4 = new CreatedFile("Files/task2_4.txt");
        CreatedFile file5 = new CreatedFile("Files/task2_5.txt");
        CreatedFile resultFile = new CreatedFile("Files/task2_resultFile.txt");

        ArrayList<InputStream> inputArr = new ArrayList<>();

        try {
            inputArr.add(new FileInputStream(file1));
            inputArr.add(new FileInputStream(file2));
            inputArr.add(new FileInputStream(file3));
            inputArr.add(new FileInputStream(file4));
            inputArr.add(new FileInputStream(file5));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(SequenceInputStream in = new SequenceInputStream(Collections.enumeration(inputArr)); FileOutputStream out = new FileOutputStream(resultFile)) {
            int x;
            while ((x = in.read()) != -1){
                out.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
