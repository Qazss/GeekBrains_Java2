import java.util.ArrayList;
import java.util.LinkedList;

public class MySortedList extends LinkedList {

    public int getLength(){
        int length = 0;

        if(!isEmpty()){
            Marker marker = new Marker(this.get(0));
            int markerId = marker.getId();
            this.set(0, marker);

            int i = 1;
            while (this.getLast().hashCode() != markerId){
                this.add(0, this.getLast());
                this.removeLast();

                for(int j = 0; j < 4; j++){
                    System.out.println(i + ".  " + this.get(j) + " " + this.get(j).hashCode() + " " + markerId);
                }
                System.out.println("------------");

                i++;
            }
                length = i;
                return length;
        } else {
            return length;
        }
    }

    public boolean isEmpty(){
        return this.get(0) == null;
    }
}
