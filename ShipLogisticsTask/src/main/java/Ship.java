
public class Ship implements Runnable{
    private String name;
    private String product;
    private int volume = 500;
    private Route route;
    private String empty = "пустой";

    public Ship(Route route, String name){
        this.route = route;
        this.name = name;
        product = "пустой";
        //TODO Добавить провереку на отрицательную емкость
    }

    public void run() {
        for(Point point: route.getRoutePoints()){
            point.passPoint(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setEmpty(){
        product = empty;
    }

    public boolean isEmpty(){
        return product.equals(empty);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void changeRoute() {
        boolean isChanged = false;

        for(int i = 0; i < Transportation.getRoutes().size(); i++){
            if(Transportation.getRoutes().get(i).getLoadDock().notEmpty()){
                route = Transportation.getRoutes().get(i);
                isChanged = true;
                break;
            }
        }
        if(!isChanged){
            if(Transportation.transportationIsActive(Transportation.getShips())) {
                Transportation.isActive = false;
                Thread.currentThread().interrupt();
                System.out.println(name + "прерван!!!");
            } else {
                Transportation.isActive = false;
                System.out.println("!!!!!!!!!!!!!" + Transportation.isActive);
            }
        }
    }

    public Thread getThread(){
        return Thread.currentThread();
    }
}
