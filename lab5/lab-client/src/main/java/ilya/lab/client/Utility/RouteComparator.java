package ilya.lab.client.Utility;

import ilya.lab.client.Classes.Route;

import java.util.Comparator;

/**
 * Route comparator
 */
public class RouteComparator implements Comparator<Route> {
    /**
     * returns whether the first argument is lower than the second
     *
     * @param r1        first argument
     * @param r2        second argument
     * @return          returns whether the first argument is lower than the second
     */
    public boolean isLower(Route r1, Route r2) {
        return compare(r1, r2) < 0;
    }

    /**
     * returns which argument is lower
     * @param r1        first argument
     * @param r2        second argument
     * @return          returns which argument is lower
     */
    @Override
    public int compare(Route r1, Route r2) {
        int retVal = 0;
        if (r1.getDistance() > r2.getDistance()) {
            retVal = 1;
        }
        if (r1.getDistance() < r2.getDistance()) {
            retVal = -1;
        }
        if (r1.getDistance() == r2.getDistance()) {
            if (r1.getName().compareTo(r2.getName()) < 0) {
                retVal = 1;
            }
            if (r1.getName().compareTo(r2.getName()) > 0) {
                retVal = -1;
            }
            if (r1.getName().compareTo(r2.getName()) == 0) {
                if (r1.getId() > r2.getId()) {
                    retVal = 1;
                }
                if (r1.getId() < r2.getId()) {
                    retVal = -1;
                }
            }
        }
        return retVal;
    }
}


