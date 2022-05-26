import java.util.Objects;

public abstract class Stuff {
    String description;
    int quantity;

    public Stuff(String description) {
        this.description = description;
        this.quantity = 0;
    }

    abstract void use(Hero hero);


    public String toString() {
        return description + " - " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stuff stuff = (Stuff) o;
        return Objects.equals(description, stuff.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
