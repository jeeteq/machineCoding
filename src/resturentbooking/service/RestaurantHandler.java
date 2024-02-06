package resturentbooking.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import resturentbooking.exception.BookingException;
import resturentbooking.restaurant.Restaurant;
import resturentbooking.restaurant.RestaurantDb;
import resturentbooking.restaurant.Slot;


public class RestaurantHandler {
    private final RestaurantDb restaurantDb;

    public RestaurantHandler(RestaurantDb restaurantDb) {
        this.restaurantDb = restaurantDb;
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurantDb.addRestaurant(restaurant);
    }

    public Restaurant searchRestaurant(SearchCriteria searchCriteria) {
        return restaurantDb.getListofRestaurant()
            .stream()
            .filter(searchCriteria::matches)
            .findFirst()
            .orElse(null);
    }

    public void bookSlot(Restaurant restaurant, Date bookingDate, Integer durationOfBooking) {
        List<Slot> nextSlots = restaurant.getUpcomingSlots();
        Date currDate = new Date();

        validateBookingDate(bookingDate, currDate, restaurant);

        Date endTime = new Date(currDate.getTime() + durationOfBooking * 60 * 60 * 1000L);
        Slot slot = new Slot(bookingDate, endTime);

        validateTableAvailability(nextSlots, slot, restaurant);

        nextSlots.add(slot);
    }

    private void validateBookingDate(Date bookingDate, Date currDate, Restaurant restaurant) {
        if (bookingDate.before(currDate)) {
            throw new BookingException("Only Future Booking date allowed");
        }
        long timeDifference = bookingDate.getTime() - currDate.getTime();
        long maxDaysMillis = restaurant.getAllowableMaxDayToPreBook() * 24 * 60 * 60 * 1000L;
        if (timeDifference > maxDaysMillis) {
            throw new BookingException("Booking date exceeds allowable max days to pre-book");
        }
    }

    private void validateTableAvailability(List<Slot> slots, Slot newSlot, Restaurant restaurant) {
        int maxTableNeeded = calculateMaxTablesNeeded(slots, newSlot);
        if (maxTableNeeded > restaurant.getNoOfTable()) {
            throw new BookingException("All Tables are filled within the given slots");
        }
    }

    private int calculateMaxTablesNeeded(List<Slot> slots, Slot newSlot) {
        List<Slot> slotList = new ArrayList<>(slots);
        slotList.add(newSlot);
        PriorityQueue<Slot> pq = new PriorityQueue<>(Comparator.comparing(Slot::getEndTime));
        int maxTablesNeeded = 0;

        for (Slot slot : slotList) {
            while (!pq.isEmpty() && pq.peek().getEndTime().before(slot.getStartTime())) {
                pq.poll();
            }
            pq.add(slot);
            maxTablesNeeded = Math.max(maxTablesNeeded, pq.size());
        }
        return maxTablesNeeded;
    }
}
