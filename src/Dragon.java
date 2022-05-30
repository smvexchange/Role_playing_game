public class Dragon extends Creature implements Fighter {

    public Dragon() {
        super("Дракон", 100, 200);
        setHealth(200);
        setStrength(50);
    }

    private void extraAttack(Creature enemy) {
        if ((int) (Math.random() * 4) == 1) {
                enemy.setHealth(enemy.getHealth() - 5);
                System.out.printf("%s дышит огнем! %s получает ожог на 5 единиц.\n",
                        getName(), enemy.getName());
        }
    }

    @Override
    public void attack(Creature enemy) {
        extraAttack(enemy);
        super.attack(enemy);
    }
}
