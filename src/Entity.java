public abstract class Entity {
    protected final String name;
    protected int health;
    protected int experience;
    protected int strength;
    protected int agility;
    protected int gold;

    public Entity(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.strength = 20;
        this.agility = 10;
        this.gold = 20;
    }
}
