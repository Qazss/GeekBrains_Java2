package MainTask.Arrays;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        Integer[] ints = {1,2,3,4,5};
        Array<Integer> IntArr = new Array<Integer>(ints);
        IntArr.replaceArrElement(0,4);
        IntArr.printArray();

        String[] strings = {"sdfs", "fgd", "adas", "werw", "xcv"};
        Array<String> StrArr = new Array<String>(strings);
        StrArr.replaceArrElement(2,3);
        StrArr.printArray();

        System.out.println("--------------");

        // Задание 2
        ArrayList<Integer> IntList = IntArr.convertToArrayList();
        IntArr.printArrayList();

        ArrayList<String> StrList = StrArr.convertToArrayList();
        StrArr.printArrayList();
    }
}
