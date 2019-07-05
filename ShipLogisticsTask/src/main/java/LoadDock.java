import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoadDock extends Dock implements Point{
    private int loadPerSecond = 100;
    private int quantity = super.quantity;

    public LoadDock(String name, String product, int quantity) {
        super(name, product, quantity);
    }

    public int loadShipDuration(int volume) {
        //TODO проверка на наличие ресурсов
        return volume / loadPerSecond * 100;
    }

    public void loadShip(Ship ship){
        if(ship.getVolume() <= quantity){
            quantity = quantity - ship.getVolume();
        } else {
            ship.setVolume(quantity);
            quantity = 0;
        }
    }

    public boolean notEmpty(){
        return quantity > 0;
    }

    public synchronized void passPoint(Ship ship){
        if (ship.isEmpty() && this.notEmpty() && !ship.getThread().isInterrupted()){
            try {
                System.out.println("Погрузка корабля " + ship.getName() + " началась...");
                Thread.sleep(loadShipDuration(ship.getVolume()));
                ship.setProduct(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                loadShip(ship);
                System.out.println("Погрузка корабля " + ship.getName() + " закончена... // Осталось на складе: " + name + " " + quantity);
            }
        } else {
            ship.changeRoute();
        }
    }
}
