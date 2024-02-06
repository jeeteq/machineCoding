package resturentbooking.restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDb {

    private static RestaurantDb insatnce = null;
    List<Restaurant> restaurantList;

    private RestaurantDb() {
        this.restaurantList = new ArrayList<>();
    }

    public static RestaurantDb getInstance() {
        synchronized (RestaurantDb.class) {
            if (insatnce == null) {
                insatnce = new RestaurantDb();
            }
        }
        return insatnce;
    }

    public List<Restaurant> getListofRestaurant() {
        return this.restaurantList;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }
}
