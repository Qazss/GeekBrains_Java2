package ReadApp;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReader {
    private File file;
    private int userPage;
    private int pageDimension = 1800;
    private boolean isEnabled = true;

    public FileReader(File file) {
        this.file = file;
    }

    public FileReader(String path) {
        this.file = new File(path);
    }

    public void readFile(){
        readPageNumber();
        int startPosition = pageDimension * (userPage - 1);
        byte[] arr = new byte[pageDimension];

        long time = System.currentTimeMillis();
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            if(isEnabled) {
                randomAccessFile.seek(startPosition);
                int x;
                int count = 0;

                while ((x = randomAccessFile.read()) != -1 && count != pageDimension) {
                    arr[count] = (byte) x;
                    count++;
                }
                String resultString = new String(arr, "UTF-8");
                System.out.println(resultString);
                System.out.println(System.currentTimeMillis() - time);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPageNumber(){
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Введите страницу документа...");
        try {
            input = in.nextLine();
            if(input.equals("/end")){
                isEnabled = false;
                System.out.println("SYSTEM: Работа программы завершена");
            } else {
                userPage = Integer.parseInt(input);
            }
        } catch (NumberFormatException e){
            System.out.println("SYSTEM: Введено некорректное значение");
            readPageNumber();
        }
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
