import java.util.ArrayList;

public class ArrayReformer {

    public int[] getElementsAfter4 (int[] array) throws RuntimeException{
        ArrayList<Integer> IntList = new ArrayList<Integer>();
        int[] resultArr;

        int i = array.length - 1;
        while (array[i] != 4){
            IntList.add(0, array[i]);
            i--;
        }

        if(IntList.isEmpty()){
            throw new RuntimeException();
        } else {
            resultArr = new int[IntList.size()];
            for(int j = 0; j < IntList.size(); j++){
                resultArr[j] = IntList.get(j);
            }
        }
        return resultArr;
    }

    public boolean containNums(int[] array){
        boolean result = false;

        if(array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1 || array[i] == 4)
                    result = true;
            }
        }
        return result;
    }
}
