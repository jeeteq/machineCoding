package resturentbooking.service;

import resturentbooking.restaurant.Restaurant;
import resturentbooking.restaurant.RestaurantType;


public class SearchCriteria {
    String restaurantName;
    String city;
    String area;
    String cuisine;
    Double costOfTwo;
    RestaurantType restaurantType;
    Integer noOfTable;

    public SearchCriteria restaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public SearchCriteria city(String city) {
        this.city = city;
        return this;
    }

    public SearchCriteria area(String area) {
        this.area = area;
        return this;
    }

    public SearchCriteria cuisine(String cuisine) {
        this.cuisine = cuisine;
        return this;
    }

    public SearchCriteria costOfTwo(Double costOfTwo) {
        this.costOfTwo = costOfTwo;
        return this;
    }

    public SearchCriteria restaurantType(String restaurantType) {
        this.restaurantType = RestaurantType.valueOf(restaurantType);
        return this;
    }

    public boolean matches(Restaurant restaurant) {
        return (restaurantName == null || restaurant.getRestaurantName().equalsIgnoreCase(restaurantName))
            && (city == null || restaurant.getCity().equalsIgnoreCase(city))
            && (area == null || restaurant.getArea().equalsIgnoreCase(area))
            && (cuisine == null || restaurant.getCuisine().equalsIgnoreCase(cuisine))
            && (costOfTwo == null || restaurant.getCostOfTwo().equals(costOfTwo))
            && (restaurantType == null || restaurant.getRestaurantType().equals(restaurantType));
    }

}
