
public class UnLoadDock extends Dock implements Point{
    int unloadPerSecond = 100;

    public UnLoadDock(String name, String product) {
        super(name, product);
    }

    public int unloadShipDuration(int volume) {
        return volume / unloadPerSecond * 100;
    }

    public synchronized void passPoint(Ship ship) {
        if(!ship.isEmpty() && !ship.getThread().isInterrupted()) {
            try {
                System.out.println("Разгрузка корабля " + ship.getName() + " началась...");
                Thread.sleep(unloadShipDuration(ship.getVolume()));
                ship.setEmpty();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                quantity += ship.getVolume();
                System.out.println("Разгрузка корабля " + ship.getName() + " закончена... // " + name + " " + quantity);
            }
        }
    }
}
