package MainTask.FruitBox;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private float boxWeight = 0;
    private ArrayList<T> fruitList = new ArrayList<T>();

    public Box (ArrayList<T> fruitList){
        this.fruitList = fruitList;
        getWeight();
    }

    public Box () {};

    public float getWeight() {
        for(int i = 0; i < fruitList.size(); i++){
            boxWeight += fruitList.get(i).getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box box) {
        return Math.abs(this.getBoxWeight() - box.getBoxWeight()) < 0.0001;
    }

    public void emptyBox(Box<T> box){
        fruitList.addAll(box.getFruitList());
        box.setFruitList(new ArrayList<T>());
        box.dropBoxWeight();
        dropBoxWeight();
        getWeight();
    }

    public void addFruit(T fruit){
        fruitList.add(fruit);
        boxWeight += fruit.getWeight();
    }

    public void printInfo(){
        if(fruitList.isEmpty())
            System.out.print("is Empty ");

        for(int i = 0; i < fruitList.size(); i++){
            System.out.print(fruitList.get(i).getName()+ "[" + fruitList.get(i).getWeight() + "]" + " ");
        }
        System.out.println("box weight: " + this.getBoxWeight());
    }

    public void dropBoxWeight(){
        boxWeight = 0;
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public float getBoxWeight() {
        return boxWeight;
    }
}
