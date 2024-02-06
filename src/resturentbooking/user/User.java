package resturentbooking.user;

import resturentbooking.ObjectDto;

public abstract class User extends ObjectDto {
    String name;
    String city;

    protected User(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

}
