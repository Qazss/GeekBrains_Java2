package MainTask.Arrays;

import java.util.ArrayList;

public class Array <T> {
    private T[] array;
    private T arrElement;
    private ArrayList arrayList;

    public Array(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void replaceArrElement(int position1, int position2) {
        arrElement = array[position1];

        array[position1] = array[position2];
        array[position2] = arrElement;
    }

    public void printArray(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public ArrayList convertToArrayList(){
        arrayList = new ArrayList();

        for(int i = 0; i < array.length; i++){
            arrayList.add(array[i]);
        }

        return arrayList;
    }

    public void printArrayList(){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }
}
