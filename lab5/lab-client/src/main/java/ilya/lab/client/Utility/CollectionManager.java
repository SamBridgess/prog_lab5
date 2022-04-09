package ilya.lab.client.Utility;

import ilya.lab.client.Classes.Route;
import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.IO.RouteCreator;

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
    private final ArrayList<Float> distanceList = new ArrayList<>();
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
     * updates route by ID with a newly created route
     *
     * @param id        id of a route to update
     * @param io        passedIOManager
     * @throws WrongFileFormatException     thrown when scrypt file has wrong format
     */
    public void updateRouteByID(Long id, IOManager io) throws WrongFileFormatException, CtrlDException {
        Optional<Route> route = getRouteByID(id);
        if (route.isPresent()) {
            Route r = new RouteCreator(io, this).createRoute();
            collection.set(collection.indexOf(route.get()), r);
            distanceList.set(distanceList.indexOf(route.get().getDistance()), r.getDistance());
            io.printConfirmation("Updated element successfully");
        } else {
            io.printWarning("There is no object with such ID in the collection!");
            if (io.getIsFile()) {
                throw new WrongFileFormatException();
            }
        }

    }

    /**
     * removes route by ID
     *
     * @param id        ID of a route to remove
     * @param io        passed IOManager
     */
    public void removeRouteByID(Long id, IOManager io) throws WrongFileFormatException {
        Optional<Route> route = getRouteByID(id);
        if (route.isPresent()) {
            collection.remove(route.get());
            distanceList.remove(route.get().getDistance());
            io.printConfirmation("Element removed successfully");
        } else {
            io.printWarning("There is no object with such ID in the collection!");
            if (io.getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }

    /**
     * returns route with given ID or null in case there is no route with such ID
     * @param id        ID of a route to return
     * @return          returns route with given ID or null
     */
    private Optional<Route> getRouteByID(Long id) {
        return collection.stream().filter(route -> route.getId().equals(id)).findAny();
    }

    /**
     * prints collection
     * @param io        passed IOManager
     */
    public void printCollection(IOManager io) {
        for (Route route: collection) {
            io.println(route);
        }
    }

    /**
     * clears collection
     */
    public void clearCollection(IOManager io) {
        collection.clear();
        io.printConfirmation("Collection cleared successfully");
    }

    /**
     * remove route with given index
     * @param idx       index of route to remove
     */
    public void removeElement(int idx, IOManager io) {
        distanceList.remove(collection.get(idx).getDistance());
        collection.remove(idx);
        io.printConfirmation("Element removed successfully");
    }

    /**
     * sorts collection
     */
    public void sortCollection() {
        Collections.sort(collection);
    }

    /**
     * sorts collection's distance List
     */
    public void sortDistanceList() {
        Collections.sort(distanceList);
    }
    /**
     * reverses collection's distance List
     */
    public void reverseDistanceList() {
        Collections.reverse(distanceList);
    }

    /**
     * removes all objects from collection that are lower than the passed one
     * @param route     passed object
     */
    public void removeAllLower(Route route) {
        collection.removeIf(value -> new RouteComparator().isLower(value, route));
    }

    /**
     * print distance list
     *
     * @param io        passed IOManager
     */
    public void printDistanceList(IOManager io) {
        for (Float f : distanceList) {
            io.println(f);
        }
    }

    /**
     * adds new element to collection
     *
     * @param io        passed IOManager
     * @throws WrongFileFormatException     thrown when scrypt file has wrong format
     */
    public void addNewElement(IOManager io) throws WrongFileFormatException, CtrlDException {
        Route route = new RouteCreator(io, this).createRoute();

        collection.add(route);
        distanceList.add(route.getDistance());
        io.printConfirmation("Element added successfully");
    }

    /**
     * fills distance list after loading from xml file
     */
    public void fillDistanceList() {
        for (Route r : collection) {
            distanceList.add(r.getDistance());
        }
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
     * prints collection is ascending order
     *
     * @param io        passed IOManager
     */
    public void printCollectionAscending(IOManager io) {
        ArrayList<Route> listCopy = new ArrayList<>(collection);
        Collections.sort(listCopy);
        for (Route r : listCopy) {
            io.println(r);
        }
    }

    /**
     * prints all objects with distance less than given
     *
     * @param d         distance to compare with
     * @param io        passed IOManager
     */
    public void printLessThanDistance(float d, IOManager io) {
        for (Route r : collection) {
            if (r.getDistance() < d) {
                io.println(r);
            }
        }
    }

    /**
     * prints information about collection
     *
     * @param io        passed IOManager
     */
    public void printInfo(IOManager io) {
        io.println("Collection class: " + collection.getClass() + "\n"
                + "Creation date: " + collectionCreationDate + "\n"
                + "Collection size: " + collection.size());
    }


}
