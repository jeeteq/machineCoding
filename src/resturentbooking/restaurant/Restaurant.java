package resturentbooking.restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import resturentbooking.ObjectDto;
import resturentbooking.user.User;

public class Restaurant extends ObjectDto {
    User owner;

    String restaurantName;
    String city;
    String area;
    String cuisine;

    Double costOfTwo;

    RestaurantType restaurantType;

    Integer noOfTable;

    Integer allowableMaxDayToPreBook = 5;

    List<Slot> bookedSlots;

    public Restaurant(User owner, String restaurantName, String city, int noOfTable) {
        super();
        this.owner = owner;
        this.restaurantName = restaurantName;
        this.city = city;
        this.noOfTable = noOfTable;
        this.bookedSlots = new ArrayList<>();
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Double getCostOfTwo() {
        return costOfTwo;
    }

    public void setCostOfTwo(Double costOfTwo) {
        this.costOfTwo = costOfTwo;
    }

    public Integer getAllowableMaxDayToPreBook() {
        return allowableMaxDayToPreBook;
    }

    public void setAllowableMaxDayToPreBook(Integer allowableMaxDayToPreBook) {
        this.allowableMaxDayToPreBook = allowableMaxDayToPreBook;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public RestaurantType getRestaurantType() {
        return this.restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        setRestaurantType(RestaurantType.valueOf(restaurantType));
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        if (Objects.isNull(restaurantType)) {
            this.restaurantType = RestaurantType.BOTH;
        } else {
            this.restaurantType = restaurantType;
        }
    }

    public String getCity() {
        return this.city;
    }

    public String getArea() {
        return this.area;
    }

    public List<Slot> getUpcomingSlots() {
        return this.bookedSlots;
    }

    public void setBookedSlots(List<Slot> slots) {
        Collections.sort(slots, Comparator.comparing(Slot::getStartTime));
        this.bookedSlots = slots;
    }

    public Integer getNoOfTable() {
        return this.noOfTable;
    }
}
