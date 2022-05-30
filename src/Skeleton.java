public class Skeleton extends Creature implements Fighter {

    public Skeleton() {
        super("Скелет", 10, 20);
    }

    private void getBuff() {
        if ((int) (Math.random() * 4) == 1) {
            if (isBuff()) {
                setBuffDuration(getBuffDuration() + 2);
                System.out.printf("%s продлевает усиление силы на 2 хода.\n", getName());
            } else {
                setBuff(true);
                setBuffDuration(getBuffDuration() + 2);
                setStrength(getStrength() + 5);
                System.out.printf("%s получает усиление силы на 5 единицы на 3 хода.\n",
                        getName());
            }
        }
    }

    private void getDeBuff() {
        if (getBuffDuration() > 0) {
            setBuffDuration(getBuffDuration() - 1);
        } else if (isBuff()) {
            setBuff(false);
            setStrength(getStrength() - 5);
            System.out.println("Усиление силы заканчивается.");
        }
    }

    @Override
    public void attack(Creature enemy) {
        getBuff();
        super.attack(enemy);
        getDeBuff();
    }
}
