package Task_1_2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task1 {
    public static void main(String[] args) {

        CreatedFile file1 = new CreatedFile("123/task1.txt");

        try(FileInputStream in = new FileInputStream(file1)){
            int x;
            byte[] temp = new byte[100];

            while ((x = in.read(temp)) != -1){
                System.out.println(new String(temp, 0, x, StandardCharsets.UTF_8));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
