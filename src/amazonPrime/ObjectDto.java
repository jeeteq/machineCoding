package amazonPrime;

public abstract class ObjectDto {
    static Long UUID = 0L;
    Long id;

    protected ObjectDto() {
        this.id = ++UUID;
    }

    protected Long getId() {
        return this.id;
    }
}
