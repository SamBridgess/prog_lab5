package ilya.lab.client.Utility;

import ilya.lab.client.Classes.Route;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
@XmlRootElement(name = "Routes")
public class CollectionManager {
    @XmlElement(name = "route")
    private ArrayList<Route> collection = new ArrayList<>();
    private final Date collectionCreationDate = new Date();
    private Long maxId = 1L;

    /**
     * creates new CollectionManager
     *
     * @param collection        collection to work with
     */
    public CollectionManager(ArrayList<Route> collection) {
        this.collection = collection;
    }
    public CollectionManager() {
    }

    /**
     * assigns new ID with auto-incrementation
     *
     * @return          returns newly generated ID
     */
    public Long assignNewId() {
        return maxId++;
    }

    /**
     * checks if elemet with given ID is present in collection
     *
     * @param id    ID to check
     * @return
     */
    public boolean isElementIdPresent(Long id) {
        Optional<Route> route = getRouteByID(id);
        return route.isPresent();
    }
    /**
     * updates route by ID with a newly created route
     *
     * @param id        id of a route to update
     */
    public void updateRouteByID(Long id, Route r) {
        Optional<Route> route = getRouteByID(id);
        if (route.isPresent()) {
            collection.set(collection.indexOf(route.get()), r);
        }
    }

    /**
     * returns route with given ID or null in case there is no route with such ID
     *
     * @param id        ID of a route to return
     * @return
     */
    private Optional<Route> getRouteByID(Long id) {
        return collection.stream().filter(route -> route.getId().equals(id)).findAny();
    }

    /**
     * clears collection
     */
    public void clearCollection() {
        collection.clear();
    }

    /**
     * removes route by index
     *
     * @param idx   index of an element to remove
     * @return      returns if an element was removed successfully
     */
    public boolean removeRouteByIdx(int idx) {
        if (!collection.isEmpty()) {
            collection.remove(idx);
            return true;
        } else {
            return false;
        }
    }

    /**
     * removes route by ID
     *
     * @param id    ID of an element to remove
     * @return      returns if an element was removed successfully
     */
    public boolean removeRouteByID(Long id) {
        Optional<Route> route = getRouteByID(id);
        if (route.isPresent()) {
            collection.remove(route.get());
            return true;
        } else {
            return false;
        }
    }
    /**
     * sorts collection
     */
    public void sortCollection() {
        Collections.sort(collection);
    }


    /**
     * removes all objects from collection that are lower than the passed one
     * @param route     passed object
     */
    public void removeAllLower(Route route) {
        collection.removeIf(value -> new RouteComparator().isLower(value, route));
    }

    /**
     * returns a list with all distances, sorted descending
     *
     * @return
     */
    public ArrayList<Float> createDistanceList() {
        ArrayList<Float> distanceList = new ArrayList<>();
        for (Route r : collection) {
            distanceList.add(r.getDistance());
        }
        Collections.sort(distanceList);
        Collections.reverse(distanceList);
        return distanceList;
    }
    /**
     * adds new element to collection
     *
     * @param route  element to add
     */
    public void addNewElement(Route route) {
        collection.add(route);
    }

    /**
     * sets minimal ID after loading from xml file
     */
    public void setMinId() {
        for (Route r : collection) {
            maxId = Math.max(r.getId() + 1, maxId);
        }
    }

    /**
     * returns collection
     *
     * @return
     */
    public ArrayList<Route> getCollection() {
        return collection;
    }

    /**
     * returns information about collection
     *
     * @return
     */
    public String getInfo() {
        return "Collection class: " + collection.getClass() + "\n"
                + "Creation date: " + collectionCreationDate + "\n"
                + "Collection size: " + collection.size();
    }
}
