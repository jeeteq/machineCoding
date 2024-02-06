import java.util.Date;
import resturentbooking.restaurant.Restaurant;
import resturentbooking.restaurant.RestaurantDb;
import resturentbooking.service.RestaurantHandler;
import resturentbooking.service.SearchCriteria;
import resturentbooking.user.Client;
import resturentbooking.user.RestaurantOwner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        RestaurantDb db = RestaurantDb.getInstance();
        RestaurantOwner owner1 = new RestaurantOwner("owner1", "Noida");
        RestaurantOwner owner2 = new RestaurantOwner("owner2", "Delhi");
        Client client1 = new Client("Jeetndra", "Patna");
        Restaurant r1 = new Restaurant(owner1, "nameA", "Noida", 5);
        Restaurant r2 = new Restaurant(owner2, "nameB", "Noida", 6);
        Restaurant r3 = new Restaurant(owner2, "nameC", "Delhi", 7);

        RestaurantHandler handler = new RestaurantHandler(db);
        handler.registerRestaurant(r1);
        handler.registerRestaurant(r2);
        handler.registerRestaurant(r3);

        Restaurant restaurant = handler.searchRestaurant(new SearchCriteria().restaurantName("nameA"));
        handler.bookSlot(restaurant, new Date(System.currentTimeMillis() + 100000), 2);
        handler.bookSlot(restaurant, new Date(System.currentTimeMillis() + 100000), 2);
        handler.bookSlot(restaurant, new Date(System.currentTimeMillis() + 100000), 2);
        handler.bookSlot(restaurant, new Date(System.currentTimeMillis() + 200000), 2);

    }
}