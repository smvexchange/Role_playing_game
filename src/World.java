public class World {
    Hero hero;
    Skeleton skeleton;
    Goblin goblin;
    Dragon dragon;
    Vendor vendor;

    public World(Hero hero) {
        this.hero = hero;
        this.skeleton = new Skeleton();
        this.goblin = new Goblin();
        this.dragon = new Dragon();
        this.vendor = new Vendor();
    }
}
