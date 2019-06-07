package MainTask.FruitBox;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<Apple>();
        appleBox.addFruit(new Apple(1.1f));
        appleBox.addFruit(new Apple(1.5f));
        appleBox.addFruit(new Apple(1.7f));
        appleBox.addFruit(new Apple(1.3f));
        appleBox.addFruit(new Apple(1.8f));

        Box<Orange> orangeBox1 = new Box<Orange>();
        orangeBox1.addFruit(new Orange(2.2f));
        orangeBox1.addFruit(new Orange(2.8f));
        orangeBox1.addFruit(new Orange(2.4f));

        Box<Orange> orangeBox2 = new Box<Orange>();
        orangeBox2.addFruit(new Orange(2.3f));
        orangeBox2.addFruit(new Orange(2.5f));

        appleBox.printInfo();
        orangeBox1.printInfo();
        orangeBox2.printInfo();

        System.out.println(appleBox.compare(orangeBox1));

        // пересыпаем фрукты и смотрим на результат
        System.out.println("--------------------------");
        orangeBox1.emptyBox(orangeBox2);

        appleBox.printInfo();
        orangeBox1.printInfo();
        orangeBox2.printInfo();

        System.out.println(appleBox.compare(orangeBox1));
    }
}
