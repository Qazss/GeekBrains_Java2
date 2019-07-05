import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Transportation {
    static String fuel = "Топливо";
    static String clothes = "Одежда";
    static String food = "Еда";
    static int routeQuantity = 3;
    static  int shipQuantity = 5;
    static ArrayList<Route> routes;
    static boolean isActive = true;
    static Ship[] ships;

    public static void main(String[] args) {
        Route route1 = new Route(new LoadDock("Загрузка одежда", clothes, 1000), new Channel(), new UnLoadDock("Выгрузка одежда", clothes));
        Route route2 = new Route(new LoadDock("Загрузка топливо", fuel, 1000), new Channel(), new UnLoadDock("Выгрузка топливо", fuel));
        Route route3 = new Route(new LoadDock("Загрузка еда", food, 1000), new Channel(), new UnLoadDock("Выгрузка еда", food));

        routes = new ArrayList<Route>();
        routes.add(route1);
        routes.add(route2);
        routes.add(route3);

        ExecutorService service = Executors.newFixedThreadPool(shipQuantity);

        ships = new Ship[shipQuantity];
        for (int i = 0; i < ships.length; i++){
            int number = i + 1;
            ships[i] = new Ship(routes.get(getRandomRoute(routeQuantity)), "корабль #" + number);
        }

        while (isActive){
            for(int i = 0; i < ships.length; i++){
                service.execute(ships[i]);
            }
        }

    }

    public static int getRandomRoute(int max){
        return (int)Math.round(Math.random() * (max - 1));
    }

    public static boolean transportationIsActive(ArrayList<Route> routes){
        for(int i = 0; i < routes.size(); i++){
            if(routes.get(i).getLoadDock().notEmpty()){
                return true;
            }
        }
        return false;
    }

    public static boolean transportationIsActive(Ship[] ships){
        for(int i = 0; i < ships.length; i++){
            if(!ships[i].getThread().isInterrupted()){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Route> getRoutes() {
        return routes;
    }

    public static Ship[] getShips() {
        return ships;
    }
}
