
public class Marker {
    private Object object;
    private int id;

    public Marker(Object object){
        this.object = object;
        id = this.hashCode();
    }

    public int getId(){
        return id;
    }
}
