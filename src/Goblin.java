public class Goblin extends Creature implements Fighter {

    public Goblin() {
        super("Гоблин", 10, 20);
    }

    private void getBuff() {
        if ((int) (Math.random() * 4) == 1) {
            if (isBuff()) {
                setBuffDuration(getBuffDuration() + 1);
                System.out.printf("%s продлевает усиление ловкости на 1 ход.\n", getName());
            } else {
                setBuff(true);
                setBuffDuration(getBuffDuration() + 1);
                setAgility(getAgility() + 30);
                System.out.printf("%s получает усиление ловкости на 30 единиц на 2 хода.\n",
                        getName());
            }
        }
    }

    private void deBuff() {
        if (getBuffDuration() > 0) {
            setBuffDuration(getBuffDuration() - 1);
        } else if (isBuff()) {
            setBuff(false);
            setAgility(getAgility() - 30);
            System.out.println("Усиление ловкости заканчивается.");
        }
    }

    @Override
    public void attack(Creature enemy) {
        getBuff();
        super.attack(enemy);
        deBuff();
    }
}
