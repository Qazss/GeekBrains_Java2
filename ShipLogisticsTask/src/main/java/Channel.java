import java.util.concurrent.Semaphore;

public class Channel implements Point{
    int length = 3;
    int capacity = 2;
    Semaphore semaphore;

    public void passPoint(Ship ship) {
        if (!ship.getThread().isInterrupted()) {
            try {
                semaphore = new Semaphore(capacity, true);

                semaphore.acquire();
                System.out.println("Корабль " + ship.getName() + " проходит пролив...");
                Thread.sleep(length * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Корабль " + ship.getName() + " успешно прошел пролив...");
                semaphore.release();
            }
        }
    }
}
