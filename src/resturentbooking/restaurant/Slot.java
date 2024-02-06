package resturentbooking.restaurant;

import java.util.Date;

public class Slot {
    Date startTime;
    Date endTime;
    Boolean isCompleted;

    public Slot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isCompleted = false;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
}
