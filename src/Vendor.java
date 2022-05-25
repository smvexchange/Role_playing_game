public class Vendor extends Entity {
    private final int healingPotionPrice = 10;
    private final int scrollOfPowerPrice = 15;

    public Vendor() {
        super("Торговец");
    }

    public int getHealingPotionPrice() {
        return healingPotionPrice;
    }

    public int getScrollOfPowerPrice() {
        return scrollOfPowerPrice;
    }
}
