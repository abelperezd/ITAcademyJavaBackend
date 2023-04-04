package n2e1;

import java.util.*;

public class Restaurants<E> extends HashSet<Restaurant> {

    @Override
    public boolean add(Restaurant r) {
        if (!this.stream().anyMatch(r2 -> r2.getPuntuacio() == r.getPuntuacio() && r2.getNom().toLowerCase().equals(r.getNom().toLowerCase()))) {
            super.add(r);
            return true;
        }
        return false;
    }

    public ArrayList<Restaurant> getOrderedRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>(this);
        restaurants.sort((r1, r2) -> {
            int res = r1.getNom().toLowerCase().compareTo(r2.getNom().toLowerCase());
            if (res == 0) {
                return r1.getPuntuacio() < r2.getPuntuacio() ? 1 : -1;
            } else
                return res;
        });
        return restaurants;
    }
}
