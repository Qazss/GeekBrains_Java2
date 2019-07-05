import java.util.ArrayList;

public class Route {
    ArrayList<Point> routePoints = new ArrayList<Point>();
    LoadDock loadDock;

    public Route(){

    }

    public Route(LoadDock LoadDock, Channel channel, UnLoadDock unloadDock){
        routePoints.add(LoadDock);
        routePoints.add(channel);
        routePoints.add(unloadDock);
        this.loadDock = LoadDock;
    }

    public ArrayList<Point> getRoutePoints() {
        return routePoints;
    }

    public void addRoutePoint(Point point) {
        routePoints.add(point);
    }

    public LoadDock getLoadDock() {
        return loadDock;
    }
}
