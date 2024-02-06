package resturentbooking;

public abstract class ObjectDto {
    static long uuid = 0;
    Long id;
    protected ObjectDto(){
        this.id = uuid++;
    }

}
