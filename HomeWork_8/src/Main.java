import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String a = "aaaa";
        Integer intA = 444;
        String b = "bbb";
        Character charA = 'G';

        MySortedList list = new MySortedList();
        list.add(a);
        list.add(intA);
        list.add(b);
        list.add(charA);

        System.out.println(list.getLength());


//        ArrayList<Object> list = new ArrayList<>();
//        list.add(a);
//        list.add(b);
//        list.add(intA);
//
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
    }
}
