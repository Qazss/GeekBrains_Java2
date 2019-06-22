import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static boolean isStart = true;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        cyclicBarrier = new CyclicBarrier(CARS_COUNT, new RaceInfo());

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
    

    public static int getCarsCount() {
        return CARS_COUNT;
    }

    public static CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    static class RaceInfo implements Runnable{
        @Override
        public void run() {
            if(isStart){
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                isStart = false;
            } else {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
        }
    }
}
